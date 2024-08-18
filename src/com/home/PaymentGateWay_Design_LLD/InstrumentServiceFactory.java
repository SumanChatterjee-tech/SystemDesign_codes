package com.home.PaymentGateWay_Design_LLD;

public class InstrumentServiceFactory {

	public InstrumentService getInstrumentService(InstrumentType type) {
		if(type == InstrumentType.BANK) {
			return new BankInstrumentService();
		}else if(type == InstrumentType.CARD) {
			return new CardInstrumentService();
		}else {
			return null;
		}
	}
}
