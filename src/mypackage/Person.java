package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    private String name;
    private List<BankAccount> accounts;

    public Person(String name) {
        this.name = name;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
    
    public void addAccount(BankAccount account) {
        if (accounts == null) {
            accounts = new ArrayList();
        }
        accounts.add(account);
    }
    public void printTotalMoney(){
        double sum = 0;
        for(BankAccount a:accounts){
            sum += a.getAmount();
        }
        System.out.printf("%s has total: %.2f€ in his accounts\n",name,sum);
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.accounts);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.accounts, other.accounts)) {
            return false;
        }
        return true;
    }

}
