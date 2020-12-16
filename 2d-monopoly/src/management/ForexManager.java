package management;
import entity.Forex;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ForexManager {
    public static ForexManager instance = new ForexManager();
    public Forex forex;
    public Stack<Integer> dollarTrans = new Stack<Integer>();
    public Stack<Integer> euroTrans = new Stack<Integer>();
    public Stack<Integer> frankTrans = new Stack<Integer>();

    ForexManager(){
        forex = new Forex();
        resetExRates();

    }

    public void resetExRates(){
        forex.setDollarExRate(1);
        forex.setEuroExRate(1);
        forex.setFrankExRate(1);
    }

    public void calcSupDemand(){
        double randomNumDollar = ThreadLocalRandom.current().nextDouble(-1.0, 1.0 + 1.0);
        double randomNumEuro = ThreadLocalRandom.current().nextDouble(-1.0, 1.0 + 1.0);
        double randomNumFrank = ThreadLocalRandom.current().nextDouble(-1.0, 1.0 + 1.0);

        while (!dollarTrans.empty()) {
            int dollar = dollarTrans.pop();
            if (dollar > 3000) {
                updateExRates("Dollar", forex.getDollarExRate() + (dollar / 25000));
            } else if (dollar > 0) {
                updateExRates("Dollar", forex.getDollarExRate() + (dollar / 250000));
            } else if (dollar > -3000) {
                updateExRates("Dollar", forex.getDollarExRate() - (dollar / 250000));
            } else {
                updateExRates("Dollar", forex.getDollarExRate() - (dollar / 25000));
            }
        }
        updateExRates("Dollar", forex.getDollarExRate() + (randomNumDollar/1000));

        while (!euroTrans.empty()) {
            int euro = euroTrans.pop();
            if (euro > 3000) {
                updateExRates("Euro", forex.getEuroExRate() + (euro / 25000));
            } else if (euro > 0) {
                updateExRates("Euro", forex.getEuroExRate() + (euro / 250000));
            } else if (euro > -3000) {
                updateExRates("Euro", forex.getEuroExRate() - (euro / 250000));
            } else {
                updateExRates("Euro", forex.getEuroExRate() - (euro / 25000));
            }
        }
        updateExRates("Euro", forex.getEuroExRate() + (randomNumEuro/1000));

        while (!frankTrans.empty()) {
            int frank = frankTrans.pop();
            if (frank > 3000) {
                updateExRates("Frank", forex.getFrankExRate() + (frank / 25000));
            } else if (frank > 0) {
                updateExRates("Frank", forex.getFrankExRate() + (frank / 250000));
            } else if (frank > -3000) {
                updateExRates("Frank", forex.getFrankExRate() - (frank / 250000));
            } else {
                updateExRates("Frank", forex.getFrankExRate() - (frank / 25000));
            }
        }
        updateExRates("Frank", forex.getFrankExRate() + (randomNumFrank/1000));
    }

    public void updateExRates(String currency, double exRa){
        if( currency == "Dollar" )
            forex.setDollarExRate(exRa);

        if( currency == "Euro" )
            forex.setEuroExRate(exRa);

        if(currency == "Try")
            forex.setTryExRate(exRa);

        if( currency == "Frank" )
            forex.setFrankExRate(exRa);
    }

    public static ForexManager getInstance(){
        return instance;
    }

}


//class Test{
//    public static void main(String[] args){
//        ForexManager manager = new ForexManager();
//        manager.dollarTrans.push(21349);
//        manager.dollarTrans.push(45529);
//        manager.dollarTrans.push(30529);
//
//        manager.calcSupDemand();
//
//        System.out.println(manager.forex.getDollarExRate());
//
//    }
//}