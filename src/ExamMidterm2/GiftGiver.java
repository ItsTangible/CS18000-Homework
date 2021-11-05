package ExamMidterm2;

import java.util.Arrays;
import java.util.Objects;
/**
 * Gift Giver Class
 *
 * @author Ben Winther
 *
 * @version 11/2/2021
 *
 */
public class GiftGiver implements GiftHandler {

    private final String name;

    private String[] givenGifts;

    public GiftGiver(String name) {
        this.name = name;
        this.givenGifts = new String[] {"None"};

    }

    public String getName() {
        return name;
    }

    @Override
    public void receiveGift(String[] gifts) {
        System.out.println("Not allowed to receive gifts!");
    }

    @Override
    public void giveGift(String[] gifts) {
        String[] temp = new String[givenGifts.length + gifts.length];
        for (int i = 0; i < givenGifts.length - 1; i++) {
            temp[i] = givenGifts[i];
        }
        for (int i = givenGifts.length, j = 0; i < temp.length; i++, j++) {
            temp[i] = gifts[j];
        }
        givenGifts = temp;
    }

    @Override
    public boolean canReceiveGift() {
        return false;
    }

    @Override
    public boolean canGiveGift() {
        return true;
    }
    @Override
    public String toString() {
        return "GiftGiver{" +
                "name='" + name + '\'' +
                ", givenGifts=" + Arrays.toString(givenGifts) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GiftGiver)) return false;
        GiftGiver giftGiver = (GiftGiver) o;
        return Objects.equals(getName(), giftGiver.getName()) && Arrays.equals(givenGifts, giftGiver.givenGifts);
    }

}
