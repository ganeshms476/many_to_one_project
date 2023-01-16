package com.ty_many_to_one_bank_branch.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty_many_to_one_bank_branch.DAO.BankDao;
import com.ty_many_to_one_bank_branch.DAO.BranchDao;
import com.ty_many_to_one_bank_branch.dto.Bank;
import com.ty_many_to_one_bank_branch.dto.Branch;

public class Main {
		
		public static void main(String[] args) {
			BankDao bankdao = new BankDao();
			BranchDao branchdao = new BranchDao();
			
			Branch b1 = new Branch();
			b1.setId(1);
			b1.setName("SBI4");
			b1.setIfsc("fre2324");
			b1.setManager("Mani");
			b1.setPhone(56776878);
			b1.setAddress("BLR");
			
			Branch b2 = new Branch();
			b2.setId(2);
			b2.setName("SBI5");
			b2.setIfsc("tze3324");
			b2.setManager("Vinay");
			b2.setPhone(222276676);
			b2.setAddress("Mumbai");
			
			Branch b3 = new Branch();
			b3.setId(3);
			b3.setName("SBI6");
			b3.setIfsc("yoo2324");
			b3.setManager("Kiran");
			b3.setPhone(99997676);
			b3.setAddress("Pune");
			
			List<Branch> list = new ArrayList<Branch>();
			list.add(b1);
			list.add(b2);
			list.add(b3);
			
			Bank bank = new Bank();
			bank.setId(1);
			bank.setName("SBI");
			bank.setHeadOffice("New Delhi");
			
			
			b1.setBank(bank);
			b2.setBank(bank);
			b3.setBank(bank);
			
			bankdao.saveBank(bank);
			bankdao.updateBank( bank);
			bankdao.deleteBank(1);
			bankdao.getAllBank(1);
			
			branchdao.saveBranch(list);
			branchdao.updateBranch(list, 1);
			branchdao.deleteBranch(3);
			branchdao.getAllBranch();
		
					
		}
}















