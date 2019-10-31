
import java.text.DecimalFormat;

public class Leaf  {

    private String description ;
    private Double price ;

    public Leaf ( String d, Double p )
    {
        description = d ;
        price = p ;
    }
    
    public void printDescription() {
        DecimalFormat fmt = new DecimalFormat("0.00");
        System.out.println( description + " " + fmt.format(price) ) ;
    }

    public void addChild(Component c) {
	}

	public void removeChild(Component c) {
	}

	public Component getChild(int i) {
        return null ;
	}
	 
}
