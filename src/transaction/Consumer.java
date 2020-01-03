package transaction;

import commodity.Commodity;
import task.point.Account;
import user.User;

import java.util.Date;
import java.util.List;

public class Consumer {
    private User user;
    private Account account;

    public Consumer(User user) {
        this.user = user;
        account = user.getAccount();
    }

    public boolean consume(List<Commodity> commodities, String commit) {
        int amount = commodities.stream().reduce(0, (x, y) -> x + y.getSpecification().getPoint(), (x, y) -> 0);
        if (amount > account.getPoint()) return false;
        account.addTransaction(new ConsumerTransaction(commodities, new Date(), 0-amount, commit));
        return true;
    }

    public User getUser() {
        return user;
    }
}
