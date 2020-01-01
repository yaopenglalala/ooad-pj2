package transaction;

import java.util.ArrayList;
import java.util.List;

public class Flow {
    private List<Transaction> transactions;
    private String desc;
    private int amount;

    public Flow() {
        desc = "";
        amount = 0;
        transactions = new ArrayList<>();
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        updateAmount();
    }

    private void updateAmount() {
        amount = 0;
        transactions.forEach(transaction ->
            amount += transaction.getAmount()
        );
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Total point: " + amount + "\n");
        transactions.forEach(transaction ->
                stringBuilder.append(transaction.toString() + "\n")
        );
        return stringBuilder.toString();
    }
}
