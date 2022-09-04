package com.furama.model.facility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityType {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "rentType")
    private List<Facility> facilityList;
}
