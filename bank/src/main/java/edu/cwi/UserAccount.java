package edu.cwi;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.UUID;

public record UserAccount(UUID id, String name, Main.AppRole role, double balance, Map<String, String> transactions) {
    
    public String formatBalance() {
        DecimalFormat df = new DecimalFormat("$#,###.00");
        return df.format(this.balance);
    }

    public UUID getId() {
        return this.id;
    }

    public String getStringId() {
        return this.id.toString();
    }

    public String getName() {
        return this.name;
    }

    public Main.AppRole getRole() {
        return this.role;
    }

    public Map<String, String> getTransactions() {
        return this.transactions;
    }
}
