package com.example.demo.Entity;

import com.example.demo.Entity.Address;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Employeee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String empName;
    private Integer empAge;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "forgin_key")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address",referencedColumnName = "empId")
    private List<Address> address;
}
