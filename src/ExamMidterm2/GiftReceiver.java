package ExamMidterm2;

import java.util.Arrays;
import java.util.Objects;
/**
 * Gift Receiver Class
 *
 * @author Ben Winther
 *
 * @version 11/2/2021
 *
 */
public class GiftReceiver implements GiftHandler {

    private final String name;

    private String[] receivedGifts;

    private int numGiftsReceived;

    private final int maxGifts;

    public GiftReceiver(String name, int maxGifts) {
        this.name = name;
        this.maxGifts = maxGifts;
        this.numGiftsReceived = 0;
        this.receivedGifts = new String[maxGifts];
    }

    public String getName() {
        return name;
    }

    @Override
    public void receiveGift(String[] gifts) {
        if(canReceiveGift() && numGiftsReceived + gifts.length < maxGifts) {
            for (int i = numGiftsReceived, j = 0; i < maxGifts - 1; i++, j++) {
                receivedGifts[i] =gifts[j];
            }
        }
    }

    @Override
    public void giveGift(String[] gifts) {
        System.out.println("Not allowed to give gifts!");
    }

    @Override
    public boolean canReceiveGift() {
        return numGiftsReceived < maxGifts;
    }

    @Override
    public boolean canGiveGift() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GiftReceiver)) return false;
        GiftReceiver that = (GiftReceiver) o;
        return numGiftsReceived == that.numGiftsReceived && maxGifts == that.maxGifts && Objects.equals(getName(), that.getName()) && Arrays.equals(receivedGifts, that.receivedGifts);
    }
}
