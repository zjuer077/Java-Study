package com.ljt.banktest;
public class BankDemo {
    public static void main(String [] args) {
        CheckingAccount c = new CheckingAccount(101);
        System.out.println("Depositing $500...");
        c.deposit(500.00);
        try {
            System.out.println("\nWithdrawing $400...");
            c.withdraw(400.00);
            System.out.println("\nWithdrawing $200...");
            c.withdraw(200.00);
        }catch(InsufficientFundsException e) {
            System.out.println("Sorry, but you are short $"
                    + e.getAmount());
            e.printStackTrace();
        }
    }
}
