package com.home.PaymentGateWay_Design_LLD;

public class InstrumentController {
	InstrumentServiceFactory instrumentServiceFactory;

	public InstrumentController(InstrumentServiceFactory instrumentServiceFactory) {
		super();
		this.instrumentServiceFactory = instrumentServiceFactory;
	}
	
	public Instrument addInstrument(Instrument ins) {
		InstrumentService instrumentService =  instrumentServiceFactory.getInstrumentService(ins.getType());
		return instrumentService.addInstrument(ins);
	}
	
	//add other methods also
}
