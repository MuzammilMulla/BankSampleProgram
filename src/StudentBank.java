import java.util.Scanner;
class CreateAccount {
    public String accountHolder;
    public int accountNumber;
    public double accountBalance;
    public int phoneNumber;
    public String bankAddress;


    Scanner sc = new Scanner(System.in);
    //getters and setters
    public String getAccountHolder() {
        return accountHolder;
    }
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getBankAddress() {
        return bankAddress;
    }
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public void greetings(){
        System.out.println("Welcome !");
        askUserPreference();
    }

   //ask user preferred operation
  public  int choice;
   public void askUserPreference() {
       System.out.println("1.Create account \n 2.Deposit money \n 3.Withdraw money \n 4.Transaction \n 5.Exit \n");
       System.out.println("Enter your choice: ");
       choice = sc.nextInt();
       if (choice == 1) {
           askDetails();
           askUserPreference();
       }
       else if (choice ==2){
           depositMoney();
           askUserPreference();
       } else if (choice==3) {
           withDraw();
           askUserPreference();
       } else if (choice==4) {
           transaction();
           askUserPreference();
       }else if(choice==5){
           System.exit(0);
       }
   }


    //Create user account
    public void askDetails() {
        System.out.println("Enter your name:");
        setAccountHolder(sc.next());
        System.out.println("Enter your account number:");
        setAccountNumber(sc.nextInt());
        System.out.println("Enter your Phone Number:");
        setPhoneNumber(sc.nextInt());

        setAccountBalance(0);
        setBankAddress("xyz colony, abc city ");
        System.out.println("\n");
        showDetails();
    }

    // display user details
    public void showDetails() {
        System.out.println("Account holder name is: " + getAccountHolder());
        System.out.println("Account Number is: " + getAccountNumber());
        System.out.println("Phone number is: " + getPhoneNumber());
        System.out.println("your initial balance is:" + getAccountBalance());
        System.out.println("your Bank address is: " + getBankAddress());
        System.out.println("\n");
    }


    //Deposit Money
    public int depositMoneyAmount;
    public int getDepositMoneyAmount() {
        return depositMoneyAmount;
    }
    public void setDepositMoneyAmount(int depositMoneyAmount) {
        this.depositMoneyAmount = depositMoneyAmount;
    }
    public void depositMoney() {
        System.out.println("Enter the amount you want deposit:");
        depositMoneyAmount = sc.nextInt();
        System.out.println("you have entered rupees " + getDepositMoneyAmount() + " to deposit");
        setAccountBalance(getAccountBalance()+getDepositMoneyAmount());
        System.out.println("your balance is:" + getAccountBalance());
        System.out.println("***************************************************");
        System.out.println("\n");
    }


    //to withdraw money
    public int withDrawlMoney;

    public int getWithDrawlMoney() {
        return withDrawlMoney;
    }
    public void setWithDrawlMoney(int withDrawlMoney) {
        this.withDrawlMoney = withDrawlMoney;
    }

    public void withDraw() {
            System.out.println("Enter money you want to withdraw");
            setWithDrawlMoney(sc.nextInt());
            System.out.println("you want to withdraw " + getWithDrawlMoney());
            if (accountBalance > 0 && withDrawlMoney <= accountBalance) {
                setAccountBalance(getAccountBalance()-getWithDrawlMoney());
                System.out.println("Transaction Successfully completed !");
                System.out.println("Balance is: "+ getAccountBalance());
                System.out.println("***************************************************");

            } else {
                System.out.println("Invalid input");
                System.exit(1);
            }
        }


    //to transact money
    public int transactionAmount;
    public int getTransactionAmount() {
        return transactionAmount;
    }
    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public void transaction() {
        System.out.println("Enter the amount you want to transfer:");
        setTransactionAmount(sc.nextInt());
        System.out.println("you want to transfer " + getTransactionAmount());

        if ((accountBalance > 0) && (transactionAmount <= accountBalance)) {
            System.out.println("transfer completed of amount:" + getTransactionAmount());
            setAccountBalance(getAccountBalance()-getTransactionAmount());
            System.out.println("balance is: "+ getAccountBalance());
            System.out.println("***************************************************");
        }
        else {
            System.out.println("Invalid Input");
            System.exit(1);
        }
    }

}
public class StudentBank {
    public static void main(String[] args) {
        CreateAccount c1= new CreateAccount();
        c1.greetings();
    }
}

