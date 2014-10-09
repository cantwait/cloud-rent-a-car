package com.cloud.rent.util;

import java.util.List;

import com.cloud.rent.model.core.Company.CompanyType;
import com.cloud.rent.model.security.Transaction.TransactionType;

import ch.lambdaj.Lambda;

public class CloudRentalUtils {
	
	public static List<String> getTransactionTypeAsList(){
		return Lambda.extractString(TransactionType.values());
	}
	
	public static List<String> getCompanyTypeAsList(){
		return Lambda.extractString(CompanyType.values());
	}
}
