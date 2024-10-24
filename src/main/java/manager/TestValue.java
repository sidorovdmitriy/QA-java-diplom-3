package manager;

import org.apache.commons.lang3.RandomStringUtils;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class TestValue {
    /**
     * Contains test data for creating a user such as: login, password, name
     */
    public static final String
            TEST_EMAIL_ONE = randomAlphabetic(10).toLowerCase() + "@yandex.ru",
            TEST_PASSWORD_ONE = "123qwerty",
            PASSWORD_ERROR = "123",
            TEST_NAME_ONE = randomAlphabetic(10);
}