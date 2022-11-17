import java.util.HashSet;
import java.util.Set;

public class CardList {
    public Set<Card> set = new HashSet<>();

    public void push(Card card){
        this.set.add(card);
    }

    public Card findCard(String numberToFind) {
        for (Card cardList : set) {
            if(numberToFind.equals(cardList.getCardNuber()) ){

                return cardList;
            }
        }
        return new Card();
    }
}
