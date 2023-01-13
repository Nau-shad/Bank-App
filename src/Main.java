

import java.util.Scanner;

 public class Main {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.println("Enter Your Name ,Password,Initial Balance to create an account");

        String name= sc.next();
        String password=sc.next();
        double balance = sc.nextDouble();

        SBI_User user= new SBI_User(name,balance,password);
       // PNB_User user1= new PNB_User(name,balance,password);

        //Account no
        System.out.println("The account of new SBI user is "+ user.getAccountNo());

        // Add amount
        System.out.println("enter the amount you want to add ");
        int amt=sc.nextInt();
        String message = user.addMoney(amt);
        System.out.println(message);

//        //check balance
//        double newBalance = user.getBalance();
//        System.out.println("The new Balance is "+ newBalance);

        //withDraw money
        System.out.println("Enter amount you want to withdraw");
        int money=sc.nextInt();

        System.out.println("Enter your password");
        String pass =sc.next();
        String result=user.withdrawMoney(money,pass);
        System.out.println(result);

        //rate of interest
        System.out.println(" Enter total year you want to fix you money ");
        int year=sc.nextInt();
        System.out.println("the interest for selected  year on "+user.getBalance()+" Rs will be " +user.calculateInterest(year));

    }
}