import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Composite implements BurgerComposite {

    private String description;
    protected List<BurgerComposite> components;
    public static double totalPrice = 0;

    public Composite(String description) {
        this.description = description;
        components = new ArrayList<>();
    }

    public void addChild(BurgerComposite composite) {
        components.add(composite);
    }

    public void removeChild(BurgerComposite composite) {
        components.remove(composite);
    }

    public String getDescription() {
        StringBuffer sb = new StringBuffer();
        sb.append(description);

        if(this instanceof PriceDecorator) {
            DecimalFormat df = new DecimalFormat("#.00");
            double price = ((PriceDecorator) this).getPrice();
            totalPrice += price;
            sb.append(" : $");
            sb.append(df.format(price));
        } else {
            sb.append("\n");
        }

        sb.append("\n");

        for(BurgerComposite c : components) {
    		String str = c.getDescription();
        	if (str.length() != 0) {
        		sb.append(str);
        		sb.append("\n");        		
        	}
        }

        sb.append("");

        return sb.toString();
    }

    public BurgerComposite getChild(int index) {
        if(index >= components.size())
            return null;

        return components.get(index);
    }
}
