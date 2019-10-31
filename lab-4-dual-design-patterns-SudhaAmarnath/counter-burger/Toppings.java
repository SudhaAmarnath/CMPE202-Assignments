public class Toppings extends ComponentDecorator {

    public Toppings(String description, String[] options) {
        super(description);
        setOptions(options);
    }

    public void setOptions(String[] options) {
        super.setOptions(options);

        int quantity = options.length;
        if(quantity > 4) {
            price += (quantity - 4) * 0.75;
        }
        
    }
}
