package core.CoreBasic.oopinjava.encapsulation;

public class JavaEncapsulation {
    public static void main(String[] args) {
         BankAccount rupesh = new BankAccount("Rupesh",40000);
                rupesh.deposit(50);
                rupesh.withdraw(30);

        rupesh.deposit(50000);
        rupesh.withdraw(300000);
        rupesh.withdraw(30000);
    }
}
class BankAccount{
    private static final int MIN_DEPOSIT = 100;
    private static final int MIN_WITHDRAW = 50;
    private String name;
    private double balance;

    BankAccount(String name, double balance){
        this.name = name;
        this.balance = balance;
    }
    public void deposit(int amount){
        if(amount >= MIN_DEPOSIT){
            isMutate(amount,"depo");
        }else{
            System.out.println("minimum amount should 100 or grater  to deposit.");
        }
        System.out.println("current balance: "+ accessBalance());
    }



    public void withdraw(int amount){
        if(amount >= MIN_WITHDRAW  && balance >= amount){
            isMutate(amount,"wd");
        }else{
            System.out.println("Can't withdraw very little money or beyond the balance");
        }
        System.out.println("current balance: "+ accessBalance());
    }
    private void isMutate(double balance,String flag){
        if(balance <= 0 ){
            System.out.println("invalid balance amount ");

        }
        if(flag.equalsIgnoreCase("depo")){
            this.balance += balance;
        }else if(flag.equalsIgnoreCase("wd")){
            this.balance -= balance;
        }else{
            System.out.println("Invalid transaction request received.");
        }



    }
    public double accessBalance(){
        return balance;
    }

    public String accessName(){
        return name;
    }
}