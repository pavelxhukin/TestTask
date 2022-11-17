import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CardListWriter {
    public void write (CardList card, String path) throws FileNotFoundException {
        File file = new File(path);
        PrintWriter pw = new PrintWriter(file);

        for (Card outputCard : card.set) {
            pw.println(outputCard.toString());
        }

        pw.close();
    }
}
