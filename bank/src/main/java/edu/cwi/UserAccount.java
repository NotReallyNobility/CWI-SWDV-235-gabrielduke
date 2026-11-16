package edu.cwi;
import java.text.DecimalFormat;
import java.util.Map;

public record UserAccount(int id, String name, edu.cwi.data.enums.AppRole role, double balance, Map<String, String> transactions) {
    
    public String formatBalance() {
        DecimalFormat df = new DecimalFormat("$#,###.00");
        return df.format(this.balance);
    }

    public int getId() {
        return this.id;
    }

    /*public String getStringId() {
        return this.id.toString();
    }*/

    public String getName() {
        return this.name;
    }

    public edu.cwi.data.enums.AppRole getRole() {
        return this.role;
    }

    public Map<String, String> getTransactions() {
        return this.transactions;
    }
}
