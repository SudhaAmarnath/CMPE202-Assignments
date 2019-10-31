import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        BurgerComposite order = BuildOrder.getOrder();
        System.out.println(order.getDescription());
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Total Price : $" + df.format(Composite.totalPrice));
        System.out.println("--------------------------------------------------------------");        
    }
}
