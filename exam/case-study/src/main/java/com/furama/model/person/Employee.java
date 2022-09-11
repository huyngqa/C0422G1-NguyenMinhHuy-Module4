package com.furama.model.person;

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
public class Employee extends Person{
    private Integer salary;
    private String userName;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<Contract> contracts;
}
