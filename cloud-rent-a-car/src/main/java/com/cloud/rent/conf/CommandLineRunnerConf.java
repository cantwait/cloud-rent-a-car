package com.cloud.rent.conf;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class CommandLineRunnerConf implements CommandLineRunner{
	
	@Autowired
	private CompanyRepository repository;

	@Override
	public void run(String... arg0) throws Exception {
		System.err.println(this.repository.findAll());
	}

}

@Repository
interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

}

@Entity
class Company {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}


	
	public Date getCreated() {
		return created;
	}



	public void setCreated(Date created) {
		this.created = created;
	}



	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", description="
				+ description + ", created=" + created + "]";
	}


	
	
}
