public class Nintendo extends Product {
    public Nintendo(String articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }


    @Override
    public String category() {
        return "Spelkonsol";
    }
}
