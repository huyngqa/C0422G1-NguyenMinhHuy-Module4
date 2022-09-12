package com.furama.model.facility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.furama.model.contract.Contract;
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
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double area;
    private Integer cost;
    private Integer maxPeople;
    @JsonBackReference(value = "rent_type_id")
    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    private RentType rentType;
    @JsonBackReference(value = "facility_type_id")
    @ManyToOne
    @JoinColumn(name = "facility_type_id", referencedColumnName = "id")
    private FacilityType facilityType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numOfFloors;
    @Column(columnDefinition = "TEXT")
    private String facilityFree;
    @JsonBackReference(value = "facility")
    @OneToMany(mappedBy = "facility", cascade = CascadeType.REMOVE)
    private List<Contract> contracts;
}
