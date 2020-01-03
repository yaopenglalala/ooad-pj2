package task.point;

import transaction.Flow;
import transaction.Transaction;

/**
 * 积分账户
 */
public class Account {
    private Flow flow;

    public Account(){
        this.flow = new Flow();
    }

    public void addTransaction(Transaction transaction) {
        flow.addTransaction(transaction);
    }

    public int getPoint() {
        return flow.getAmount();
    }

    public Flow getFlow() {
        return flow;
    }
}
