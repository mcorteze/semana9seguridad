package com.duoc.backend.medication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MedicationTest {

    @Test
    void testConstructorAndGetters() {
        Medication medication = new Medication("Suplemento vitamínico", 12000.0);

        assertEquals("Suplemento vitamínico", medication.getName());
        assertEquals(12000.0, medication.getCost());
    }

    @Test
    void testSettersAndGetters() {
        Medication medication = new Medication("Inicial", 0.0);

        medication.setId(201L);
        medication.setName("Analgésico veterinario");
        medication.setCost(18000.0);

        assertEquals(201L, medication.getId());
        assertEquals("Analgésico veterinario", medication.getName());
        assertEquals(18000.0, medication.getCost());
    }
}
