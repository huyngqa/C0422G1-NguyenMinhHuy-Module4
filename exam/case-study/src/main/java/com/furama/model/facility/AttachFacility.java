package com.furama.model.facility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.furama.model.contract.ContractDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer cost;
    private String unit;
    private String status;
    @JsonBackReference
    @OneToMany(mappedBy = "attachFacility", cascade = CascadeType.REMOVE)
    private List<ContractDetail> contractDetails;
}
