package com.example.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Department;
import com.example.entities.Employee;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeerepo;
	@Autowired
	DepartmentRepository departmentrepo;
	
	
	//////////
	@Autowired
	 DepartmentService departmentService;
	 
	  
	
	
	
	public List<Employee> getAllEmployee(){
		List<Employee> emps=(List<Employee>)employeerepo.findAll();
		
		return emps;
		
	}

	// fetching employee by id
	public Employee getEmployee(int id){
		return employeerepo.findById(id).get();
	}
	//
	
	
	
	
	// inserting employee
	public void addEmployee(Employee e) {
		int id=e.getDepartment().getD_id();
		
		//// getting info of existing dep
		Department existingdt=departmentService.getDepartmentById(id);
		e.setDepartment(existingdt);
		employeerepo.save(e);
	}
	
	
	// updating employee 
	public Employee updateEmployee(Employee employee,int id){
		
		 Employee existingEmployee = getEmployee(id);
		   
	    	existingEmployee.setFirstName(employee.getFirstName());
	    	existingEmployee.setLastName(employee.getLastName());
	    	existingEmployee.setEmail(employee.getEmail());
	    	existingEmployee.setJob_title(employee.getJob_title());
	    	
	    	int d_id=employee.getDepartment().getD_id();
	    	   employee.setDepartment(departmentService.getDepartmentById(d_id));  
	    	existingEmployee.setDepartment(departmentService.getDepartmentById(d_id));
		
		return	employeerepo.save(existingEmployee);
		
	}
	
	
	
	// deleting employee by id
	public void deleteEmployeeByID(int id){
		employeerepo.deleteById(id);
	}
	
	
	
}
