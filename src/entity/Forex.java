package entity;

import java.io.Serializable;

public class Forex implements Serializable {

    private double dollarExRate;
    private double euroExRate;
    private double tryExRate;
    private double frankExRate;

    public double getDollarExRate(){
        return dollarExRate;
    }

    public double getEuroExRate() {
        return euroExRate;
    }

    public double getTryExRate(){
        return tryExRate;
    }

    public double getFrankExRate(){
        return frankExRate;
    }

    public void setDollarExRate(double rate){
        this.dollarExRate = rate;
    }

    public void setEuroExRate(double rate){
        this.euroExRate = rate;
    }

    public void setTryExRate(double rate){
        this.tryExRate = rate;
    }

    public void setFrankExRate(double rate){
        this.frankExRate = rate;
    }
}
