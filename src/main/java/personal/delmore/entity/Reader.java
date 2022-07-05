package personal.delmore.entity;

public class Reader {
    private String userName;
    private String rdType;
    private String rdName;
    private String rdDept;
    private String rdQQ;
    private Integer rdBorrowQty;
    private boolean power;          //1表示用户为管理员，0则为普通用户

    public Reader(String userName, String rdType, String rdName, String rdDept, String rdQQ, Integer rdBorrowQty, boolean power) {
        this.userName = userName;
        this.rdType = rdType;
        this.rdName = rdName;
        this.rdDept = rdDept;
        this.rdQQ = rdQQ;
        this.rdBorrowQty = rdBorrowQty;
        this.power = power;
    }

    public Reader() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRdType() {
        return rdType;
    }

    public void setRdType(String rdType) {
        this.rdType = rdType;
    }

    public String getRdName() {
        return rdName;
    }

    public void setRdName(String rdName) {
        this.rdName = rdName;
    }

    public String getRdDept() {
        return rdDept;
    }

    public void setRdDept(String rdDept) {
        this.rdDept = rdDept;
    }

    public String getRdQQ() {
        return rdQQ;
    }

    public void setRdQQ(String rdQQ) {
        this.rdQQ = rdQQ;
    }

    public Integer getRdBorrowQty() {
        return rdBorrowQty;
    }

    public void setRdBorrowQty(Integer rdBorrowQty) {
        this.rdBorrowQty = rdBorrowQty;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }


    @Override
    public String toString() {
        return "Reader{" +
                "userName='" + userName + '\'' +
                ", rdType='" + rdType + '\'' +
                ", rdName='" + rdName + '\'' +
                ", rdDept='" + rdDept + '\'' +
                ", rdQQ='" + rdQQ + '\'' +
                ", rdBorrowQty=" + rdBorrowQty +
                ", power=" + power +
                '}';
    }
}
