package transaction;

import java.util.Date;

/**
 * 交易记录
 */
public class Transaction {
    private Date time;
    private int amount;
    private String commit;

    public Transaction(Date time, int amount, String commit) {
        this.time = time;
        this.amount = amount;
        this.commit = commit;
    }

    public Date getTime() {
        return time;
    }

    public String getCommit() {
        return commit;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Income:" + amount + " Info:" + commit + " Time:" + time;
    }
}
