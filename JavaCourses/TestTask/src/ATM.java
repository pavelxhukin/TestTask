import java.util.Scanner;
import java.util.Date;

public class ATM {
    private void chekPinCode(int pinCounter, Card card){
        do {
            try {
                System.out.printf("Введите пинкод(" + pinCounter + " попытки/попытка)\n");
                int inputPinCode = Integer.parseInt(inputCardScanner.nextLine());
                if (inputPinCode != card.getPinCode()) {
                    pinCounter--;
                    if (pinCounter == 0) {
                        card.blockCard();
                        System.out.println("Ваша карта теперь заблокированна");
                        break;
                    }
                } else {
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Ошибка ввода");
                continue;
            }

        } while (true);
    }
    private void cashWithdrawal(Card card){
        do {
            System.out.println("Введите сумму для снятия или 0 для выхода");
            System.out.println("На вашем счету осталось " + card.getBalance());
            try {
                int moneyAmount = Integer.parseInt(inputCardScanner.nextLine());
                if (moneyAmount == 0) {
                    break;
                }

                if (card.getBalance() < moneyAmount) {
                    try {
                        throw new NotEnoughMoneyException();
                    } catch (NotEnoughMoneyException e) {
                        System.out.println("На вашем счету недостаточно денег");
                        continue;
                    }
                }
                System.out.println("С вашего счета было снято " + card.takeMoney(moneyAmount));
                System.out.println("На вашем счету осталось " + card.getBalance());

            }catch (NumberFormatException e){
                System.out.println("Ошибка ввода");
                continue;
            }

        } while (true);
    }

    private CardList cardList;
    int pinInputCounter;
    private Card myCard;
    Scanner inputCardScanner = new Scanner(System.in);
    public ATM(CardList list) {
        this.cardList = list;
    }

    public void run() {
        do {
            pinInputCounter = 3;

            System.out.println("Введите 0 для конца сеанса или другое число для продолжения");
            try {
                int exit = Integer.parseInt(inputCardScanner.nextLine());

                if (exit == 0) {
                    break;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Ошибка ввода");
                continue;
            }
            System.out.println("Введите номер карты");

            String inputCardNumber = inputCardScanner.nextLine();

            myCard = cardList.findCard(inputCardNumber);

            if (myCard.getCardNuber() == null) {
                System.out.println("Карта не найдена либо введена неверно");
                continue;
            } else {
                if (myCard.isAvailable()) {//интерфейс

                    chekPinCode(pinInputCounter, myCard);

                    cashWithdrawal(myCard);

                } else {
                    Date unblockDate = new Date(myCard.getTime());
                    System.out.printf("Ваша карта заблокированна до " + unblockDate + "\n");
                }
            }
        } while (true);
    }
}
