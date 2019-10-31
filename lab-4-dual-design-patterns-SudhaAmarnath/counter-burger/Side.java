public class Side extends ComponentDecorator {

    public Side(String description, String[] options) {
        super(description);
        setOptions(options);
    }

    public void setOptions(String[] options) {
        super.setOptions(options);

        for(String o : options) {
            switch(o) {
            	case "Crispy Onion Strings":
            		price += 5.50;
            		break;
            	case "The Purist":
            		price += 8.00;
            		break;
            }
        }
        
    }
}
