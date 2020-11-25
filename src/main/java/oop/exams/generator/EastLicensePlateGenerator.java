package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class EastLicensePlateGenerator implements LicensePlateGenerator {
    private String[] allowedStateCodes = new String[5];

    public EastLicensePlateGenerator() {
        allowedStateCodes[0] = "CAM";
        allowedStateCodes[1] = "ROO";
        allowedStateCodes[2] = "TAB";
        allowedStateCodes[3] = "VER";
        allowedStateCodes[4] = "YUC";
    }

    @Override
    public String generate(String state) {
        String generatedPlate = new String();

        validateStateForPlates(state);

        generatedPlate = '3' + generateRandomNumbers() + 'Z';
        return generatedPlate;
    }

    @Override
    public String generateRandomNumbers() {
        Random random = new Random();
        String randomNumbers = new String();
        for (int i = 0; i < 2; i++) {
            randomNumbers = randomNumbers + random.nextInt(9);
        }
        return randomNumbers;
    }

    @Override
    public void validateStateForPlates(String state) throws BadRegionException {
        try {
            if(isInRepo(state)) {
                return;
            } else {
                throw new BadRegionException("Allowed state codes: CAM, ROO, TAB, VER, YUC");
            }
        } catch(BadRegionException e) {
            throw e;
        }
    }

    @Override
    public boolean isInRepo(String state) {
        for(int i = 0; i < 5; i++) {
            if(allowedStateCodes[i].equals(state)) {
                return true;
            }
        }
        return false;
    }
}
