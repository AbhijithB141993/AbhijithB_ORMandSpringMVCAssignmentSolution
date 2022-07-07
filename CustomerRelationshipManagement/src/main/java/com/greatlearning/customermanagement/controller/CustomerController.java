package com.greatlearning.customermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customermanagement.model.Customer;
import com.greatlearning.customermanagement.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String getAllCustomers (Model theModel) {
		System.out.println("request received");
		
		List<Customer> theCustomers = customerService.findAll();
		
		theModel.addAttribute("Customers", theCustomers);
		
		return "customerslist";
	}

	@RequestMapping("/add")
	public String addCustomer(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("Customer", theCustomer);
		return "savecustomer";
	}

	@RequestMapping("/update")
	public String updateCustomer(@RequestParam("id") int theId,Model theModel) {
		
		Customer theCustomer = customerService.findById(theId);
										
		theModel.addAttribute("Customer", theCustomer);
		
		return "savecustomer";
		   
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		Customer theCustomer;
		if(id != 0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);
		}else 
			
			theCustomer = new Customer(firstName,lastName,email);
		
		customerService.save(theCustomer);
		
		return "redirect:/customers/list";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id) {
		
		customerService.deleteById(id);
		
		return "redirect:/customers/list";
	}
}


