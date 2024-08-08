package javaProject;
import java.util.Scanner;

class BanckAccount {
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 1000f;
    int transactions = 0;
    String transactionHistory = "";


    public void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter Name: ");
        this.name =sc.nextLine();
        System.out.println("\nEnter userName: ");
        this.userName =sc.nextLine();
        System.out.println("\nEnter Password: ");
        this.password =sc.nextLine();
        System.out.println("\nEnter Account No: ");
        this.accountNo =sc.nextLine();

        System.out.println("\nRagister Succesful.  Plz Login to your Bank Account");

    }
    public boolean login(){
        boolean islogin = false;
        Scanner sc = new Scanner(System.in);

        while (!islogin){
            System.out.println("\nEnter username");
            String Username =sc.nextLine();
            if (Username.equals(userName)) {
                while (!islogin) {
                    System.out.println("\nEnter your password: ");
                    String Password = sc.nextLine();
                   if(Password .equals(password)){
                    System.out.println("\nLogin Succesful");
                    islogin=true;

                    }
                    else{
                        System.out.println("\nIncorrect Password");
                    }
                }
            }else{
                System.out.println("\nUsername not found");
            }
        }
        return islogin;
    }



    public void withdraw(){
        System.out.println("\nenter Amount to withdrow: ");
        Scanner sc = new Scanner (System.in);
        float amount = sc.nextFloat();
        try{
            if(balance >= amount){
                transactions++;
                balance -= amount;
                System.out.println("\nWithdrow Succesful");
                String str = amount + "Rs Withdrow\n";
                transactionHistory = transactionHistory.concat(str);
            }else{
                System.out.println("\nInsufficient Balance.");
            }
        }catch(Exception e){
        }
    }



    public void deposit(){
        System.out.println("\nenter Amount to Deposit: ");
        Scanner sc = new Scanner (System.in);
        float amount = sc.nextFloat();
        try{
            if(amount <= 1000f){
                transactions++;
                balance += amount;
                System.out.println("\nDeposit Succesful");
                String str = amount + "Rs Deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }else{
                System.out.println("\nSorry. The limit is 1000/-");
            }
        }catch(Exception e){
        }
    }



    public void transfer(){
        Scanner sc = new Scanner (System.in);
        System.out.println("\nenter Receipnt's Name: ");
        String receipent = sc.nextLine();
        System.out.println("\nEneter Amount to transfer: ");
        float amount = sc.nextFloat();
        try{
            if(balance >= amount){
            if(balance <= 1500f){
                transactions++;
                balance += amount;
                System.out.println("\nSuccesfully Transferred to"+ receipent);
                String str = amount + "Rs transferred to" + receipent +"\n";
                transactionHistory = transactionHistory.concat(str);
            }else{
                System.out.println("\nSorry. The limit is 500/-");
            }else{
                System.out.println("\nInsuffincient Balance.");

           }catch(Exception e){
        }
    }


    public void checkBalance(){
    System.out.println("\n"+ balance+"Rs");
    }


    public void  transactionHistory(){
        if (transactions ==0){
            System.out.println("No transaction found");
        }else{
            System.out.println("\n"+transactionHistory);
        }
    }
}


public class Task3 {

    public static int takenIntegerInput(int limit){
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try{
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if(flag && input>limit || input<1){
                    System.out.println("Choose the number between 1 to "+limit);
                    flag = false;
                }
            }catch(Exception e){
                System.out.println("Enter only integer value.");
                flag = false;
            }
        }
        return input;
    }
    public static void main(String[] args) {
        System.out.println("\n************WELCOME TO ABC ATM INTERFACE*************");
        System.out.println("1.Register \n2.Exit");
        System.out.println("Choose one option: ");
        int choose = takeIntegerInput(6);
    
        if (choose == 1) {
            BankAccount b = new BankAccount(); 
            b.register();
            while (true) {
                System.out.println("1.Login \n2.Exit");
                System.out.println("Enter your choice: ");
                int ch = takeIntegerInput(2);
                if(ch == 1) {
                    if(b.login()){
                        System.out.println("******WELCOME BACK " + b.name + "******");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.println("Enter your choice: ");
                            int c = takeIntegerInput(6);
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transactionHistory();   
                                    break;
                                case 6:
                                    isFinished = true; 
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
    
}
    