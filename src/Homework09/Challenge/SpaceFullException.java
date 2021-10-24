package Homework09.Challenge;

import java.io.Serializable;

public class SpaceFullException extends Exception implements Serializable {

    public SpaceFullException(String message) {
        super(message);
    }
}
