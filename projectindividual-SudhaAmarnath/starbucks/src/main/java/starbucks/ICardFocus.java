package starbucks;

/**
 *  ICardFocus interface : To get the focus
 */
public interface ICardFocus {

    /**
     * To set the focus
     * @param focus focus_status
     */
    void setFocus(boolean focus);

    /**
     * Get focus
     * @return focus
     */
    boolean getFocus();
}

