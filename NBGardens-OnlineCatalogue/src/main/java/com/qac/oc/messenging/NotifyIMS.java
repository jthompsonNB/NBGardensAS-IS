package com.qac.oc.messenging;

import java.util.logging.Logger;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;
import static javax.jms.DeliveryMode.PERSISTENT;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.jboss.ejb3.annotation.ResourceAdapter;

import static com.qac.util.messenging.MessageDestinations.new_customer_for_catalogue_queue;
import com.qac.util.messages.Customer;

@Named("notifyIMS")
@Stateless
@ResourceAdapter("activemq-ra.rar")
public class NotifyIMS {
	private static final Logger logger = Logger.getLogger("notifyIMSLogger");
	@Resource(mappedName = "java:/activemq/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	private Connection connection;
	@Resource(mappedName = "java:/activemq/queue_out")
	private Destination queue;

	public void newCustomerForCatalogue(Customer customer) {
		Session session = null;
		MessageProducer producer = null;
		try {
			init();
			session = connection.createSession(true, AUTO_ACKNOWLEDGE);
			queue = session.createQueue(new_customer_for_catalogue_queue.toString());
			producer = session.createProducer(queue);
			producer.setDeliveryMode(PERSISTENT);
			ObjectMessage message = session.createObjectMessage(customer);
			producer.send(message);
		} catch(JMSException e) {
			e.printStackTrace();
		} finally {
			if(producer != null) try {
				producer.close();
			} catch(JMSException e) {
				logger.warning("Exception when closing message producer. May not have been properly created.");
			} if (session != null) try {
				session.close();
			} catch(JMSException e) {
				logger.warning("Exception when closing session. May not have been properly created.");
			}
			try {
				destroy();
			} catch(JMSException e) {
				logger.warning("Exception when closing connection. May not have been properly created.");
			}
		}
	}

	private void init() throws JMSException {
		logger.info("Starting JMS Connection");
		connection = connectionFactory.createConnection();
		connection.start();
	}

	private void destroy() throws JMSException {
		logger.info("Closing JMS Connection");
	}
}