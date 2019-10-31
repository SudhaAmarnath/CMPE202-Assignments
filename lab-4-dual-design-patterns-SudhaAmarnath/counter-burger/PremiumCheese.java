public class PremiumCheese extends ComponentDecorator {

    public PremiumCheese(String description, String[] options) {
        super(description);
        setOptions(options);
    }

    public void setOptions(String[] options) {
        super.setOptions(options);

        price += options.length * 1.50;
    }
}
