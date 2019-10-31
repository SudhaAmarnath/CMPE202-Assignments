public class CustomBurger extends Composite implements PriceDecorator {

    private double price;

    public CustomBurger(String description) {
        super(description);
        price = 0.0;
    }

    public double getPrice() {
        for(BurgerComposite c : components) {
            if(c instanceof PriceDecorator)
                price += ((PriceDecorator) c).getPrice();
        }

        return price;
    }

}
