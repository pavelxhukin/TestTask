import java.util.Scanner;
import java.util.Date;

public class ATM {
    private CardList cardList;
    int pinInputCounter;
    private Card myCard = new Card();

    public ATM(CardList list) {
        this.cardList = list;
    }

    public void run() {
        do {
            pinInputCounter = 3;

            Scanner inputCardScanner = new Scanner(System.in);

            System.out.println("Введите 0 для конца сеанса или 1 для продолжения");
            int exit = inputCardScanner.nextInt();
            if (exit == 0) {
                break;
            }
            // вечно горящая надпись на экране банкомата
            System.out.println("Введите номер карты");


            Scanner inputCardScannerQ = new Scanner(System.in);// симулируем вставку карточки вводом ее номера
            String inputCardNumber = inputCardScannerQ.nextLine();

            myCard = cardList.findCard(inputCardNumber);

            if (myCard.getTime()==0) {
                System.out.println("Карта не найдена либо введена неверно");
                continue;
            }
            else{
                if (myCard.isAvailable()) {
                    do {
                        System.out.println("Введите пинкод(" + pinInputCounter + " попытки/попытка)");
                        int inputPinCode = inputCardScanner.nextInt();
                        if (inputPinCode != myCard.getPinCode()) {
                            pinInputCounter--;
                            if (pinInputCounter == 0) {
                                myCard.blockCard();
                                System.out.println("Ваша карта теперь заблокированна");
                                break;
                            }
                        } else {
                            break;
                        }

                    } while (true);
                    // основное меню, которое можно расширять, но тогда использовать
                    // шаблон команда
                do {
                    System.out.println("Введите сумму для снятия или 0 для выхода");
                    int moneyAmount = inputCardScanner.nextInt();
                    if (moneyAmount == 0) {break;}
                        //try {
                            if(myCard.getBalance()>moneyAmount) {

                                System.out.println("С вашего счета было снято " + myCard.takeMoney(moneyAmount));

                                System.out.println("На вашем счету осталось " + myCard.getBalance());
                            }
                        //} catch (NotEnoughMoneyException e) {
                           // System.out.println("На вашем счету недостаточно денег");
                        //}

                } while (true);
            } else {
                Date unblockDate = new Date(myCard.getTime());
                System.out.println("Ваша карта заблокированна до " + unblockDate);
                }
            }
        } while (true);
    }
}
