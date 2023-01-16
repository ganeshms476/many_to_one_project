package com.ty_many_to_one_bank_branch.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_many_to_one_bank_branch.dto.Bank;
import com.ty_many_to_one_bank_branch.dto.Branch;

public class BranchDao {
	public EntityManager gEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void saveBranch(List<Branch> list) {
		EntityManager entityManager = gEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		for (Branch branch : list) {
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
		}

	}

	public void updateBranch(List<Branch> branch, int id) {
		EntityManager entityManager = gEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch recievedbranch = entityManager.find(Branch.class, id);
		if (recievedbranch != null) {
			entityTransaction.begin();
			branch.set(id, recievedbranch);
			entityManager.merge(branch);
			entityTransaction.commit();
		} else {
			System.out.println("Branch Does Not Exist");
		}

	}

	public void deleteBranch(int id) {
		EntityManager entityManager = gEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class, id);
		entityTransaction.begin();
		entityManager.remove(branch);
		entityTransaction.commit();
	}

	public void getAllBranch() {
		EntityManager entityManager = gEntityManager();
		Query query = entityManager.createQuery("select b from Branch b");
		List<Branch> list = query.getResultList();
		System.out.println(list);

	}
}
