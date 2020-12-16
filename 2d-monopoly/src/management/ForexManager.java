package management;
import entity.Forex;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ForexManager {
    private static ForexManager instance;

    private Forex forex;
    public Stack<Integer> dollarTrans = new Stack<Integer>();
    public Stack<Integer> euroTrans = new Stack<Integer>();
    public Stack<Integer> frankTrans = new Stack<Integer>();

    private ForexManager(){
        forex = new Forex();
        resetExRates();
    }

    public static ForexManager getInstance() {
        if (instance == null)
            instance = new ForexManager();
        return instance;
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
             int dollar = dollarTrans.pop();
            if (dollar > 200000) {
                updateExRates("Dollar", forex.getDollarExRate() / ((forex.getDollarExRate() * dollar) / 228000));
            } else if (dollar > 0) {
                updateExRates("Dollar", forex.getDollarExRate() * 8000 / dollar);
            } else if (dollar > -3000) {
                updateExRates("Dollar", forex.getDollarExRate() + (double)((-1*dollar) / 250000));
            } else {
                updateExRates("Dollar", forex.getDollarExRate() + (double)((-1*dollar) / 25000));
            }
        }


//        updateExRates("Dollar", forex.getDollarExRate() + (randomNumDollar/1000));

        while (!euroTrans.empty()) {
            int euro = euroTrans.pop();
            if (euro > 3000) {
                updateExRates("Euro", forex.getEuroExRate() - (euro / 25000));
            } else if (euro > 0) {
                updateExRates("Euro", forex.getEuroExRate() - (euro / 250000));
            } else if (euro > -3000) {
                updateExRates("Euro", forex.getEuroExRate() + (euro / 250000));
            } else {
                updateExRates("Euro", forex.getEuroExRate() + (euro / 25000));
            }
        }
        updateExRates("Euro", forex.getEuroExRate() + (randomNumEuro/1000));

        while (!frankTrans.empty()) {
            int frank = frankTrans.pop();
            if (frank > 3000) {
                updateExRates("Frank", forex.getFrankExRate() - (frank / 25000));
            } else if (frank > 0) {
                updateExRates("Frank", forex.getFrankExRate() - (frank / 250000));
            } else if (frank > -3000) {
                updateExRates("Frank", forex.getFrankExRate() + (frank / 250000));
            } else {
                updateExRates("Frank", forex.getFrankExRate() + (frank / 25000));
            }
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


}