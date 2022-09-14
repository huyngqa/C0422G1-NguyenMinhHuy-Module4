let currentPage = 0;
let lastPage = -1;

$("#previous").click(function () {
    if (currentPage === 0) {
        showListContract(0);
    } else {
        showListContract(--currentPage);
    }
});

$("#next").click(function () {
    if (lastPage === currentPage) {
        showListContract(lastPage);
    } else {
        showListContract(++currentPage);
    }
});

showListContract(currentPage);

function showListContract(pageNumber) {
    let keyword = $("#keyword-contract").val();
    $("#keyword-contract").val(keyword);
    $.ajax({
        header: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "/restContract?keyword=" + keyword + "&page=" + pageNumber,
        success: function (contractPage) {
            lastPage = contractPage.totalPages - 1;
            let contracts = contractPage.content;
            let result = "";
            let totalMoney;
            let detailList;
            for (let i = 0; i < contracts.length; i++) {
                detailList = contracts[i].contractDetails;
                totalMoney = contracts[i].facility.cost
                if (detailList.length > 0) {
                    for (let j = 0; j < detailList.length; j++) {
                        totalMoney +=
                            (detailList[j].quantity * detailList[j].attachFacility.cost);
                    }
                }
                result += `<tr>
                                    <td>${(i + 1)}</td>
                                    <td>${contracts[i].facility.name}</td>
                                    <td>${contracts[i].facility.cost}</td>
                                    <td>${contracts[i].customer.name}</td>
                                    <td>${contracts[i].startDate}</td>
                                    <td>${contracts[i].endDate}</td>
                                    <td>${contracts[i].deposit}</td>
                                    <td>${totalMoney}</td>
                                    <td>
                                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                data-bs-target="#addDetail" onclick="showModalAttach('${contracts[i].id}')">
                                            <i class="material-icons">&#xE147;</i>
                                        </button>
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" 
                                                data-bs-target="#editContract" 
                                                onclick="showFormEditContract('${contracts[i].id}','${contracts[i].facility.id}')">
                                                <i class="material-icons"
                                                    data-toggle="tooltip" title="Edit">&#xE254;</i>
                                        </button>
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                onclick="showAttachFacility('${contracts[i].id}')"
                                                data-bs-target="#accompanyingServices">
                                            List Included Services
                                        </button>
                                    </td>
                                </tr>`
            }
            $("#table-contract").html(result).css("color", "black");
            if(isNaN(pageNumber)) {
                $("#numberPage").text(1);
            } else {
                $("#numberPage").text(pageNumber + 1);
            }
            $("#totalPage").text(contractPage.totalPages);
        },
        error: function (resultError) {
            console.log("lỗi")
        }
    });
};

function showAttachFacility(id) {
    $.ajax({
        header: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "/restContractDetail/" + id,
        success: function (contractDetails) {
            console.log(contractDetails)
            let result = "";
            for (let i = 0; i < contractDetails.length; i++) {
                result += `<tr>
                                    <td>${(i + 1)}</td>
                                    <td>${contractDetails[i].attachFacility.name}</td>
                                    <td>${contractDetails[i].attachFacility.cost}</td>
                                    <td>${contractDetails[i].attachFacility.unit}</td>
                                    <td>${contractDetails[i].attachFacility.status}</td>
                                    <td>${contractDetails[i].quantity}</td>
                                </tr>`
            }
            $("#data-contract-details").html(result).css("color", "black");
        },
        error: function (resultError) {
            $("#data-contract-details").html("<p>No service include</p>").css("color", "red");
        }
    });
};

function showService() {
    document.getElementById("tableFacilityContract").style.display = 'block'
    document.getElementById("buttonHide").style.display = 'block'
}

function hideAttachFacility() {
    document.getElementById("tableFacilityContract").style.display = 'none'
    document.getElementById("buttonHide").style.display = 'none'
}

function showFormEditContract(contractId, facilityId) {
    $.ajax({
        header: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "/facilityRest",
        success: function (facilityList) {
            let result = "<label for='selectFacility'>Choose Facility</label>" +
                "<select id='selectFacility' name='selectFacility'>";
            for (let i = 0; i < facilityList.length; i++) {
                if(facilityId == facilityList[i].id) {
                    result += `<option value="${facilityList[i].id}" selected>${facilityList[i].name}</option>`;
                }
                result += `<option value="${facilityList[i].id}">${facilityList[i].name}</option>`;
            }
            result += "</select>"
            $("#idContract").val(contractId);
            $("#select-facility").html(result);
        }
    });
};

let resultListAttach = "";

$(".table-attach-facility").ready(function (){
    $.ajax({
        header: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "/attachRest",
        success: function (attachFacility) {
            for (let i = 0; i < attachFacility.length; i++) {
                resultListAttach += `<tr>
                                <td><input type="checkbox" value="${attachFacility[i].id}">${attachFacility[i].name}</td>
                                <td>${attachFacility[i].unit}</td>
                                <td>${attachFacility[i].cost}</td>
                                <td><input style="width:50px" id="id-quantity${i+1}" type="number"></td>
                           </tr>`
            }
        },
    });
});

function showModalAttach(id) {
    $("#id-contract-in-attach").val(id);
    $(".table-attach-facility").html(resultListAttach);
    $("#mess").text("")
}

$("#btn-add-attach").click(function () {
    let mess = "";
    let arrIdAttach=[];
    let arrQuantity=[];
    let idContract = $("#id-contract-in-attach").val();
    $("#table-add-attach input:checked").each(function () {
        let idQuantity = "#id-quantity" + this.value
        arrIdAttach.push(this.value);
        arrQuantity.push($(idQuantity).val());
    })
    for (let i = 0; i < arrIdAttach.length; i++) {
        let contractDetail = {
            "quantity": arrQuantity[i],
            "attachFacility": {
                "id": arrIdAttach[i]
            },
            "contract": {
                "id": idContract
            }
        }
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "POST",
            url: "/restContractDetail/save",
            data: JSON.stringify(contractDetail),
            success: mess = "success"
        })
    }
    $("#mess").text(mess)
});