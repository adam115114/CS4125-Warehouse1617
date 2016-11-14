package Objects;

public class Stock {
    private int stockNum;
    private String name;
    private int quantity;
    private float price;

    public Stock(int inNum, String inName, int inQuantity, float inPrice) {
        stockNum = inNum;
        name = inName;
        quantity = inQuantity;
        price = inPrice;
    }

    public int getStockNum() {
        return stockNum;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }


    public void setStockNum(int inNum) {
        stockNum = inNum;
    }

    public void setName(String inName) {
        name = inName;
    }

    public void setQuantity(int inQuantity) {
        quantity = inQuantity;
    }

    public void setPrice(float inPrice) {
        price = inPrice;
    }
}
