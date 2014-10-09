package com.cloud.rent.util;

import java.util.Comparator;

import com.cloud.rent.model.security.Transaction;

public class TransactionComparator implements Comparator<Transaction>{

	@Override
	public int compare(Transaction t1, Transaction t2) {
		if(t1.getLevel() > t2.getLevel())
			return 1;
		else
			return -1;
	}

}
