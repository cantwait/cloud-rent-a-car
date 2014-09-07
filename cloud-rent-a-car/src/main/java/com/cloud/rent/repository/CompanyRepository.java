package com.cloud.rent.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cloud.rent.model.Company;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long>{

}
