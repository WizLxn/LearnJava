package LearnAndTest;


/**
 * Created by lixiaoning on 16/4/4.
 */

class InsufficientFundsException extends Exception
{
    private double amout;

    public InsufficientFundsException(double amout)
    {
        this.amout = amout;
    }

    public double getAmout()
    {
        return amout;
    }
}

class CheckingAccount
{
    private double balance;
    private int number;

    public CheckingAccount(int number)
    {
        this.number = number;
    }
    public void deposit(double amout)
    {
        balance += amout;
    }
    public void withdraw(double amout) throws InsufficientFundsException
    {
        if (amout <= balance)  {
            balance -= amout;
        }
        else  {
            double needs = amout - balance;
            throw new InsufficientFundsException(needs);
        }
    }
    public double getBalance()
    {
        return balance;
    }
    public int getNumber()
    {
        return number;
    }
}

public class BankDemo {
    public static void main(String[] args) {
        CheckingAccount c = new CheckingAccount(101);
        System.out.println("Depositing $500...");
        c.deposit(500.00);
        try {
            System.out.println("\nWithdrawing $100...");
            c.withdraw(100.00);
            System.out.println("\nWithdrawing $600...");
            c.withdraw(600.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Sorry, but you are short $" + e.getAmout());;
            e.printStackTrace();
        }
    }
}
