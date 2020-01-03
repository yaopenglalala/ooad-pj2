package service;

import commodity.Commodity;
import transaction.Consumer;
import user.UserGroup;

import java.util.List;

public class ConsumerService {

    public boolean consumeCommodities(String username, List<Commodity> commodities, String commit) {
        Consumer consumer = new Consumer(UserGroup.getUserGroup().getUser(username));
        return consumer.consume(commodities, commit);
    }
}
