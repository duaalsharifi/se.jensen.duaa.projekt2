public class Xbox extends Product {

    public Xbox(String articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }

    @Override
    public String category() {
        return "Spelkonsol";
    }
}
