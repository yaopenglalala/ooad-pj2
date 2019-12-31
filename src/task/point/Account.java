package task.point;

import transaction.Flow;
import transaction.Transaction;

public class Account {
    private Flow flow;

    public Account(){
        this.flow = new Flow();
    }

    public void addTransaction(Transaction transaction) {
        flow.addTransaction(transaction);
    }

    public Flow getFlow() {
        return flow;
    }
}
