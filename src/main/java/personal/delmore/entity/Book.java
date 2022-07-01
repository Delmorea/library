package personal.delmore.entity;

public class Book {
    private String Id;
    private String bkName;
    private String bkAuthor;
    private String bkPress;
    private double bkPrice;
    private Integer bkQty;
    private String bkURL;
    private String bkIntro;

    public Book(String id, String bkName, String bkAuthor, String bkPress, double bkPrice, Integer bkQty, String bkURL, String bkIntro) {
        Id = id;
        this.bkName = bkName;
        this.bkAuthor = bkAuthor;
        this.bkPress = bkPress;
        this.bkPrice = bkPrice;
        this.bkQty = bkQty;
        this.bkURL = bkURL;
        this.bkIntro = bkIntro;
    }

    public Book() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    public String getBkAuthor() {
        return bkAuthor;
    }

    public void setBkAuthor(String bkAuthor) {
        this.bkAuthor = bkAuthor;
    }

    public String getBkPress() {
        return bkPress;
    }

    public void setBkPress(String bkPress) {
        this.bkPress = bkPress;
    }

    public double getBkPrice() {
        return bkPrice;
    }

    public void setBkPrice(double bkPrice) {
        this.bkPrice = bkPrice;
    }

    public Integer getBkQty() {
        return bkQty;
    }

    public void setBkQty(Integer bkQty) {
        this.bkQty = bkQty;
    }

    public String getBkURL() {
        return bkURL;
    }

    public void setBkURL(String bkURL) {
        this.bkURL = bkURL;
    }

    public String getBkIntro() {
        return bkIntro;
    }

    public void setBkIntro(String bkIntro) {
        this.bkIntro = bkIntro;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id='" + Id + '\'' +
                ", bkName='" + bkName + '\'' +
                ", bkAuthor='" + bkAuthor + '\'' +
                ", bkPress='" + bkPress + '\'' +
                ", bkPrice=" + bkPrice +
                ", bkQty=" + bkQty +
                ", bkURL='" + bkURL + '\'' +
                ", bkIntro='" + bkIntro + '\'' +
                '}';
    }
}
