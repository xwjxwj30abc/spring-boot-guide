package zx.soft.sample.data.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zx.soft.sample.data.jpa.service.CustomerRepository;

@SpringBootApplication
public class SampleDataJpaApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SampleDataJpaApplication.class);
	}

	@Override
	public void run(String... strings) throws Exception {

		//		repository.save(new Customer("redis", "redis"));

		//		for (Customer customer : repository.findAll()) {
		//			System.out.println(customer);
		//		}
		//
		//		Customer customer = repository.findOne(1L);
		//		System.out.println(customer);
		//
		//		for (Customer bauer : repository.findByLastName("last")) {
		//			System.out.println(bauer);
		//		}
	}
}
