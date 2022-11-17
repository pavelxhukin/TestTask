public class Card{
    private void ChekIsAvailable(){
        if(System.currentTimeMillis()>time){
            isCardAvailable = true;}
        else{
            isCardAvailable = false;}
    }
    private final long DAYINMILL = 86400000;
    private String cardNuber;
    private int pinCode;
    private int balance;
    private long time;
    private boolean isCardAvailable;

    public boolean isAvailable(){
        return isCardAvailable;
    }

    public void blockCard(){
        isCardAvailable = false;
        time = System.currentTimeMillis()+DAYINMILL;
    }
    public Card(String cardNuber, int pinCode, int balance, long time){
        this.cardNuber = cardNuber;
        this.pinCode = pinCode;
        this.balance = balance;
        this.time = time;
        ChekIsAvailable();
    }
    public Card(){
        this.cardNuber = "";
        this.pinCode = 0;
        this.balance = 0;
        this.time = 0;
        this.isCardAvailable = false;
    }

    public long getTime() {
        return time;
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getCardNuber() {
        return cardNuber;
    }

    public void setCardNuber(String cardNuber) {
        this.cardNuber = cardNuber;
    }

    public int getBalance() {
        return balance;
    }

    public int takeMoney(int moneyToTake) {
        this.balance -= moneyToTake;
        return moneyToTake;
    }

    public String toString() {
        return cardNuber + " " + pinCode + " " + balance + " " + time;
    }

}
