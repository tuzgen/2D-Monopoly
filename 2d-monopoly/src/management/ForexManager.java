package management;
import entity.Forex;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ForexManager {
    private Forex forex;
    public Stack<Double> dollarTrans = new Stack<Double>();
    public Stack<Double> euroTrans = new Stack<Double>();
    public Stack<Double> frankTrans = new Stack<Double>();

    ForexManager(){
        forex = new Forex();
        resetExRates();

    }

    public void resetExRates(){
        forex.setDollarExRate(1.5);
        forex.setEuroExRate(1);
        forex.setFrankExRate(1);
    }

    public void calcSupDemand(){
        double randomNumDollar = ThreadLocalRandom.current().nextDouble(-1.0, 1.0 + 1.0);
        double randomNumEuro = ThreadLocalRandom.current().nextDouble(-1.0, 1.0 + 1.0);
        double randomNumFrank = ThreadLocalRandom.current().nextDouble(-1.0, 1.0 + 1.0);

        while (!dollarTrans.empty()) {
            double dollar = dollarTrans.pop();
            updateExRates("Dollar", forex.getDollarExRate() * Math.pow(2,-dollar/350000));
        }
        updateExRates("Dollar", forex.getDollarExRate() + (randomNumDollar/100));

        while (!euroTrans.empty()) {
            double euro = euroTrans.pop();
            updateExRates("Euro", forex.getEuroExRate() * Math.pow(2,-euro/350000));
        }
        updateExRates("Euro", forex.getEuroExRate() + (randomNumEuro/1000));

        while (!frankTrans.empty()) {
            double frank = frankTrans.pop();
            updateExRates("Frank", forex.getFrankExRate() * Math.pow(2, -frank/350000));
        }
        updateExRates("Frank", forex.getFrankExRate() + (randomNumFrank/1000));
    }

    public void updateExRates(String currency, double exRa){
        if( currency.equals("Dollar") )
            forex.setDollarExRate(exRa);

        if( currency.equals("Euro") )
            forex.setEuroExRate(exRa);

        if(currency.equals("Try"))
            forex.setTryExRate(exRa);

        if( currency.equals("Frank"))
            forex.setFrankExRate(exRa);
    }

    public ForexManager getInstance(){
        return this;
    }


    public double getDollarExRate(){
        return forex.getDollarExRate();
    }

    public double getEuroExRate() {
        return forex.getEuroExRate();
    }

    public double getTryExRate(){
        return forex.getTryExRate();
    }

    public double getFrankExRate(){
        return forex.getFrankExRate();
    }

    public Forex getForex(){
        return this.forex;
    }

    public void push(String currency, double money){
        if(currency.equals("Dollar")) dollarTrans.push(money);
        if(currency.equals("Euro")) euroTrans.push(money);
        if(currency.equals("Frank")) frankTrans.push(money);
    }



}


class Test{
    public static void main(String[] args){
        ForexManager manager = new ForexManager();
//        manager.dollarTrans.push(-1000000.0);
//        manager.dollarTrans.push(1000000.0);
        manager.push("Dollar", 20000);
        manager.calcSupDemand();

        System.out.println(manager.getDollarExRate());


    }
}