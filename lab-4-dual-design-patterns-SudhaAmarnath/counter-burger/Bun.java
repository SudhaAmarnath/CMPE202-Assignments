public class Bun extends ComponentDecorator {

    public Bun(String description, String[] options) {
        super(description);
        setOptions(options);
    }

    public void setOptions(String[] options) {
        super.setOptions(options);

        for(String o : options) {
            switch(o) {
                case "Pretzel Bun":
                    price += 0.50;
                    break;
                case "Gluten-Free Bun":
                    price += 1.00;
                    break;
                case "Hawaiian Bun":
                    price += 1.00;
                    break;
            }
        }
    }
}
