package management;
import entity.Forex;
import java.util.*;

public class ForexManager {
    public Forex forex;
    Stack<Integer> transactions = new Stack<Integer>();

    ForexManager(){
        resetExRates();
        transactions.push(1);
        transactions.push(1);
        transactions.push(1);
        transactions.push(1);
    }

    public void resetExRates(){
        forex.setDollarExRate(1);
        forex.setEuroExRate(1);
        forex.setTryExRate(1);
        forex.setFrankExRate(1);
    }

    public void calcSupDemand(){
        // todo

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

    public ForexManager getInstance(){
        return this;
    }

}


