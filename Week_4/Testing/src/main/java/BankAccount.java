public class BankAccount {

    public int total = 0;

    public int depositAmt(int money) {
        if (money > 0) {
            total += money;
        }
        return total;
    }

    public int withdraw(int money) {
        if (money > 0 && total >= money) {
            total -= money;
        }
        return total;
    }

    public int getBalance() {
        return total;
    }
}
