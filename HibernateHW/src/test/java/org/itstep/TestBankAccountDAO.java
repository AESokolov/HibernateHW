package org.itstep;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestBankAccountDAO {

	private BankAccount bankAccount;
	
	@Before
	public void setUp() throws Exception {
		BankAccount bankAccount = new BankAccount("Alex", "Pupkin", "(099)999-99-99", "pupkin@ukr.net", 1000.0, 500.0, 500.0);
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		bankAccountDAO.saveBankAccount(bankAccount);
	}

	@Test
	public void testSaveBankAccount() {
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		BankAccount result = bankAccountDAO.getBankAccount(bankAccount.getId());
		assertNotNull(result);
		assertEquals("Alex", result.getFirstName());
		assertEquals("Pupkin", result.getSecondName());
		assertEquals("(099)999-99-99", result.getTelephone());
		assertEquals("pupkin@ukr.net", result.getEmail());
		assertEquals(Integer.valueOf("1000.0"), result.getCarrency());
		assertEquals(Integer.valueOf("500.0"), result.getAmount());
		assertEquals(Integer.valueOf("500.0"), result.getAmountOfCredit());
		
	}
	
	@Test
	public void testUpdateBankAccount() {
		BankAccount bankAccount1 = new BankAccount("Sigizmund", "Dunplunpenkovski", "(067)599-65-22", "sigizmundok@i.ua", 3000.0, 300.0, 500.0);
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		bankAccountDAO.updateBankAccount(bankAccount1);
		BankAccount result = bankAccountDAO.getBankAccount(bankAccount.getId());
		assertEquals("Sigizmund", result.getFirstName());
		assertEquals("Dunplunpenkovski", result.getSecondName());
		assertEquals("(067)599-65-22", result.getTelephone());
		assertEquals("sigizmundok@i.ua", result.getEmail());
		assertEquals(Integer.valueOf("3000.0"), result.getCarrency());
		assertEquals(Integer.valueOf("300.0"), result.getAmount());
		assertEquals(Integer.valueOf("500.0"), result.getAmountOfCredit());
				
	}
	
	@Test
	public void testGetBankAccount() {
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		BankAccount result = bankAccountDAO.getBankAccount(bankAccount.getId());
		assertNotNull(result);
		assertEquals("Alex", result.getFirstName());
		assertEquals("Pupkin", result.getSecondName());
		assertEquals("(099)999-99-99", result.getTelephone());
		assertEquals("pupkin@ukr.net", result.getEmail());
		assertEquals(Integer.valueOf("1000.0"), result.getCarrency());
		assertEquals(Integer.valueOf("500.0"), result.getAmount());
		assertEquals(Integer.valueOf("500.0"), result.getAmountOfCredit());
				
	}
	
	@Test
	public void testDeleteBankAccount() {
	BankAccountDAO bankAccountDAO = new BankAccountDAO();
	bankAccountDAO.deleteBankAccount(bankAccount);
	BankAccount result = bankAccountDAO.getBankAccount(bankAccount.getId());
	assertNull(result);
	}
	
	@Test
	public void testGetBankAccountByFirstNameAndSecondName() {
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		BankAccount result = bankAccountDAO.getBankAccountByFirstNameAndSecondName(bankAccount.getFirstName(), bankAccount.getSecondName());
		assertEquals("Alex", result.getFirstName());
		assertEquals("Pupkin", result.getSecondName());
			}
	
	@Test
	public void testGetBankAccountByTelephone() {
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		List<BankAccount> result = (List<BankAccount>) bankAccountDAO.getBankAccountByTelephone(bankAccount.getTelephone());
		for (BankAccount bankAccountArray : result) {
		assertEquals("(099)999-99-99", bankAccountArray.getTelephone());
		}
	}
	
	@Test
	public void testGetStudentToSecondName() {
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		List<BankAccount> result = bankAccountDAO.getStudentToSecondName(bankAccount.getSecondName());
		for (BankAccount bankAccountArray : result) {
			assertEquals("Pupkin", bankAccountArray.getSecondName());
		}
	}
	@After
	public void tearDown() throws Exception {
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		bankAccountDAO.deleteBankAccount(bankAccount);
	}
}