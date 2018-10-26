package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    // autowire the repository page to access the CRUD operations
    @Autowired
    AtmRepository atmRepository;

    // get the list of all transaction

    @GetMapping("/")
    public String showTransaction(Model model){

        model.addAttribute("atms",atmRepository.findAll());

        return "transaction";
    }

    // create an account
  /*  @GetMapping("/create")
    public String addAccount(Model model){
        model.addAttribute("atm", new ATM());
        return "depositform";

    }*/

    // add deposit balance
   /* @GetMapping("/adddeposit")
    public String addDeposit(@PathVariable ("accountNum") String accountnum,  Model model){

        model.addAttribute("atm",new ATM());

        return "depositform";
    }
*/
    // add deposit to specific account
    @GetMapping("/adddeposit/{id}")
    public String addDeposit(@PathVariable("id") long id, ATM atm,  Model model){


     model.addAttribute("atm", atmRepository.findById(id));

        return "depositform";
    }




    // save the deposit
    @PostMapping("/deposit")
    public String saveDeposit(@Valid ATM atm,  Model model){

       // atm.setAmount(amount);
       model.addAttribute("atm",atmRepository.save(atm));
        return "redirect:/";
    }

    // withdraw
    @GetMapping("/makewithdraw/{id}")
    public String withdraw(@PathVariable ("id") long id, Model model){
        model.addAttribute("atm",atmRepository.findById(id));
        return "Withdrawform";

    }
    @PostMapping("/makewithdraw")
    public String makeWithdraw(@Valid ATM atm, BindingResult result){

        if(result.hasErrors()){
            return "withdrawform";
        }

        atmRepository.save(atm);
        return "redirect:/";
    }

   /* // to see the detail of each car with id
    @GetMapping("/withdraw/{id}")
    public String makeWithdraw(@PathVariable("id") long id,  Model model){



        model.addAttribute("atm", atmRepository);
        return "show";
    }
*/



}
