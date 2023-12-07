package com.section1.spring.datajpa.controller;

import java.math.BigDecimal;
import java.util.List;

import com.section1.spring.datajpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
