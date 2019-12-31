package transaction;

import commodity.Commodity;

import java.util.Date;
import java.util.List;

public class ConsumerTransaction extends Transaction {
    private List<Commodity> commodities;

    public ConsumerTransaction(List<Commodity> commodities, Date time, String commit) {
        super(time, commit);
        this.commodities = commodities;
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }
}
