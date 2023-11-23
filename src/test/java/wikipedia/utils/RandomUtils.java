package wikipedia.utils;


import com.github.javafaker.Faker;

public class RandomUtils {

    Faker faker = new Faker();

    private String getUsername() {
        return faker.name().fullName();

    }
    private String getPassword() {
        return faker.lordOfTheRings().location();
    }

    public String username = getUsername(),
    password = getPassword();


}
