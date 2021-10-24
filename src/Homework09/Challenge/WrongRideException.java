package Homework09.Challenge;

import java.io.Serializable;

public class WrongRideException extends Exception implements Serializable {

    public WrongRideException(String message) {
        super(message);
    }
}
