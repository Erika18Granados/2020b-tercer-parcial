package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.ArrayList;
import java.util.Random;

public class DefaultLicensePlateGenerator implements LicensePlateGenerator {
    private String[] allowedStateCodes = new String[11];

    public DefaultLicensePlateGenerator() {
        allowedStateCodes[0] = "AGU";
        allowedStateCodes[1] = "CMX";
        allowedStateCodes[2] = "DUR";
        allowedStateCodes[3] = "GUA";
        allowedStateCodes[4] = "HID";
        allowedStateCodes[5] = "MEX";
        allowedStateCodes[6] = "PUE";
        allowedStateCodes[7] = "QUE";
        allowedStateCodes[8] = "SLP";
        allowedStateCodes[9] = "TLA";
        allowedStateCodes[10] = "ZAC";
    }

    @Override
    public String generate(String state) throws BadRegionException {
        String generatedPlate = new String();

        validateStateForPlates(state);

        generatedPlate = '5' + generateRandomNumbers();
        return generatedPlate;
    }

    @Override
    public String generateRandomNumbers() {
        Random random = new Random();
        String randomNumbers = new String();
        for (int i = 0; i < 7; i++) {
            randomNumbers = randomNumbers + random.nextInt(9);
        }
        return randomNumbers;
    }

    @Override
    public void validateStateForPlates(String state) throws BadRegionException{
        try {
            if(isInRepo(state)) {
                return;
            } else {
                throw new BadRegionException("Allowed state codes: AGU, CMX, DUR, GUA, HID, MEX, PUE, QUE, SLP, TLA, ZAC");
            }
        } catch(BadRegionException e) {
            throw e;
        }
    }

    @Override
    public boolean isInRepo(String state){
        for(int i = 0; i < 11; i++) {
            if(allowedStateCodes[i].equals(state)) {
                return true;
            }
        }
        return false;
    }
}
