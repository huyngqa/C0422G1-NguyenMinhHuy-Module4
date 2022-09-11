package com.furama.model.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationDegree {
    @Id
    private Integer id;
    private String customerTypeName;
    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employees;
}
