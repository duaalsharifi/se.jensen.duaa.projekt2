import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WebshopApp {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        products.add(new Nintendo("1001", "Nintendo", 2679.00, "Spelkonsol"));
        products.add(new Playstation("1002", "Playstation", 5999.0, "Spelkonsol"));
        products.add(new Xbox("1003", "Xbox", 4339.0, "Spelkonsol"));

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    addProduct();
                }

                case "2" -> {
                    listProducts();
                }

                case "3" -> {
                    showProductInfo();
                }

                case "4" -> {
                    running = false;
                    System.out.println("Avslutar...");
                }

                default -> System.out.println("Ogiltigt val, försök igen.");

            }
        }

    }

    private static void printMenu() {
        System.out.println("***********Menu************'");
        System.out.println("1. Lägga till produkt");
        System.out.println("2. Lista alla produkter");
        System.out.println("3. Visa info om en produkt");
        System.out.println("4. Avsluta applikationen");
        System.out.print("Välj en av alternativen: ");
    }

    private static void addProduct() {
        System.out.println("Välj produkttyp");
        System.out.println("1. Nintendo");
        System.out.println("2. Playstation");
        System.out.println("3. Xbox");
        System.out.print("Ditt val: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Artikelnummer: ");
        String articleNumber = scanner.nextLine();
        System.out.print("Titel: ");
        String title = scanner.nextLine();
        System.out.print("Pris: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Beskrivning: ");
        String description = scanner.nextLine();

        Product p = switch (choice) {
            case 1 -> new Nintendo(articleNumber, title, price, description);
            case 2 -> new Playstation(articleNumber, title, price, description);
            case 3 -> new Xbox(articleNumber, title, price, description);
            default -> null;
        };

        if (p == null) {
            System.out.println("Ingen produkt hittades");
            return;
        }
        products.add(p);
        System.out.println("Produkt tillagd: " + p);
    }


    private static void listProducts() {

        if (products.isEmpty()) {
            System.out.println("Inga produkter finns.");
            return;
        }
        System.out.println("Alla produkter:");
        int i = 1;
        for (Product p : products) {
            System.out.println(i++ + ". " + p);
        }
    }


    private static void showProductInfo() {
        scanner.nextLine();
        System.out.print("Ange artikelnummer att söka efter: ");
        String articleNumber = scanner.nextLine(); // Läs in artikelnummer som text

        boolean found = false;
        for (Product p : products) {
            if (p.getArticleNumber().equals(articleNumber)) {// Jämför strängar med equals()
                System.out.println("Produkt hittad:");
                System.out.println("Kategori: " + p.category());
                System.out.println("Artikelnummer: " + p.getArticleNumber());
                System.out.println("Titel: " + p.getTitle());
                System.out.println("Pris: " + p.getPrice());
                System.out.println("Beskrivning: " + p.getDescription());
                found = true;
                break; // Avbryt loopen när produkten hittades
            }
        }
        if (!found) {
            System.out.println("Ingen produkt hittades med artikelnummer: " + articleNumber);

            scanner.close();
        }

    }


}

