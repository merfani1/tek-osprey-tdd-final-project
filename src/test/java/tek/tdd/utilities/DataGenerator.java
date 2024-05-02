package tek.tdd.utilities;

import java.util.Random;

public class DataGenerator {
    public static String randomEmail(){
        String prefix = "Reza.S_";
        String emailProvider = "@gmail.com";
        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        return prefix + randomNumber + emailProvider;
    }
}
