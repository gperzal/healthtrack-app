package com.healthtrack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the User class.
 */
public class UserTest {

    @Test
    public void testUpdateWeight() {
        User user = new User("John", 70.0);
        user.updateWeight(72.5);
        assertEquals(72.5, user.getWeight(), 0.01, "Weight should be updated correctly");
    }

    @Test
    public void testUserNameStaysTheSame() {
        User user = new User("Anna", 65.0);
        user.updateWeight(66.0);
        assertEquals("Anna", user.getName(), "User name should remain unchanged");
    }
}
