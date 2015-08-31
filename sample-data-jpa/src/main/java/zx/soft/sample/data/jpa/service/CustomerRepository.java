package zx.soft.sample.data.jpa.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import zx.soft.sample.data.jpa.domain.Customer;

@Component
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

	@Query("select u from Customer u where u.firstName = ?#{[0]}")
	List<Customer> findCustomersByFirstName(String firstName);

	@Query("select u from Customer u where u.firstName = :#{#customer.firstname}")
	List<Customer> findUsersByCustomersFirstname(@Param("customer") Customer customer);

}
