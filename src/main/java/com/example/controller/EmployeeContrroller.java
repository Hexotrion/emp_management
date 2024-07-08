package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entities.Employee;
import com.example.services.DepartmentService;
import com.example.services.EmployeeService;

@Controller
public class EmployeeContrroller {

	



	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	


	
	
	
	/////////////////////////////displaying list of all employees
	@GetMapping("/employees")

	public String getAllEmployee(Model model){	
	model.addAttribute("employees", employeeService.getAllEmployee());	
	return "employees";
	}
	

	
	
	
	 ///////////////add employees show data and model
	@GetMapping("/employees/new")
	public String empform(Model model) {
		
		Employee employee= new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("departments", departmentService.getAllDepartment());
			
		return "addEmployee";//it will have the action url for the below method
	}
	
	
	////////it will save the data
	@PostMapping("/employees")
	public String addEmployees(@ModelAttribute("employee") Employee employee){
		employeeService.addEmployee(employee);
		return "redirect:/employees";
	}
	

	/////////////deleting employee by id
	@GetMapping("employees/delete/{id}")
	public String deleteEmployeeByID( @PathVariable int id){
		employeeService.deleteEmployeeByID(id);
		return "redirect:/employees";
	}

	
	
	
	///////////////////////////////////////edit employee form
	  @GetMapping("/employees/edit/{id}")
	    public String editEmpForm(@PathVariable Integer id, Model model) {
	    	
	    	model.addAttribute("employee",employeeService.getEmployee(id));
	    	model.addAttribute("departments", departmentService.getAllDepartment());
	    	
	    	return "editEmployee";
	    	
	    }
	
	  ////////////////////////////////////update employee
	   @PostMapping("/employees/{id}")
	    public String updateEmp(@PathVariable Integer id, @ModelAttribute("employee") Employee employee) {
	    	// updated employee object
	    	employeeService.updateEmployee(employee,id);
	    	return "redirect:/employees";
	    	
	    }
	
	   
		@GetMapping("/login")
		public String login() {
			return "login";
		}
		
		@GetMapping("/")
	public String getAllEmployees(Model model){
			
			model.addAttribute("employees", employeeService.getAllEmployee());	
		return "employees";
		}
	
	

}