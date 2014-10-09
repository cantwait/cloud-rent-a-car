package com.cloud.rent.util;

import java.util.Comparator;

import com.cloud.rent.model.core.Company;

public class CompanyComparator implements Comparator<Company>{

	@Override
	public int compare(Company c1, Company c2) {
		if(c1.getLevel() > c2.getLevel())
			return 1;
		else
			return -1;
	}

}
