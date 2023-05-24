package TestData;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;


public class CustomerData {
    protected static Faker faker = new Faker();

    public static Map<String, String> customer() {
        Map<String, String> customer = new HashMap<>();
        customer.put("firstName", faker.name().firstName());
        customer.put("lastName", faker.name().lastName());
        customer.put("email", faker.internet().emailAddress());
        customer.put("password", faker.internet().password());
        return customer;
    }
}

