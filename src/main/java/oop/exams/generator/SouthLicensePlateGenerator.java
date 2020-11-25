package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class SouthLicensePlateGenerator implements LicensePlateGenerator {
    private String[] allowedStateCodes = new String[4];

    public SouthLicensePlateGenerator() {
        allowedStateCodes[0] = "CHP";
        allowedStateCodes[1] = "GRO";
        allowedStateCodes[2] = "MIC";
        allowedStateCodes[3] = "OAX";
    }

    @Override
    public String generate(String state) {
        StringBuffer generatedPlate = new StringBuffer();

        validateStateForPlates(state);

        Random random = new Random();
        int randomInsertPosition = random.nextInt(4) + 1;
        generatedPlate.append("4" + generateRandomNumbers());
        generatedPlate.insert(randomInsertPosition, state);

        return generatedPlate.toString();
    }

    @Override
    public String generateRandomNumbers() {
        Random random = new Random();
        String randomNumbers = new String();
        for (int i = 0; i < 3; i++) {
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
                throw new BadRegionException("Allowed state codes: CHP, GRO, MIC, OAX");
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
