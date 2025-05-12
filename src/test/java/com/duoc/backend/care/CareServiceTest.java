package com.duoc.backend.care;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CareControllerTest {

    @Mock
    private CareRepository careRepository;

    @InjectMocks
    private CareController careController;

    public CareControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCares() {
        Care care1 = new Care("Vacunación antirrábica", 25000.0);
        care1.setId(20L);

        Care care2 = new Care("Desparasitación externa", 18000.0);
        care2.setId(21L);

        List<Care> cares = Arrays.asList(care1, care2);
        when(careRepository.findAll()).thenReturn(cares);

        List<Care> result = careController.getAllCares();

        assertEquals(2, result.size());
        assertEquals("Vacunación antirrábica", result.get(0).getName());
        assertEquals("Desparasitación externa", result.get(1).getName());
        verify(careRepository, times(1)).findAll();
    }

    @Test
    void testGetCareById() {
        Care care = new Care("Cirugía menor", 45000.0);
        care.setId(22L);

        when(careRepository.findById(22L)).thenReturn(Optional.of(care));

        Care result = careController.getCareById(22L);

        assertEquals("Cirugía menor", result.getName());
        assertEquals(45000.0, result.getCost());
        verify(careRepository, times(1)).findById(22L);
    }

    @Test
    void testSaveCare() {
        Care care = new Care("Chequeo general", 15000.0);
        when(careRepository.save(care)).thenReturn(care);

        Care result = careController.saveCare(care);

        assertEquals("Chequeo general", result.getName());
        verify(careRepository, times(1)).save(care);
    }

    @Test
    void testDeleteCare() {
        Long careId = 20L;

        careController.deleteCare(careId);

        verify(careRepository, times(1)).deleteById(careId);
    }
}