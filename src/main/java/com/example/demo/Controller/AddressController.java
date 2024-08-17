package com.example.demo.Controller;

import com.example.demo.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/address")
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;



}
