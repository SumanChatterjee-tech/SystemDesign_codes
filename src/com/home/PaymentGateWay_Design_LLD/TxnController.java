package com.home.PaymentGateWay_Design_LLD;

public class TxnController {

	TransactionService txnService;
	
	public int makePayment(Transaction txnDetails) {
		return txnService.makePayment(txnDetails);
	}
}
