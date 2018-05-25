package Visitor;

public class AccountsAndInvestment {
    private int IdAccount;
    private double sumOfAccountAndInvestment;

    public int getIdAccount() {
        return IdAccount;
    }

    public void setIdAccount(int idAccount) {
        IdAccount = idAccount;
    }

    public double getSumOfAccountAndInvestment() {
        return sumOfAccountAndInvestment;
    }

    public void setSumOfAccountAndInvestment(double sumOfAccountAndInvestment) {
        this.sumOfAccountAndInvestment = sumOfAccountAndInvestment;
    }

    public AccountsAndInvestment(int idAccount, double sumOfAccountAndInvestment) {
        IdAccount = idAccount;
        this.sumOfAccountAndInvestment = sumOfAccountAndInvestment;
    }
}
