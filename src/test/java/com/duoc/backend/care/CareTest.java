package com.duoc.backend.care;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CareTest {

    @Test
    void testConstructorAndGetters() {
        Care care = new Care("Limpieza de oídos", 8000.0);

        assertEquals("Limpieza de oídos", care.getName());
        assertEquals(8000.0, care.getCost());
    }

    @Test
    void testSetters() {
        Care care = new Care("Inicial", 0.0);

        care.setId(30L);
        care.setName("Corte de uñas");
        care.setCost(4000.0);

        assertEquals(30L, care.getId());
        assertEquals("Corte de uñas", care.getName());
        assertEquals(4000.0, care.getCost());
    }
}