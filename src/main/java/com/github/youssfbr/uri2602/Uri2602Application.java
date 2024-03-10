package com.github.youssfbr.uri2602;

import com.github.youssfbr.uri2602.dtos.CustomerMinDTO;
import com.github.youssfbr.uri2602.projections.CustomerMinProjection;
import com.github.youssfbr.uri2602.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	private final CustomerRepository repository;

    public Uri2602Application(CustomerRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		final List<CustomerMinProjection> list = repository.customerBySql("rs");
		final List<CustomerMinDTO> sqlResult = list.stream().map(CustomerMinDTO::new).toList();

		for (CustomerMinDTO obj : sqlResult) {
			System.out.println(obj);
		}
	}
}
