package problemSolving;

import java.util.ArrayList;
import java.util.List;

public class LeetCode27 {
    private long[] balance;

    public LeetCode27(long[] balance) {
        this.balance = balance;
    }

    private boolean isValidAccount(int account) {
        return account >= 1 && account <= balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValidAccount(account1) || !isValidAccount(account2)) return false;
        if (balance[account1-1] < money) return false;
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValidAccount(account)) return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
      if(!isValidAccount(account)) return false;
      if(balance[account-1] < money) return false;
      balance[account-1] -= money;
      return true;
    }

    public static void main(String[] args) {
        LeetCode27 bank = new LeetCode27(new long[]{10, 100, 20, 50, 30});

        // Step 2: Prepare a list to store results
        List<Boolean> results = new ArrayList<>();
        results.add(null); // Corresponds to "Bank" initialization

        // Step 3: Execute operations
        results.add(bank.withdraw(3, 10));     // true
        results.add(bank.transfer(5, 1, 20));  // true
        results.add(bank.deposit(5, 20));      // true
        results.add(bank.transfer(3, 4, 15));  // false
        results.add(bank.withdraw(10, 50));    // false

        // Step 4: Print results
        System.out.println(results);

    }

}
