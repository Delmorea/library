package personal.delmore.entity;

import java.util.Objects;

public class Borrow {
    private String userName;
    private String bkId;
    private String dateBorrow;
    private String dateLendPlan;
    private String dateLendAct;

    public Borrow(String userName, String bkId, String dateBorrow, String dateLendPlan, String dateLendAct) {
        this.userName = userName;
        this.bkId = bkId;
        this.dateBorrow = dateBorrow;
        this.dateLendPlan = dateLendPlan;
        this.dateLendAct = dateLendAct;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBkId() {
        return bkId;
    }

    public void setBkId(String bkId) {
        this.bkId = bkId;
    }

    public String getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(String dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public String getDateLendPlan() {
        return dateLendPlan;
    }

    public void setDateLendPlan(String dateLendPlan) {
        this.dateLendPlan = dateLendPlan;
    }

    public String getDateLendAct() {
        return dateLendAct;
    }

    public void setDateLendAct(String dateLendAct) {
        this.dateLendAct = dateLendAct;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "userName='" + userName + '\'' +
                ", bkId='" + bkId + '\'' +
                ", dateBorrow='" + dateBorrow + '\'' +
                ", dateLendPlan='" + dateLendPlan + '\'' +
                ", dateLendAct='" + dateLendAct + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrow borrow = (Borrow) o;
        return Objects.equals(userName, borrow.userName) &&
                Objects.equals(bkId, borrow.bkId) &&
                Objects.equals(dateBorrow, borrow.dateBorrow) &&
                Objects.equals(dateLendPlan, borrow.dateLendPlan) &&
                Objects.equals(dateLendAct, borrow.dateLendAct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, bkId, dateBorrow, dateLendPlan, dateLendAct);
    }
}
