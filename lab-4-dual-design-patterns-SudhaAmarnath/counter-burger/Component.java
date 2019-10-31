public class Component implements BurgerComposite {

    private String[] options;

    public Component(String description) {
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void addChild(BurgerComposite composite) {}

    public void removeChild(BurgerComposite composite) {}

    public String getDescription() {
        StringBuffer sb = new StringBuffer();
        for(String o : options) {
            if(sb.length() > 0)
                sb.append(" + ");
            sb.append(o);
        }

        return sb.toString();
    }

    public BurgerComposite getChild(int index) {
        return null;
    }

}
