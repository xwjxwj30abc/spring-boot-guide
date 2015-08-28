package zx.soft.sample.data.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import zx.soft.sample.data.jpa.domain.Customer;
import zx.soft.sample.data.jpa.service.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository repository;

	@RequestMapping(value = "/customers", method = RequestMethod.PUT, headers = "content-type=application/json")
	@ResponseStatus(HttpStatus.OK)
	public Customer addCustomer(@RequestBody Customer customer) {
		return repository.save(customer);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> findCustomer(@RequestParam String lastName) {
		return repository.findByLastName(lastName);
	}

}
