public class Account {
    private static int accountNo = 0;

    private Bill bills[];
    private int accountID;
    private String name;
    private String pass;
    private double balance;
    private String accountType;

    public Account(String name, String pass,String type) {

        accountNo++;
        accountID = accountNo;
        this.name = name;
        this.pass = pass;
        this.balance = 1000;
        accountType = type;

    }


    public static int getAccountNo() {
        return accountNo;
    }

    public static void setAccountNo(int accountNo) {
        Account.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double withdraw) {

        if (withdraw <= balance)
        {
            balance = balance-withdraw;
        }
        else {
            System.out.println("insufficient balance");
        }


    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }


    public void transfer(Account account,double amount){

            this.withdraw(amount);
            account.deposit(amount);

    }
    public void deposit(double amount)
    {
        balance+= amount;
    }

}
