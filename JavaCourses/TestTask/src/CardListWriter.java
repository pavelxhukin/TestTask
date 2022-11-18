import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CardListWriter {
    public void write (CardList card, String path) {
        File file = new File(path);

        try {
            PrintWriter pw = new PrintWriter(file);
            for (Card outputCard : card.set) {
                pw.println(outputCard.toString());
            }

            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл с данными не обнаружен");
        }

    }
}
