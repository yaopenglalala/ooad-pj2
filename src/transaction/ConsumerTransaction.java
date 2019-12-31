package transaction;

import commodity.Commodity;

import java.util.Date;
import java.util.List;

public class ConsumerTransaction extends Transaction {
    private List<Commodity> commodities;

    public ConsumerTransaction(List<Commodity> commodities, Date time, int amount, String commit) {
        super(time, amount, commit);
        this.commodities = commodities;
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }
}
