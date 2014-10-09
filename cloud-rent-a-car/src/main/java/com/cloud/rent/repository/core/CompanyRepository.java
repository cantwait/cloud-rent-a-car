package com.cloud.rent.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cloud.rent.model.core.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
 
}
