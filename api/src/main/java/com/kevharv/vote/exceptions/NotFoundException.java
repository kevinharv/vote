package com.kevharv.vote.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id, String type) {
        super("Could not find " + type + " with ID " + id);
    }
}
