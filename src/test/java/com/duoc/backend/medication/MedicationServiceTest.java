package com.duoc.backend.medication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MedicationServiceTest {

    @Mock
    private MedicationRepository medicationRepository;

    @InjectMocks
    private MedicationService medicationService;

    private Medication medication;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        medication = new Medication("Antibiótico de amplio espectro", 25000.0);
        medication.setId(101L);
    }

    @Test
    void testGetAllMedications() {
        when(medicationRepository.findAll()).thenReturn(Arrays.asList(medication));
        var result = medicationService.getAllMedications();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Antibiótico de amplio espectro", result.get(0).getName());
        verify(medicationRepository, times(1)).findAll();
    }

    @Test
    void testGetMedicationById() {
        when(medicationRepository.findById(101L)).thenReturn(Optional.of(medication));
        Medication result = medicationService.getMedicationById(101L);
        assertNotNull(result);
        assertEquals("Antibiótico de amplio espectro", result.getName());
        verify(medicationRepository, times(1)).findById(101L);
    }

    @Test
    void testSaveMedication() {
        when(medicationRepository.save(medication)).thenReturn(medication);
        Medication result = medicationService.saveMedication(medication);
        assertNotNull(result);
        assertEquals("Antibiótico de amplio espectro", result.getName());
        verify(medicationRepository, times(1)).save(medication);
    }

    @Test
    void testDeleteMedication() {
        medicationService.deleteMedication(101L);
        verify(medicationRepository, times(1)).deleteById(101L);
    }
}