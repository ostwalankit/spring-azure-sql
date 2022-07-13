package com.probit.azure;

import com.probit.azure.entity.Employee;
import com.probit.azure.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringAzureSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAzureSqlApplication.class, args);
	}

	@Autowired
	private EmployeeRepository repository;

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee){
		return repository.save(employee);
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return repository.findAll();
	}

	@GetMapping("/message")
	public String welcomeMessage(){
		return "Welcome to spring azure SQL services !!!";
	}

}
