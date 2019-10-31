public class Sauce extends ComponentDecorator {

    public Sauce(String description, String[] options) {
        super(description);
        setOptions(options);
    }

    public void setOptions(String[] options) {
        super.setOptions(options);

        int quantity = options.length;
        if(quantity > 1) {
            price += (quantity - 1) * 0.75;
        }
    }
}
