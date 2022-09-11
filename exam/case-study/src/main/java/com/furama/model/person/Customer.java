package com.furama.model.person;

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
public class Customer extends Person {
    private Boolean gender;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;
    @JsonBackReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Contract> contracts;

    public String getStringGender() {
        if(gender) {
            return "nam";
        }
        return "nữ";
    }
}
