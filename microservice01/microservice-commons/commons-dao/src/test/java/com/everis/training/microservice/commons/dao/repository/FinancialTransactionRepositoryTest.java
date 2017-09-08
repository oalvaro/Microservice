package com.everis.training.microservice.commons.dao.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.everis.training.microservice.commons.dao.test.base.BaseTest;
import com.everis.training.microservice.commons.entity.FinancialTransaction;

public class FinancialTransactionRepositoryTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(FinancialTransactionRepositoryTest.class);
	
	@Autowired
	FinancialTransactionRepository financialTransactionRepository;
	
	@Test
	public void findAll(){
		logger.info(financialTransactionRepository.findAll());
	}
	@Test
	public void save(){
		FinancialTransaction f=new FinancialTransaction();
		f.setId(UUID.randomUUID());
		f.setAccountname("acount");
		f.setAccountnumber("1237");
		f.setAmount(BigDecimal.valueOf(200));
		f.setCardnumber("123456789");
		f.setCreateddate(new Date());
		f.setTransactiontype("credit");
		logger.info(financialTransactionRepository.save(f));

	}
	@Test
	public void delete(){
		List<FinancialTransaction> lts = new ArrayList<>();
		lts = financialTransactionRepository.findByAccount("1234");
		for(FinancialTransaction financialt : lts) {
			financialTransactionRepository.delete(financialt.getId());
		}
		logger.info(financialTransactionRepository.findByAccount("1234"));
	}
	@Test
	public void update(){
		List<FinancialTransaction> lts = new ArrayList<>();
		lts = financialTransactionRepository.findByCardnumberType("123456789", "debit");
		for (FinancialTransaction ft : lts) {
			ft.setCardnumber("987656786");
			ft.setAmount(BigDecimal.valueOf(50));
			ft.setAccountnumber("1232");
			financialTransactionRepository.save(ft);
		}
		financialTransactionRepository.findByAccount("1230");
	}
	@Test
	public void findByAccount(){
		logger.info(financialTransactionRepository.findByAccount("1234"));
	}
	
	@Test 
	public void findByFinancialTransactionType(){
		logger.info(financialTransactionRepository.findByFinancialTransactionType("credit"));
	}
	@Test
	public void findByCardnumberType(){
		logger.info(financialTransactionRepository.findByCardnumberType("123456789", "credit"));
	}
	@Test
	public void findFTByCardnumber(){
		FinancialTransaction fn = new FinancialTransaction();		
		fn.setAccountnumber("1237");
		logger.info(financialTransactionRepository.findFTByCardnumber(fn));
	}
	@Test
	public void findByCardnumber(){
		logger.info(financialTransactionRepository.findByCardnumber("123456789"));
	}
	
}
