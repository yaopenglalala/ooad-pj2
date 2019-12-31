package transaction;

import java.util.Date;

/**
 * 交易记录
 */
public class Transaction {
    private Date time;
    private String commit;

    public Transaction(Date time, String commit) {
        this.time = time;
        this.commit = commit;
    }

    public Date getTime() {
        return time;
    }

    public String getCommit() {
        return commit;
    }
}
