package bgchv.antn.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomMethods {

    static Faker fakerEn = new Faker(new Locale("en"));

    public static String getRandomFullName() {
        return fakerEn.name().fullName();
    }

    public static String getRandomEmail() {
        return fakerEn.internet().emailAddress();
    }

    public static String getRandomAddress() {
        return fakerEn.address().fullAddress();
    }
}
