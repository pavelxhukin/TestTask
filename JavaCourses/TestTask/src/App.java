public class App {
    public static void main(String[] args) throws Exception {
        CardListReader reader = new CardListReader();
        CardListWriter writer = new CardListWriter();
        CardList myList = new CardList();
        String path = "Input";

        reader.read(myList,path);

        new ATM(myList).run();

        writer.write(myList,path);
    }
}
