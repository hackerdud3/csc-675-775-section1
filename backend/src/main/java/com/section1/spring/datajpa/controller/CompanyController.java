package com.section1.spring.datajpa.controller;

import java.math.BigDecimal;
import java.util.List;

import com.section1.spring.datajpa.model.Employees;
import com.section1.spring.datajpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.section1.spring.datajpa.model.Company;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CompanyController {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	PurchasesRepository purchasesRepository;
//	@GetMapping("/company")
//	public ResponseEntity<List<Company>> getAllCompanies() {
//		try {
//			List<Company> companies = new ArrayList<>();
//			companyRepository.findAll().forEach(companies::add);
//
//			if (companies.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//
//			return new ResponseEntity<>(companies, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@GetMapping("/company")
	public List<Company> allEvents() {
		return companyRepository.findAll();
	}

	@GetMapping("/profit")
	public List<Company> getCompanyWithProfit(@RequestParam("value") BigDecimal value){
		return companyRepository.findCompaniesByOperationalCostGreaterThan(value);
	}

	@GetMapping("/salary")
	public List<EmployeeSalaryStats> getEmployeesBySalary(@RequestParam("inputValue") double value){
		return employeeRepository.findRoleMaxSalaryAvgSalary(value);
	}

	@GetMapping("/purchases")
	public List<PurchasesRepositoryStats> getPurchaseQuantity(@RequestParam("quantity") Integer quantity){
		return purchasesRepository.findProductNamesAndTotalQuantity(quantity);
	}

	@PostMapping("/addemployee")
	public ResponseEntity<Employees> addEmployeeDetails(@RequestBody Employees emp) {
		Employees employees = new Employees();
		employees.setSsn(emp.getSsn());
		employees.setRole(emp.getRole());
		employees.setSalary(emp.getSalary());

		Employees savedEmployee = employeeRepository.save(employees);

		if (savedEmployee != null) {
			return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/search")
	public List<Company> searchCompaniesByName(@RequestParam("name") String name) {
		return companyRepository.findByNameContainingIgnoreCase(name);
	}
}
