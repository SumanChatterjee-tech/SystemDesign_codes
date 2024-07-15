package com.home.ATMDesign;


public class TwoHundredProcessor extends CashProcessor {

	public TwoHundredProcessor(CashProcessor nextcashProcessor) {
		super(nextcashProcessor);
	}

    public void withdraw(ATM atm, int remainingAmount) {

        int required =  remainingAmount/2000;
        int balance = remainingAmount%2000;

        if(required <= atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(required);
        }
        else if(required > atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            balance = balance + (required-atm.getNoOfTwoThousandNotes()) * 2000;
         }

        if(balance != 0){
            super.withdraw(atm, balance);
        }
     }
}
