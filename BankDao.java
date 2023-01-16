package com.ty_many_to_one_bank_branch.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty_many_to_one_bank_branch.dto.Bank;

public class BankDao {
	public EntityManager gEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	
	public void saveBank(Bank bank) {
		EntityManager entityManager = gEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(bank);
		entityTransaction.commit();
	}
	
	public void updateBank(Bank bank) {
		EntityManager entityManager = gEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Bank bank1 = entityManager.find(Bank.class, bank.getId());

		bank1.setName(bank.getName());
		entityTransaction.begin();
		entityManager.merge(bank1);
		entityTransaction.commit();
	}
	
	public void deleteBank(int id) {
		EntityManager entityManager = gEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Bank bank = entityManager.find(Bank.class, id);
		entityTransaction.begin();
		entityManager.remove(bank);
		entityTransaction.commit();
	}
	
	public void getAllBank(int id) {
		EntityManager entityManager = gEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Bank bank = entityManager.find(Bank.class, id);
		System.out.println(bank);
		
	}
	
	
	
}
