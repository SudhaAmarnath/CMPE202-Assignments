public interface BurgerComposite {

    void addChild(BurgerComposite composite);

    void removeChild(BurgerComposite composite);

    String getDescription();

    BurgerComposite getChild(int index);
    
}
