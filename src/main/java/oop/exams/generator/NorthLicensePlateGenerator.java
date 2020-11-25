package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class NorthLicensePlateGenerator implements LicensePlateGenerator {
    private String[] allowedStateCodes = new String[7];

    public NorthLicensePlateGenerator() {
        allowedStateCodes[0] = "BCN";
        allowedStateCodes[1] = "BCS";
        allowedStateCodes[2] = "CHH";
        allowedStateCodes[3] = "COA";
        allowedStateCodes[4] = "NLE";
        allowedStateCodes[5] = "TAM";
        allowedStateCodes[6] = "SON";
    }

    @Override
    public String generate(String state) {
        String generatedPlate = new String();

        validateStateForPlates(state);

        generatedPlate = '1' + state + generateRandomNumbers();
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
                throw new BadRegionException("Allowed state codes: BCN, BCS, CHH, COA, NLE, SON, TAM");
            }
        } catch(BadRegionException e) {
            throw e;
        }
    }

    @Override
    public boolean isInRepo(String state) {
        for(int i = 0; i < 7; i++) {
            if(allowedStateCodes[i].equals(state)) {
                return true;
            }
        }
        return false;
    }
}
