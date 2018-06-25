package co.ceiba.soaptrm.consumotrm.impl;

import javax.xml.datatype.XMLGregorianCalendar;

import co.com.sc.nexura.superfinanciera.action.generic.services.trm.action.TcrmResponse;

public interface Itrm {

	public TcrmResponse queryTCRM(XMLGregorianCalendar tcrmQueryAssociatedDate);

}
