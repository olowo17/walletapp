package myClass;

public class AccountBalance {
    private String name;
    private double balance;


    public AccountBalance(String name, double balance) {
        this.name = name;
        if( balance>0)
            this.balance = balance;
    }
    public double deposit(double amount){
        if (amount>0)
            balance+=amount;
     
        return getBalance();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}
