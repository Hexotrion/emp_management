package com.example.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Department;
import com.example.repository.DepartmentRepository;



@Service
public class DepartmentService {
	
	@Autowired
	  private  DepartmentRepository departmentrepo;


	
	
	


public	List<Department> getAllDepartment(){
	List<Department> dept=(List<Department>)departmentrepo.findAll();
	
	
	return dept;
	
	
}


public Department getDepartmentById(int id) {
	
	return  departmentrepo.findById(id).get();

	
}













/////////////////////////////////////////////////////


//
//public Department createDepartment(Department department) {
//	
//	
//	
//
//	
//	
//	
//	
//	
//    Optional<Department> optionalDepartment = Optional.of(new Department());;
//    if (optionalDepartment.isPresent()) {
//        Department existingDepartment = optionalDepartment.get();
//        existingDepartment.setD_Name(department.getD_Name());
//        existingDepartment.setD_id(department.getD_id());
//        
//        // ...
//        return departmentrepo.save(existingDepartment);
//    }
//    // Handle the case when the department does not exist
//    // Create a new department or throw an exception
//    return null;
//}




}
