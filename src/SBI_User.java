import java.util.Objects;
import java.util.UUID;
public class SBI_User implements BankInterface{
    private  String name;
    private  String accountNo;
    private double balance;
    private String password;
    private  static double rateOfInterest;

    public SBI_User(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        // here I want to put interest from my own side....
        this.rateOfInterest = 6.5;

        this.accountNo= String.valueOf(UUID.randomUUID());

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        SBI_User.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance = balance + amount;

        return " Money added , your current balance is : "+ balance;
    }

    @Override
    public String withdrawMoney(int amount, String enterPassword) {
// in java all things works on principle of object
        if(Objects.equals(enterPassword,password)){

            if(amount>balance){
                return "Insufficient Money";
            }
            else{
                balance=balance-amount;
                return " current account balance after withdraw : " + balance;
            }
        }
        // if password is wrong
        else{
            return "Wrong password !!";
        }

    }

    @Override
    public double calculateInterest(int years) {
        // interest formula simple interest formula (p*y*q)/100

// how I pass the message??
        return ( (balance *years* rateOfInterest)/100);
    }


}
