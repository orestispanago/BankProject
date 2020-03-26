package mypackage;


public class MainClass {


    public static void main(String[] args) {
        BankAccount accountPeiraios = new BankAccount(1,0.0, "Apotamieusi");
        accountPeiraios.deposit(100);
        System.out.println(accountPeiraios);
        accountPeiraios.withdraw(30);
        accountPeiraios.withdraw(71);
        accountPeiraios.printTransactions();
        
        BankAccount.printAccountsOpen();
        
        
        BankAccount accountEthniki = new BankAccount(2,500.0,"Ethniki");
        Person jack = new Person("Jack");
        jack.addAccount(accountPeiraios);
        jack.addAccount(accountEthniki);
        
        jack.printTotalMoney();
    }
    
}
