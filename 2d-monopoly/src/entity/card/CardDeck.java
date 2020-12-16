package entity.card;

public class CardDeck {
    private final int DECKSIZE = 4;
    private Card[] cards;
    private boolean chance;
    private int currentCard;

    public CardDeck(boolean chance) {
        cards = new Card[DECKSIZE];
        this.chance = chance;
        currentCard = 0;
    }

    public void shuffleCard(){
        boolean isit = false;
        int valid = 0;
        int[] past = new int[DECKSIZE*2];
        Card mycard;
        int random1;
        int random2;

        for(int i = 0; i < past.length; i++) {
            past[i] = 99;
        }

        for(int z = 0; z < DECKSIZE/2 ; z++) // changes the place of 2 card randomly for all cards 26 times
        {
            do{
                random1 = ((int) Math.floor(Math.random()*DECKSIZE)); // first place
                random2 = ((int) Math.floor(Math.random()*DECKSIZE)); // second place

                for(int i : past) // to disallow change place 2 times or more
                {
                    if(i == random1 || i == random2)
                        isit = false;
                    else
                        isit = true;
                }
                if(isit)
                {
                    past[valid] = random1;
                    past[valid + 1] = random2;
                    valid += 2;
                }
            }while(!isit);

            mycard = cards[random1]; // change part
            cards[random1] = cards[random2];
            cards[random2] = mycard;
        }
    }

    public Card drawCard(){
        Card drawn = cards[currentCard % DECKSIZE];
        currentCard++;
        return drawn;
    }

    public void createDeck(){
        if(chance){
            cards[0] = new Card(new TransactionCardStrategy(), "RTUK has fined you 30.000 TL for your radio program.", -30000);
            cards[1] = new Card(new GetOutOfJailCardStrategy(), "Jailbreak Daddy Card\n This card allows you to get out of jail without any charge (You can keep this card).", 0);
            cards[2] = new Card(new MovementByNumCardStrategy(), "Mafia shot a butcher in next tile, move 3 tiles backward.", 3);
            cards[3] = new Card(new MovementToCardStrategy(), "You stabbed a guy who don't like your new music album. Get into jail!", 30);
        } else {
            cards[0] = new Card(new TransactionCardStrategy(), "You went on holiday to Russia, got on a train from St. Petersburg to Moscow. Pay 50000 TL.", -50000);
            cards[1] = new Card(new TransactionCardStrategy(), "You worked in the field, get 2000 TL.", 2000);
            cards[2] = new Card(new MovementByNumCardStrategy(), "Police raid!!! Move 5 tiles backward .", 5);
            cards[3] = new Card(new MovementToCardStrategy(), "You stole a car. Move until you arrive start tile.", 0);
        }

    }

}
