package unla.oo2.grupo24.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import unla.oo2.grupo24.entity.SensorEstacionamiento;
import unla.oo2.grupo24.repository.DispositivoRepo;
import unla.oo2.grupo24.service.imp.EstacionamientoSevicesImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class EstacionamientoSevicesImpTest {

    @InjectMocks
    private EstacionamientoSevicesImp servicio;

    @Mock
    private DispositivoRepo repo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdd() {
        SensorEstacionamiento sensor = new SensorEstacionamiento();
        // Configura el objeto según tus necesidades

        servicio.add(sensor);
        verify(repo, times(1)).save(sensor);
    }

    @Test
    void testGetAll() {
        List<SensorEstacionamiento> lista = new ArrayList<>();
        when(repo.findAllSensorEstacionamiento()).thenReturn(lista);

        List<SensorEstacionamiento> resultado = servicio.getAll();
        verify(repo, times(1)).findAllSensorEstacionamiento();
        assertSame(lista, resultado);
    }

    @Test
    void testGetById() {
        long id = 1L;
        SensorEstacionamiento sensor = new SensorEstacionamiento();
        when(repo.findById(id)).thenReturn(Optional.of(sensor));

        SensorEstacionamiento resultado = servicio.getById(id);
        verify(repo, times(1)).findById(id);
        assertSame(sensor, resultado);
    }

    @Test
    void testModify() {
        SensorEstacionamiento sensor = new SensorEstacionamiento();
        // Configura el objeto según tus necesidades

        when(repo.save(sensor)).thenReturn(sensor);
        SensorEstacionamiento resultado = servicio.modify(sensor);

        verify(repo, times(1)).save(sensor);
        assertSame(sensor, resultado);
    }

    @Test
    void testDelete() {
        long id = 1L;
        servicio.delete(id);
        verify(repo, times(1)).deleteById(id);
    }
}
