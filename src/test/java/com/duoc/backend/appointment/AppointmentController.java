package com.duoc.backend.appointment;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AppointmentControllerTest {

    @Mock
    private AppointmentService appointmentService;

    @InjectMocks
    private AppointmentController appointmentController;

    public AppointmentControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAppointments() {
        Appointment appt1 = new Appointment();
        appt1.setId(10L);
        appt1.setDate(LocalDate.of(2025, 10, 5));
        appt1.setTime(LocalTime.of(14, 0));
        appt1.setReason("Desparasitación interna");
        appt1.setVeterinarian("Dra. Silva");

        Appointment appt2 = new Appointment();
        appt2.setId(11L);
        appt2.setDate(LocalDate.of(2025, 11, 15));
        appt2.setTime(LocalTime.of(9, 30));
        appt2.setReason("Chequeo general");
        appt2.setVeterinarian("Dr. Ortega");

        List<Appointment> appointments = Arrays.asList(appt1, appt2);
        when(appointmentService.getAllAppointments()).thenReturn(appointments);

        List<Appointment> result = appointmentController.getAllAppointments();

        assertEquals(2, result.size());
        assertEquals("Desparasitación interna", result.get(0).getReason());
        assertEquals("Chequeo general", result.get(1).getReason());
        verify(appointmentService, times(1)).getAllAppointments();
    }

    @Test
    void testGetAppointmentById() {
        Appointment appt = new Appointment();
        appt.setId(12L);
        appt.setDate(LocalDate.of(2025, 12, 1));
        appt.setTime(LocalTime.of(11, 45));
        appt.setReason("Esterilización");
        appt.setVeterinarian("Dra. Torres");

        when(appointmentService.getAppointmentById(12L)).thenReturn(appt);

        Appointment result = appointmentController.getAppointmentById(12L);

        assertEquals("Esterilización", result.getReason());
        assertEquals("Dra. Torres", result.getVeterinarian());
        verify(appointmentService, times(1)).getAppointmentById(12L);
    }

    @Test
    void testSaveAppointment() {
        Appointment appt = new Appointment();
        appt.setDate(LocalDate.of(2025, 10, 20));
        appt.setTime(LocalTime.of(8, 15));
        appt.setReason("Microchip");
        appt.setVeterinarian("Dr. Castro");

        when(appointmentService.saveAppointment(appt)).thenReturn(appt);

        Appointment result = appointmentController.saveAppointment(appt);

        assertEquals("Microchip", result.getReason());
        verify(appointmentService, times(1)).saveAppointment(appt);
    }

    @Test
    void testDeleteAppointment() {
        Long appointmentId = 10L;

        appointmentController.deleteAppointment(appointmentId);

        verify(appointmentService, times(1)).deleteAppointment(appointmentId);
    }
}