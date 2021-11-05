package ExamMidterm2;

/**
 * Gift Handler Interface
 *
 * @author Ben Winther
 *
 * @version 11/2/2021
 *
 */
public interface GiftHandler {

    void receiveGift(String[] gifts);

    void giveGift(String[] gifts);

    boolean canReceiveGift();

    boolean canGiveGift();
}
