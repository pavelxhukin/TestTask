import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CardListReader {
    public void read(CardList cardList, String path) throws FileNotFoundException{
        File file = new File(path);

        Scanner reader = new Scanner(file);
        while(reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] cardField = line.split(" ");

            Card card = new Card(cardField[0], Integer.parseInt(cardField[1]), Integer.parseInt(cardField[2]), Long.parseLong(cardField[3]));
            cardList.push(card);
        }

        reader.close();
    }
}
