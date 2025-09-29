package august.learn;

public class Transaction {
    String accountId;
    String type;
    double fee;

    public Transaction(String accountId, String type, double fee) {
        this.accountId = accountId;
        this.type = type;
        this.fee = fee;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
