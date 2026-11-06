package edu.cwi;
import java.text.DecimalFormat;
import java.util.Map;

public record UserAccount(String name, double balance, Map<String, String> transactions) {
    
    public String formatBalance() {
        DecimalFormat df = new DecimalFormat("$#,###.00");
        return df.format(this.balance);
    }

    public String getName() {
        return this.name;
    }

    public Map<String, String> getTransactions() {
        return this.transactions;
    }
}
