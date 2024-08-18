package com.home.PaymentGateWay_Design_LLD;

import java.util.*;

import com.home.PaymentGateWay_Design_LLD.Instrument;

public abstract class InstrumentService {

	static Map<Integer, List<Instrument>> userIntruments = new HashMap<>();
	
	public abstract Instrument addInstrument(Instrument ins);
	public abstract Instrument getInstrumentByUserID(int userID);
}


