package oop.exams.generator;

import oop.exams.exception.BadRegionException;

public interface LicensePlateGenerator {

    String generate(String state);
    String generateRandomNumbers();
    void validateStateForPlates(String state) throws BadRegionException;
    boolean isInRepo(String state);
}
