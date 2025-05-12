package com.duoc.backend.appointment;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void testGettersAndSetters() {
        Appointment appointment = new Appointment();
        LocalDate date = LocalDate.of(2025, 8, 20);
        LocalTime time = LocalTime.of(9, 15);

        appointment.setId(5L);
        appointment.setDate(date);
        appointment.setTime(time);
        appointment.setReason("Vacunación antirrábica");
        appointment.setVeterinarian("Dra. Silva");

        assertEquals(5L, appointment.getId());
        assertEquals(date, appointment.getDate());
        assertEquals(time, appointment.getTime());
        assertEquals("Vacunación antirrábica", appointment.getReason());
        assertEquals("Dra. Silva", appointment.getVeterinarian());
    }
}
