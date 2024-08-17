package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long addressId;
    private String city;
    private String addressType;

//    @OneToOne(mappedBy = "address")
//    private Employeee employeee;
}
