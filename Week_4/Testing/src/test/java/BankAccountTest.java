import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    BankAccount acc = new BankAccount();

    @Test
    public void depositTest(){
        assertEquals(100,acc.depositAmt(100));
    }

    @Test
    public void withDrawlTest(){
        assertEquals(0,acc.withdraw(100));
    }



    @Test
    public void getBalancetest(){
        acc.depositAmt(100);
        assertEquals(100,acc.getBalance());
    }
}