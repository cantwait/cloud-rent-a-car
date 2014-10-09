package com.cloud.rent.conf;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hsqldb.server.Server;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HsqldbServerComponent{
	
	Server server;
	
	public boolean isRunning() {
		return server.isNoSystemExit();
	}

	@PostConstruct
	public void start() {
		System.out.println("Starting HSQLDB Server!");
		server = new Server();
		server.setDatabaseName(0, "cloudrental");
		server.setDatabasePath(0, "mem:cloudrental");
		server.setPort(Integer.valueOf(1234));
		server.setSilent(true);
	}

	@PreDestroy
	public void stop() {
		System.out.println("Shutting down HSQLDB Server!");
		server.shutdown();
	}


}
