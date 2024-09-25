package unla.oo2.grupo24.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import unla.oo2.grupo24.entity.Dispositivo;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.repository.EventoRepo;
import unla.oo2.grupo24.service.imp.EventoServiceImp;

public class EventoServiceImpTest {

    @Mock
    private EventoRepo repo;

    @InjectMocks
    private EventoServiceImp servicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdd() {
        Evento evento = new Evento();
        // Configura el evento según tus necesidades

        when(repo.save(evento)).thenReturn(evento);
        boolean resultado = servicio.add(evento);

        verify(repo, times(1)).save(evento);
        assertTrue(resultado);
    }

    @Test
    void testGetAll() {
        Evento evento1 = new Evento();
        Evento evento2 = new Evento();
        when(repo.findAll()).thenReturn(Arrays.asList(evento1, evento2));

        List<Evento> resultado = servicio.getAll();

        verify(repo, times(1)).findAll();
        assertEquals(2, resultado.size());
    }

    @Test
    void testGetById() {
        long id = 1L;
        Evento evento = new Evento();
        when(repo.findById(id)).thenReturn(Optional.of(evento));

        Evento resultado = servicio.getById(id);

        verify(repo, times(1)).findById(id);
        assertSame(evento, resultado);
    }

    @Test
    void testModify() {
        Evento evento = new Evento();
        // Configura el evento según tus necesidades

        when(repo.save(evento)).thenReturn(evento);
        Evento resultado = servicio.modify(evento);

        verify(repo, times(1)).save(evento);
        assertSame(evento, resultado);
    }

    @Test
    void testDelete() {
        long id = 1L;

        servicio.delete(id);

        verify(repo, times(1)).deleteById(id);
    }

    @Test
    void testFiltrarPorTipo() {
        String tipoDispositivo = "tipo1";
        Evento evento1 = new Evento();
        Evento evento2 = new Evento();

        when(repo.findByTipe(tipoDispositivo)).thenReturn(Arrays.asList(evento1, evento2));

        List<Evento> resultado = servicio.filtrarPorTipo(tipoDispositivo);

        verify(repo, times(1)).findByTipe(tipoDispositivo);
        assertEquals(2, resultado.size());
    }

    @Test
    void testFiltrarPorTipoYDispositivo() {
        String tipoDispositivo = "tipo1";
        int dispositivoId = 1;
        Dispositivo dispositivo = new Dispositivo("Dispositivo 1", "Descripción", true, LocalDate.now());
        dispositivo.setIdDispositivo(dispositivoId); // Suponiendo que tienes un método para establecer el ID

        Evento evento1 = new Evento();
        evento1.setDispositivo(dispositivo);

        Evento evento2 = new Evento();
        evento2.setDispositivo(new Dispositivo("Dispositivo 2", "Descripción", true, LocalDate.now()));

        when(repo.findByTipe(tipoDispositivo)).thenReturn(Arrays.asList(evento1, evento2));

        List<Evento> resultado = servicio.filtrarPorTipoYDispositivo(tipoDispositivo, dispositivoId);

        assertEquals(1, resultado.size());
        assertEquals(dispositivoId, resultado.get(0).getDispositivo().getIdDispositivo());
    }

    @Test
    void testFiltrarPorTipoYFecha() {
        String tipoDispositivo = "tipo1";
        LocalDateTime fechaHoraInicio = LocalDateTime.now().minusDays(1);
        LocalDateTime fechaHoraFin = LocalDateTime.now().plusDays(1);

        Evento evento1 = new Evento();
        evento1.setFechaHora(LocalDateTime.now()); // Dentro del rango

        Evento evento2 = new Evento();
        evento2.setFechaHora(LocalDateTime.now().minusDays(2)); // Fuera del rango

        when(repo.findByTipe(tipoDispositivo)).thenReturn(Arrays.asList(evento1, evento2));

        List<Evento> resultado = servicio.filtrarPorTipoYFecha(tipoDispositivo, fechaHoraInicio, fechaHoraFin);

        assertEquals(1, resultado.size());
        assertSame(evento1, resultado.get(0));
    }

    @Test
    void testFiltrarPorTipoYDispositivoYFecha() {
        String tipoDispositivo = "tipo1";
        int dispositivoId = 1;
        LocalDateTime fechaHoraInicio = LocalDateTime.now().minusDays(1);
        LocalDateTime fechaHoraFin = LocalDateTime.now().plusDays(1);

        Dispositivo dispositivo = new Dispositivo("Dispositivo 1", "Descripción", true, LocalDate.now());
        dispositivo.setIdDispositivo(dispositivoId);

        Evento evento1 = new Evento();
        evento1.setDispositivo(dispositivo);
        evento1.setFechaHora(LocalDateTime.now()); // Dentro del rango

        Evento evento2 = new Evento();
        evento2.setDispositivo(new Dispositivo("Dispositivo 2", "Descripción", true, LocalDate.now()));
        evento2.setFechaHora(LocalDateTime.now().minusDays(2)); // Fuera del rango

        when(repo.findByTipe(tipoDispositivo)).thenReturn(Arrays.asList(evento1, evento2));

        List<Evento> resultado = servicio.filtrarPorTipoYDispositivoYFecha(tipoDispositivo, dispositivoId, fechaHoraInicio, fechaHoraFin);

        assertEquals(1, resultado.size());
        assertSame(evento1, resultado.get(0));
    }


    @Test
    void testFiltrarPorTipoYFechaConLimites() {
        String tipoDispositivo = "tipo1";
        LocalDateTime fechaHoraInicio = LocalDateTime.now().minusDays(1);
        LocalDateTime fechaHoraFin = LocalDateTime.now();

        Evento eventoEnLimiteInferior = new Evento();
        eventoEnLimiteInferior.setFechaHora(fechaHoraInicio);

        Evento eventoEnLimiteSuperior = new Evento();
        eventoEnLimiteSuperior.setFechaHora(fechaHoraFin);

        Evento eventoFueraDeLimite = new Evento();
        eventoFueraDeLimite.setFechaHora(fechaHoraFin.plusMinutes(1)); // Fuera del rango

        when(repo.findByTipe(tipoDispositivo)).thenReturn(Arrays.asList(eventoEnLimiteInferior, eventoEnLimiteSuperior, eventoFueraDeLimite));

        List<Evento> resultado = servicio.filtrarPorTipoYFecha(tipoDispositivo, fechaHoraInicio, fechaHoraFin);

        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(eventoEnLimiteInferior));
        assertTrue(resultado.contains(eventoEnLimiteSuperior));
    }

    @Test
    void testFiltrarPorTipoYDispositivoConLimite() {
        String tipoDispositivo = "tipo1";
        int dispositivoId = 1;

        Dispositivo dispositivo = new Dispositivo("Dispositivo 1", "Descripción", true, LocalDate.now());
        dispositivo.setIdDispositivo(dispositivoId); // Configurando el ID

        Evento eventoEnLimite = new Evento();
        eventoEnLimite.setDispositivo(dispositivo);

        Evento eventoFueraDeLimite = new Evento();
        eventoFueraDeLimite.setDispositivo(new Dispositivo("Dispositivo 2", "Descripción", true, LocalDate.now()));

        when(repo.findByTipe(tipoDispositivo)).thenReturn(Arrays.asList(eventoEnLimite, eventoFueraDeLimite));

        List<Evento> resultado = servicio.filtrarPorTipoYDispositivo(tipoDispositivo, dispositivoId);

        assertEquals(1, resultado.size());
        assertSame(eventoEnLimite, resultado.get(0));
    }

    @Test
    void testFiltrarPorTipoYDispositivoYFechaConLimites() {
        String tipoDispositivo = "tipo1";
        int dispositivoId = 1;
        LocalDateTime fechaHoraInicio = LocalDateTime.now().minusDays(1);
        LocalDateTime fechaHoraFin = LocalDateTime.now();

        Dispositivo dispositivo = new Dispositivo("Dispositivo 1", "Descripción", true, LocalDate.now());
        dispositivo.setIdDispositivo(dispositivoId); // Configurando el ID

        Evento eventoDentroDelRango = new Evento();
        eventoDentroDelRango.setDispositivo(dispositivo);
        eventoDentroDelRango.setFechaHora(fechaHoraInicio.plusHours(12)); // Dentro del rango

        Evento eventoFueraDelRango = new Evento();
        eventoFueraDelRango.setDispositivo(dispositivo);
        eventoFueraDelRango.setFechaHora(fechaHoraFin.plusMinutes(1)); // Fuera del rango

        when(repo.findByTipe(tipoDispositivo)).thenReturn(Arrays.asList(eventoDentroDelRango, eventoFueraDelRango));

        List<Evento> resultado = servicio.filtrarPorTipoYDispositivoYFecha(tipoDispositivo, dispositivoId, fechaHoraInicio, fechaHoraFin);

        assertEquals(1, resultado.size());
        assertSame(eventoDentroDelRango, resultado.get(0),"El evento dentro del rango debe ser el esperado");
    }



}
