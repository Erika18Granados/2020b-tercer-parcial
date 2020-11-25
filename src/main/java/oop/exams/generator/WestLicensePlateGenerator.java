package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class WestLicensePlateGenerator implements LicensePlateGenerator {
    private String[] allowedStateCodes = new String[4];

    public WestLicensePlateGenerator() {
        allowedStateCodes[0] = "COL";
        allowedStateCodes[1] = "JAL";
        allowedStateCodes[2] = "NAY";
        allowedStateCodes[3] = "SIN";
    }

    @Override
    public String generate(String state) {
        String generatedPlate = new String();

        validateStateForPlates(state);

        generatedPlate = '2' + generateRandomNumbers() + state;
        return generatedPlate;
    }

    @Override
    public String generateRandomNumbers() {
        Random random = new Random();
        String randomNumbers = new String();
        randomNumbers = randomNumbers + random.nextInt(9);
        return randomNumbers;
    }

    @Override
    public void validateStateForPlates(String state) throws BadRegionException {
        try {
            if(isInRepo(state)) {
                return;
            } else {
                throw new BadRegionException("Allowed state codes: COL, JAL, NAY, SIN");
            }
        } catch(BadRegionException e) {
            throw e;
        }
    }

    @Override
    public boolean isInRepo(String state) {
        for(int i = 0; i < 4; i++) {
            if(allowedStateCodes[i].equals(state)) {
                return true;
            }
        }
        return false;
    }
}
