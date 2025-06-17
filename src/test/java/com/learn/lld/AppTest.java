package com.learn.lld;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.learn.lld.baiscs.problem2.Atm;
import com.learn.lld.baiscs.problem2.BankAccount;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testMainMethod() {
        App.main(new String[] {});
        assertEquals("Hello World!\n", outContent.toString());
    }

    @Test
    public void testAppClassExists() {
        App app = new App();
        assertTrue(app instanceof App);
    }

    @Test
    public void testAtmSingleton() {
        Atm atm1 = Atm.getAtmInstance();
        Atm atm2 = Atm.getAtmInstance();
        assertSame("Singleton should return same instance", atm1, atm2);
    }

    @Test
    public void testBankAccountOperations() {
        BankAccount account = new BankAccount("123456", "John Doe");
        Atm atm = Atm.getAtmInstance();
        assertNotNull(account);

        // Test initial balance
        assertEquals("Current balance in your account 0.0",
                atm.checkBalance(account));

        // Test deposit
        assertEquals("Money deposited successfully updated balance: 1000.0",
                atm.depositMoney(account, 1000.0));

        // Test balance after deposit
        assertEquals("Current balance in your account 1000.0",
                atm.checkBalance(account));

        // Test withdrawal
        assertEquals("Money withdraw successfully updated balance: 500.0",
                atm.withDrawMoney(account, 500.0));

        // Test final balance
        assertEquals("Current balance in your account 500.0",
                atm.checkBalance(account));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDeposit() {
        BankAccount account = new BankAccount("123456", "John Doe");
        Atm atm = Atm.getAtmInstance();
        atm.depositMoney(account, -100.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWithdrawal() {
        BankAccount account = new BankAccount("123456", "John Doe");
        Atm atm = Atm.getAtmInstance();
        atm.withDrawMoney(account, -100.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsufficientFunds() {
        BankAccount account = new BankAccount("123456", "John Doe");
        Atm atm = Atm.getAtmInstance();
        atm.withDrawMoney(account, 100.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAtmNullAccount() {
        Atm atm = Atm.getAtmInstance();
        atm.checkBalance(null);
    }
}
