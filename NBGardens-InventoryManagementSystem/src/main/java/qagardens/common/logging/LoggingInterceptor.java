package qagardens.common.logging;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import qagardens.common.annotations.Loggable;

@Interceptor
@Loggable
@Priority(Interceptor.Priority.LIBRARY_BEFORE + 10)
public class LoggingInterceptor {
	@Inject
	private Logger logger;
	
	@AroundInvoke
	public Object logMethod(InvocationContext invocationContext) throws Exception {
		logger.entering(invocationContext.getTarget().getClass().getName(), invocationContext.getMethod().getName());
		try{
			return invocationContext.proceed();
		} finally {
			logger.exiting(invocationContext.getTarget().getClass().getName(), invocationContext.getMethod().getName());
		}
	}
}