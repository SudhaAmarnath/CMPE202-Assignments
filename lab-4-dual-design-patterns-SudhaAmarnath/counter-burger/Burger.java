public class Burger extends ComponentDecorator {

    public Burger(String description, String[] options) {
        super(description);
        setOptions(options);
    }

    public void setOptions(String[] options) {
        super.setOptions(options);

        for(String o : options) {
            switch(o) {
                case "1/3lb.":
                    price += 9.50;
                    break;
                case "2/3lb.":
                    price += 11.50;
                    break;
                case "1lb.":
                    price += 15.50;
                    break;
                case "In A Bowl":
                    price += 1.00;
                    break;
            }
        }
    }
}
