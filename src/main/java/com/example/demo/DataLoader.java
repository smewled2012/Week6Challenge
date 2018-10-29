package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    AtmRepository atmRepository;

    public void run(String... strings){
        ATM atm1= new ATM("1234",500.0,"deposited in my account ",0.0);
        atmRepository.save(atm1);
        atm1=new ATM("5678",0.0,"No Deposit made ",0.0);
        atmRepository.save(atm1);

    }
}
