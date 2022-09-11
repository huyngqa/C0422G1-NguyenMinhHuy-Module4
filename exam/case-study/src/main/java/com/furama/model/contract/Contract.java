package com.furama.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.furama.model.facility.Facility;
import com.furama.model.person.Customer;
import com.furama.model.person.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private Double deposit;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facility;
    @OneToMany(mappedBy = "contract", cascade = CascadeType.REMOVE)
    private List<ContractDetail> contractDetails;
}
