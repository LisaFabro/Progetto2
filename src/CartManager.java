import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
public class CartManager {
    static DemoItems demoItems = new DemoItems();

    static List<Device> deviceToCart = demoItems.getDeviceList();
    static Cart cart = new Cart();

    public void intoCart(int id) {

        Iterator<Device> iterator = deviceToCart.listIterator();
        while (iterator.hasNext()) {
            Device device = iterator.next();
            if (id == device.getId()) {
                cart.userCart.add(device);
                iterator.remove();
                break;
            }
        }
    }
    public void outOfCart(int id){

        Iterator<Device> iterator = cart.userCart.iterator();
        while (iterator.hasNext()) {
            Device userCart = iterator.next();
            if (id == userCart.getId()) {
                deviceToCart.add(userCart);
                iterator.remove();
                break;
            }
        }
    }

    public BigDecimal totalCart() {
        double total = 0.0;
        for(Device device : cart.userCart) {
            total += device.getSalesPrice();
        }
        return BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_EVEN);
    }

    public void completePurchase(){
        System.out.println("Prezzo totale: " + (totalCart()));
        cart.userCart.clear();
        System.out.println("Grazie dell'acquisto.");
    }
}
