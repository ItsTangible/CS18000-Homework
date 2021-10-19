package Homework07.Challenge;

/**
 * Homework 7 - Profile
 * <p>
 * The Profile class represents details about a content viewer.
 * This includes their username, an array of Channel
 * objects representing content creators they've subscribed to, and the
 * number of channels subscribed to.
 * @author Ben Winther
 * @version 10/8/2021
 */
public class Profile {
    /**
     * Username of the user
     */
    private final String username;
    /**
     * An array containing channels subscribed to by this user.
     */
    private Channel[] subscribed;
    /**
     * Number of channels subscribed to by this user
     */
    private int numSubscribed;

    /**
     * Initializes a Profile with a given username, setting the
     * numSubscribed to zero, and creating an subscribed array
     * of size 100.
     */
    public Profile(String username) {
        this.username = username;
        this.numSubscribed = 0;
        this.subscribed = new Channel[100];
    }

    /**
     * Find a channel in the profile's array of channels,
     * identified by having the same channelName (case-sensitive)
     */
    public Channel findChannel(String channelName) {
        for (int i = 0; i < numSubscribed; i++) {
            String cur = subscribed[i].getChannelName();
            if (cur.equals(channelName)) {
                return subscribed[i];
            }
        }
        return null;
    }

    /**
     * Returns an array containing Channel objects subscribed to by
     * the current profile
     */
    public Channel[] getSubscribed() {
        return subscribed;
    }

    // Returns the username of the current profile
    public String getUsername() {
        return username;
    }

    /**
     * Sets the array containing Channel objects representing channels
     * subscribed by this profile to a new array, and updates the
     * number of channels the profile is subscribed to as well
     */
    public void setSubscribed(Channel[] newSubscribed, int newNumSubscribed) {
        this.subscribed = newSubscribed;
        this.numSubscribed = newNumSubscribed;
    }

    /**
     * Adds a given Channel to the array of channels subscribed to by
     * this user If there are already 100 subscribed channels, the
     * request is rejected by returning false
     */
    public boolean subscribeToChannel(Channel channel) {
        // Checks is subscribed = 100
        if (numSubscribed == 100) {
            return false;
        }
        // Checks if channel is already in subscribed
        for(int i = 0; i < numSubscribed; i++) {
            String cur = subscribed[i].getChannelName();
            String channelName = channel.getChannelName();
            if (cur.equals(channelName)) {
                return false;
            }
        }
        // Adds channel if both above aren't true
        subscribed[numSubscribed] = channel;
        numSubscribed++;
        channel.addChannelSubscriber();
        return true;
    }

    // Returns a string representation of Profile
    @Override
    public String toString() {
        return "Profile[" + username + "]";
    }
}
