package co.ceiba.soaptrm.consumotrm.impl;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import co.com.sc.nexura.superfinanciera.action.generic.services.trm.action.TCRMServicesInterface;
import co.com.sc.nexura.superfinanciera.action.generic.services.trm.action.TCRMServicesWebService;
import co.com.sc.nexura.superfinanciera.action.generic.services.trm.action.TcrmResponse;

public class trmImpl implements Itrm {

	TCRMServicesInterface trmServices;

	public trmImpl() {
		if (null == trmServices) {
			URL url = null;
			TCRMServicesWebService trmServicesWeb = new TCRMServicesWebService(url);
			this.trmServices = trmServicesWeb.getTCRMServicesWebServicePort();
		}
	}

	public trmImpl(String endpoint) {
		if (null == trmServices) {
			//URL url;
			try {
				// url = new URL(endpoint);
				// TCRMServicesWebService trmServicesWeb = new TCRMServicesWebService(url);
				// this.trmServices = trmServicesWeb.getTCRMServicesWebServicePort();

				TCRMServicesWebService trmServicesWeb = new TCRMServicesWebService();
				this.trmServices = trmServicesWeb.getTCRMServicesWebServicePort();
				BindingProvider bindingProvider = (BindingProvider) this.trmServices;
				bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

			} catch (Exception e) {
				System.out.println("Error iniciando endpoint " + e.getMessage());
			}
		}
	}

	@Override
	public TcrmResponse queryTCRM(XMLGregorianCalendar tcrmQueryAssociatedDate) {
		TcrmResponse response = null;

		try {
			response = this.trmServices.queryTCRM(tcrmQueryAssociatedDate);
			return response;
		} catch (Exception e) {
			System.out.println("Error respuesta del servicio " + e.getMessage());
		}
		return response;

	}

}
