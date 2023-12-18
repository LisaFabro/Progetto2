public class Main {

 static Interface anInterface = new Interface();
    static Cart cart = new Cart();
    static CartManager cartManager = new CartManager();
    public static void main(String[] args) {
       // anInterface.createInterface();
        cartManager.intoCart(2);

        System.out.println(cart.userCart);
    }
}