package commodity;

public class CommoditySpecification {
    private int point;
    private int price;
    private String description;

    public CommoditySpecification(int point, int price, String description) {
        this.point = point;
        this.price = price;
        this.description = description;
    }

    public int getPoint() {
        return point;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
