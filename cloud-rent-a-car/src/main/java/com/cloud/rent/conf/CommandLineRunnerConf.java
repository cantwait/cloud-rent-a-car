package com.cloud.rent.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cloud.rent.repository.core.CompanyRepository;

@Component
public class CommandLineRunnerConf implements CommandLineRunner{
	
	@Autowired
	private CompanyRepository repository;

	@Override
	public void run(String... arg0) throws Exception {
		System.err.println(this.repository.findAll());
	}

}


