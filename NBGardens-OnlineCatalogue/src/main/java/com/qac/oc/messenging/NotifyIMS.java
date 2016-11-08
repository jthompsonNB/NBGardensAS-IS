package com.qac.oc.messenging;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;

import com.qac.util.messages.Customer;

@Named("notifyIMS")
@Stateless
//@JMSDestinationDefinition(name = "java:jboss/jms/queue/new_customer_for_catalogue_queue", destinationName="new_customer_for_catalogue_queue", description="new_customer_for_catalogue_queue", interfaceName = "javax.jms.Queue")
public class NotifyIMS {
	private static final Logger logger = Logger.getLogger("notifyIMS");
//	@Resource(mappedName = "jms/new_customer_for_catalogue_queue")
//	private Queue queue;
//	@Inject
//	private JMSContext context;
	
	public void newCustomerForCatalogue(Customer customer) {
		try{
			logger.info("preparing to send IMS a new customer to add to catalogue mailing list.");
//			context.createProducer().send(queue, customer);
			logger.info("sent IMS a new customer to add to the catalogue mailing list.");
		} catch (JMSRuntimeException e) {
			logger.severe(e.getMessage());
		}
	}
}