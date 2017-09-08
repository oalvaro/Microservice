package com.everis.training.microservice.commons.dao.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.everis.training.microservice.commons.entity.FinancialTransaction;


public interface FinancialTransactionRepository extends CrudRepository<FinancialTransaction, UUID> {
	
	@Query("select * from FinancialTransaction where accountnumber=:accountnumber")

	List<FinancialTransaction> findByAccount(@Param("accountnumber") String accountnumber);
	
	@Query("select * from FinancialTransaction where transactiontype=:transactiontype")
	List<FinancialTransaction> findByFinancialTransactionType(@Param("transactiontype") String transactiontype);
	
	@Query("select * from FinancialTransaction where cardnumber=?0 AND transactiontype=?1 ALLOW FILTERING")
	List<FinancialTransaction> findByCardnumberType(@Param("cardnumber") String cardnumber, 
			@Param("transactiontype") String transactiontype);
	
	@Query("select * from FinancialTransaction where accountnumber=:#{#financialTransaction.accountnumber}")
	FinancialTransaction findFTByCardnumber(@Param("financialTransaction") FinancialTransaction financialTransaction);
	
	@Query("select * from FinancialTransaction where cardnumber=:cardnumber ALLOW FILTERING")
	FinancialTransaction findByCardnumber(@Param("cardnumber") String cardnumber);
}

