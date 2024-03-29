import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public abstract class MenuUsers implements Runnable {

    Warehouse warehouse = new Warehouse();
    CartManager cartManager = new CartManager();
//    Cart cart = new Cart();

    

    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);

        String nome;
        System.out.println("Inserisci il tuo nome");
        nome = scanner.next();

        int intInput;
        boolean continueLoop = true;

        do {

            System.out.println("Ciao " + nome + ", che ricerca vuoi effettuare?");
            System.out.println("1.Visualizza tutti i nostri prodotti");
            System.out.println("2.Ricerca dispositivo per brand");
            System.out.println("3.Ricerca dispositivo per modello");
            System.out.println("4.Ricerca dispositivo per tipo di prodotto");
            System.out.println("5.Ricerca dispositivo per prezzo di vendita");
            System.out.println("6.Ricerca dispositivo per range prezzo di vendita");
            System.out.println("7.Inserisci un articolo nel carrello utilizzando l'id");
            System.out.println("8.Mostra il carrello");
            System.out.println("9.Togli un articolo dal carrello utilizzando l'id");
            System.out.println("10.Finalizza l'acquisto");
            System.out.println("11. Esci");

            intInput = scanner.nextInt();

            switch (intInput) {
                case 1:
                    checkFullItemList();
                    break;
                case 2:
                    System.out.println("Scrivere il brand da ricercare");
                    String brand = scanner.next();
                    checkBrand(brand);
                    break;
                case 3:
                    System.out.println("Scrivere il modello da ricercare");
                    scanner.nextLine();
                    String model = scanner.nextLine();
                    checkModel(model);
                    break;
                case 4:
                    System.out.println("Scrivere il tipo di prodotto da ricercare");
                    String inputType = scanner.next();
                    checkDeviceForType(inputType);
                    break;
                case 5:
                    System.out.println("Scrivi il prezzo da cercare nel magazzino. Per i valori decimali utilizzare la virgola");
                    Double salesPrice = scanner.nextDouble();
                    checkSalesPrice(salesPrice);
                    break;
                case 6:
                    System.out.println("Scrivi e invia il primo valore per la ricerca. Per i valori decimali utilizzare la virgola");
                    Double inputOne = scanner.nextDouble();
                    System.out.println("Scrivi e invia il secondo valore per la ricerca. Per i valori decimali utilizzare la virgola");
                    Double inputTwo = scanner.nextDouble();
                    checkForRangePrice(inputOne, inputTwo);
                    break;
                case 7:
                    System.out.println("Seleziona l'id del prodotto che hai scelto per inserirlo nel carrello");
                    int idToPut = scanner.nextInt();
                    putInCart(idToPut);
                    break;
                case 8:
                    getUsersCartList();
                    break;
                case 9:
                    System.out.println("Seleziona l'id del prodotto che vuoi togliere dal carrello");
                    int idToRemove = scanner.nextInt();
                    removeToCart(idToRemove);
                    break;
                case 10:
                    if (!CartManager.finalCartList.isEmpty()) {
                        continueLoop = false;
                    }
                    completeCheckout();
                    break;
                case 11:
                    System.out.println("Arrivederci " + nome);
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
                    break;
            }
        } while (continueLoop);
        scanner.close();
    }


    public void checkFullItemList() {
        if (Warehouse.productList.isEmpty()) {
            System.out.println("Il magazzino è vuoto");
        } else {
            warehouse.itemsList().stream().map(Product::toStringUserList).forEach(System.out::println);

        }
    }

    public void checkBrand(String brand) {
        List<Product> searchBrandResult = warehouse.searchDeviceBrand(brand);
        if (searchBrandResult.isEmpty()) {
            System.out.println("Non abbiamo questo brand");
        } else {
            searchBrandResult.stream().map(Product::toStringUserList).forEach(System.out::println);
        }
    }

    public void checkModel(String model) {
        List<Product> searchModelResult = warehouse.searchDeviceModel(model);
        if (searchModelResult.isEmpty()) {
            System.out.println("Non abbiamo questo modello o scrivere correttamente rispettando gli spazi");
        } else {
            searchModelResult.stream().map(Product::toStringUserList).forEach(System.out::println);

        }
    }

    public void checkDeviceForType(String inputStringType) {
        try {
            ProductTypes productTypes = ProductTypes.valueOf(inputStringType.toUpperCase());
            List<Product> searchTypeResult = warehouse.searchDeviceType(productTypes);

            if (searchTypeResult.isEmpty()) {
                System.out.println("Non abbiamo questo tipo di prodotto");
            } else {
                searchTypeResult.stream().map(Product::toStringUserList).forEach(System.out::println);

            }
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo di prodotto non trovato: " + inputStringType);
        }
    }

    public void checkSalesPrice(Double salesPrice) {

        List<Product> result = warehouse.searchForSalesPrice(salesPrice);

        if (result.isEmpty()) {
            System.out.println("Nessun prodotto al di sotto di questo prezzo");
        } else {
            result.stream().map(Product::toStringUserList).forEach(System.out::println);
        }
    }

    public void checkForRangePrice(double inputOne, double inputTwo) {

        List<Product> result = warehouse.searchForRange(inputOne, inputTwo);

        if (result.isEmpty()) {
            System.out.println("Nessun prodotto trovato per questo range di prezzo");
        } else {
            result.stream().map(Product::toStringUserList).forEach(System.out::println);
        }
    }

    public void putInCart(int idToPut) {
        int initialCartSize = CartManager.finalCartList.size();
        List<Product> updatedCart = cartManager.intoCart(idToPut);
        int finalCartSize = CartManager.finalCartList.size();

        String message = (finalCartSize > initialCartSize) ?
                "Il prodotto è stato inserito correttamente nel carrello\n" :
                "L'id inserito non è esistente o è già presente nel carrello\n";

        System.out.println(message + "\nCarrello attuale:\n");
        updatedCart.forEach(product -> System.out.println(product.toStringUserList()));
        System.out.println();

    }

    public void getUsersCartList() {
        if (CartManager.finalCartList.isEmpty()) {
            System.out.println("Non ci sono prodotti nel tuo carrello\n");
        } else {
            System.out.println("Questo é il tuo carrello attuale:");
            BigDecimal totalCart = cartManager.totalCart();
            CartManager.finalCartList.forEach(System.out::println);
            System.out.println("Questo é il tuo totale attuale: " + totalCart);
            System.out.println();
        }
    }

    public void removeToCart(int idToRemove) {
        int initialCartSize = CartManager.finalCartList.size();
        List<Product> updatedCart = cartManager.outOfCart(idToRemove);
        int finalCartSize = CartManager.finalCartList.size();

        String message = (finalCartSize < initialCartSize) ?
                "Il prodotto è stato rimosso correttamente dal carrello\n" :
                "L'id inserito non è esistente o non è presente nel carrello\n";

        System.out.println(message + "\nCarrello attuale:\n");
        updatedCart.forEach(product -> System.out.println(product.toStringUserList() + "\n"));

    }

    public void completeCheckout() {
        BigDecimal totalCart = cartManager.totalCart();
        if (!CartManager.finalCartList.isEmpty()) {
            System.out.println("Prezzo totale:\n" + totalCart);
            cartManager.completePurchase();
            System.out.println("Grazie dell'acquisto, arrivederci!");
        } else {
            System.out.println("Il carrello non contiene alcun prodotto, impossibile completare l'acquisto\n");
        }
    }
}