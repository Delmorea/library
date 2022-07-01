package personal.delmore.entity;

public class ReaderType {

    private String rdType;
    private Integer canLendQty;
    private Integer canLendDay;

    public ReaderType(String rdType, Integer canLendQty, Integer canLendDay) {
        this.rdType = rdType;
        this.canLendQty = canLendQty;
        this.canLendDay = canLendDay;
    }

    public int getCanLendDay() {
        return canLendDay;
    }

    public void setCanLendDay(int canLendDay) {
        this.canLendDay = canLendDay;
    }

    public int getCanLendQty() {
        return canLendQty;
    }

    public void setCanLendQty(int canLendQty) {
        this.canLendQty = canLendQty;
    }

    public String getRdTypeName() {
        return rdType;
    }

    public void setRdTypeName(String rdTypeName) {
        this.rdType = rdTypeName;
    }

    @Override
    public String toString() {
        return "ReaderType{" +
                "rdType='" + rdType + '\'' +
                ", canLendQty=" + canLendQty +
                ", canLendDay=" + canLendDay +
                '}';
    }
}
