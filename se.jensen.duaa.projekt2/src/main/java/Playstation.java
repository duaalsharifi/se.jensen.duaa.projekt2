public class Playstation extends Product {
    public Playstation(String articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }

    @Override
    public String category() {
        return "Spelkonsol";
    }
}
