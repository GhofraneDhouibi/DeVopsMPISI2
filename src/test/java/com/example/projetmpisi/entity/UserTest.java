package com.example.projetmpisi.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testNoArgsConstructor() {
        User user = new User();
        assertNotNull(user);
        assertEquals(0, user.getId());
        assertNull(user.getUsername());
        assertNull(user.getEmail());
    }

    @Test
    void testAllArgsConstructor() {
        User user = new User(1, "Alice", "alice@example.com");

        assertEquals(1, user.getId());
        assertEquals("Alice", user.getUsername());
        assertEquals("alice@example.com", user.getEmail());
    }

    @Test
    void testGettersAndSetters() {
        User user = new User();

        // Test setters et getters
        user.setId(1);
        user.setUsername("Bob");
        user.setEmail("bob@example.com");

        assertEquals(1, user.getId());
        assertEquals("Bob", user.getUsername());
        assertEquals("bob@example.com", user.getEmail());
    }

    @Test
    void testEqualsAndHashCode() {
        User user1 = new User(1, "Alice", "alice@example.com");
        User user2 = new User(1, "Alice", "alice@example.com");
        User user3 = new User(2, "Bob", "bob@example.com");

        // Test equals
        assertEquals(user1, user2);
        assertNotEquals(user1, user3);

        // Test hashCode
        assertEquals(user1.hashCode(), user2.hashCode());
        assertNotEquals(user1.hashCode(), user3.hashCode());
    }

    @Test
    void testToString() {
        User user = new User(1, "Alice", "alice@example.com");
        String toString = user.toString();

        assertTrue(toString.contains("Alice"));
        assertTrue(toString.contains("alice@example.com"));
        assertTrue(toString.contains("1"));
    }

    @Test
    void testEdgeCases() {
        User user = new User();

        // Test avec valeurs limites
        user.setId(Integer.MAX_VALUE);
        user.setUsername("A"); // Nom très court
        user.setEmail("a@b.c"); // Email très court

        assertEquals(Integer.MAX_VALUE, user.getId());
        assertEquals("A", user.getUsername());
        assertEquals("a@b.c", user.getEmail());
    }
}