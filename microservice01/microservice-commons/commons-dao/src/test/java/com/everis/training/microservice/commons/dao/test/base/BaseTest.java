package com.everis.training.microservice.commons.dao.test.base;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/cassandra.xml"})
public class BaseTest {
	
	@BeforeClass
	public static void loadParameters(){
		setConnectionPool();
	}
	
	private static void setConnectionPool(){
		// JNDI Connection
	}
	
}
