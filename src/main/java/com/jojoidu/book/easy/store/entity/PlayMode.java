package com.jojoidu.book.easy.store.entity;

public enum PlayMode {

    EXPLAIN,
    PRACTICE;

    public static boolean isValid(String mode) {
        for (PlayMode playMode : values()) {
            if (playMode.name().equalsIgnoreCase(mode)) {
                return true;
            }
        }
        return false;
    }
}
