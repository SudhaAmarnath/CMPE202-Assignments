public class ComponentDecorator extends Component implements PriceDecorator {

    protected double price;

    public ComponentDecorator(String description) {
        super(description);
        this.price = 0.0;
    }

    public double getPrice() {
        return price;
    }

}
