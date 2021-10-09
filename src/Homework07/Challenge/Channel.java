package Homework07.Challenge;

/**
 * Homework 7 - Channel
 * <p>
 * The Channel class represents details about a content uploader.
 * This includes their channel name, subscribers, an array of Video
 * objects created by them, and the number of uploads.
 * @author Ben Winther, ItsTangible
 * @version 10/8/2021
 */
public class Channel {
    /**
     * Name of the channel
     */
    private final String channelName;
    /**
     * Number of subscribers of this channel
     */
    private int channelSubscribers;
    /**
     * Number of videos uploaded by this channel. This may be of use when iterating through the videos array.
     */
    private int numUploads;
    /**
     * An array containing videos uploaded by this creator.
     */
    private Video[] videos;

    //  Creates a basic Channel object.
    public Channel(String channelName) {
        this.channelName = channelName;
        this.channelSubscribers = 0;
        this.numUploads = 0;
        this.videos = new Video[100];
    }

    // Creates a Channel object from the given parameters.
    public Channel(String channelName, int channelSubscribers, int numUploads, Video[] videos) {
        this.channelName = channelName;
        this.channelSubscribers = channelSubscribers;
        this.numUploads = numUploads;
        this.videos = videos;
    }

    // Adds a single subscriber to the total subscriber count of this channel
    public void addChannelSubscriber() {
        channelSubscribers++;
    }

    // Find a video in the channel's array of videos, identified by having the same videoName
    public Video findVideo(String videoName) {
        for (int i = 0; i < numUploads; i++) {
            String curName = videos[i].getVideoName();
            if (curName == videoName) {
                return videos[i];
            }
        }
        return null;
    }

    // Returns the name of the channel
    public String getChannelName() {
        return channelName;
    }

    // Returns the number of subscribers
    public int getChannelSubscribers() {
        return channelSubscribers;
    }

    // Returns the total number of videos uploaded by this channel
    public int getNumUploads() {
        return numUploads;
    }

    // Returns the total number of views from all the videos present in this channel
    public int getTotalViews() {
        int totalViews = 0;
        for (int i = 0; i < numUploads; i++) {
            int curVid = videos[i].getViews();
            totalViews += curVid;
        }
        return totalViews;
    }

    // Returns an array containing Video objects representing videos uploaded by this channel
    public Video[] getVideos() {
        return videos;
    }

    // Sets the number of subscribers to this channel
    public void setChannelSubscribers(int channelSubscribers) {
        this.channelSubscribers = channelSubscribers;
    }

    /**
     * Sets the array containing Video objects representing
     * videos uploaded by this channel to a new array, and
     * updates the number of uploads from the channel as
     * well.
     */
    public void setVideos(Video[] newVids, int newNumUploads) {
        this.videos = newVids;
        this.numUploads = newNumUploads;
    }

    // Returns a string representation of Channel
    @Override
    public String toString() {
        return "Channel[" + channelName + ", "
                + channelSubscribers + ", "
                + numUploads + "]";
    }

    /**
     * Adds a given Video to the array of videos uploaded
     * by this channel and increments numUploads by 1. If
     * there are already 100 videos uploaded by this
     * channel, the request is rejected by returning false.
     * Furthermore, if there already exists a video in
     * videos with the same name, the request is rejected
     * by returning false.
     */
    public boolean uploadVideo(Video video) {
        if (numUploads == 100) {
            return false;
        }
        for (int i = 0; i < numUploads; i++) {
            String uploadName = video.getVideoName();
            String curName = videos[i].getVideoName();
            if (uploadName.equals(curName)) {
                return false;
            }
        }
        videos[numUploads] = video;
        numUploads++;
        return true;
    }
}
