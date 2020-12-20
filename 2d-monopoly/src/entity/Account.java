package entity;

import java.io.Serializable;

public class Account implements Serializable {
    //Properties
    private double dollar;
    private double euro;
    private double trl;
    private double swissFrank;
    private double poweupRate;

    //Constructor
    public Account( double trl ){
        dollar = 0;
        euro = 0;
        swissFrank = 0;
        this.trl = trl;
        poweupRate = 1;
    }

    //Methods
    public double getDollar() {
        return dollar;
    }

    public double getEuro() {
        return euro;
    }

    public double getSwissFrank() {
        return swissFrank;
    }

    public double getTrl() {
        return trl;
    }

    public void setDollar(double dollar) {
        this.dollar = dollar;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }

    public void setSwissFrank(double swissFrank) {
        this.swissFrank = swissFrank;
    }

    public void setTrl(double trl) {
        this.trl = trl;
    }

    public double getPoweupRate() {
        return poweupRate;
    }

    public void setPoweupRate(double poweupRate) {
        this.poweupRate = poweupRate;
    }
}
