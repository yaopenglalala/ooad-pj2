package commodity;

public class Commodity {
    private CommoditySpecification specification;

    public Commodity(CommoditySpecification specification) {
        this.specification = specification;
    }

    public CommoditySpecification getSpecification() {
        return specification;
    }
}
