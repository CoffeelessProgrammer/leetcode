package io.coffeelessprogrammer.leetcode.easy;

/*
 * Problem: 1672. Richest Customer Wealth
 * Acceptance Rate: 88.2%
 * URL: https://leetcode.com/problems/richest-customer-wealth/
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Richest Customer Wealth.
 * Memory Usage: 38.6 MB, less than 62.47% of Java online submissions for Richest Customer Wealth.
 */

public class RichestCustomerWealth {

    private static int richestCustomer = 0;

    public static int calculate(int[][] accounts) {
        int wealthiestBalance = 0;

        for(int customer=0; customer < accounts.length; ++customer) {
            int currentCustomerBalance = sumCustomerBalances(accounts[customer]);

            if(currentCustomerBalance > wealthiestBalance) {
                richestCustomer = customer+1;
                wealthiestBalance = currentCustomerBalance;
            }
        }

        return wealthiestBalance;
    }

    private static int sumCustomerBalances(int[] balances) {
        int sum = 0;

        for(int bank=0; bank < balances.length; ++bank)
            sum += balances[bank];

        return sum;
    }
}
