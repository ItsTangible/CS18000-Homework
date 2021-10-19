package Homework07.Challenge;

/**
 * Homework 7 - Video
 * <p>
 * The Video class represents common details about a video uploaded to a video sharing platform.
 * Each video is created by a Channel.
 * @author Ben Winther
 * @version 10/8/2021
 */
public class Video {
    /**
     * Name of the video.
     */
    private final String videoName;
    /**
     * Channel which created the video.
     */
    private final Channel channel;
    /**
     * Length of video in seconds
     */
    private final int duration;
    /**
     * Number of views for the video, initialized at zero.
     */
    private int numViews;

    /*
     * Constructor initialies the video's name, the channel
     * it is on, and its duration of minutes and seconds.
     */
    public Video(String videoName, Channel channel, int minutes, int seconds) {
        this.videoName = videoName;
        this.channel = channel;
        this.duration = (minutes * 60) + seconds;
    }

    // Add a single view to the total views of the video
    public void addView() {
        numViews++;
    }

    // Gets the channel creating the video
    public Channel getChannel() {
        return channel;
    }

    // Returns the duration of the video as a String in the format "mm:ss"
    public String getDuration() {
        int minutes = this.duration / 60;
        int seconds = this.duration % 60;
        return "" + minutes + ":" + seconds;
    }

    // Gets the name of the video
    public String getVideoName() {
        return videoName;
    }

    // Gets total number of views of the video
    public int getViews() {
        return numViews;
    }

    // Sets the total number of views of the video
    public void setViews(int newNumViews) {
        this.numViews = newNumViews;
    }

    // Returns a string representation of Video
    @Override
    public String toString() {
        String channelName = channel.getChannelName();
        return "Video[" + videoName + ", "
                + channelName + ", " + getDuration()
                + ", " + numViews + "]";
    }
}
