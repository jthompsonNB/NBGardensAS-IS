package com.qac.oc.messenging;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;

import com.qac.util.messages.Customer;
import com.qac.util.messenging.MessageDestinations;

@Named("notifyIMS")
@Stateless
public class NotifyIMS {
	private static final Logger logger = Logger.getLogger("notifyIMS");
//	@Inject
//	private JMSContext context;
	
	public void newCustomerForCatalogue(Customer customer) {
		try{
			logger.info("preparing to send IMS a new customer to add to catalogue mailing list.");
//			context.createProducer().send(context.createQueue(MessageDestinations.newCustomerForCatalogue), customer);
			logger.info("sent IMS a new customer to add to the catalogue mailing list.");
		} catch (JMSRuntimeException e) {
			logger.severe(e.getMessage());
		}
	}
}