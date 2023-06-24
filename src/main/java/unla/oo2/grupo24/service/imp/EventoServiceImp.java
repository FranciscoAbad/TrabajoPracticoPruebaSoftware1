package unla.oo2.grupo24.service.imp;

import jakarta.persistence.EntityManager;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.repository.EventoRepo;
import unla.oo2.grupo24.service.EventoService;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service

public class EventoServiceImp implements EventoService {
    @Autowired
    DispositivoServiceImp serviceDispositivo;
    @Autowired
    EventoRepo repo;
    @Override
    public boolean add(Evento object) {
        repo.save(object);
       return true;
    }

    @Override
    public List<Evento> getAll() {
        return repo.findAll();
    }

    @Override
    public Evento getById(long id) {
      return repo.findById(id).orElse(null);
    }

    @Override
    public Evento modify(Evento object) {
        return repo.save(object);
    }

    @Override
    public boolean delete(long id) {
        repo.deleteById(id);
        return true;
    }



    public List<Evento> filtrarPorTipo(String tipoDispositivo) {
      //  SE USA ESTA QUERY EN EL REPO "SELECT e.* FROM Evento e JOIN Dispositivo d ON e.id_dispositivo = d.id_dispositivo WHERE d.tipo_dispositivo = :tipoDispositivo";

        return repo.findByTipe(tipoDispositivo);
    }
/* PODRIA HACERLO CON UNA QUERY ASI EN EL REPO
    public List<Evento> filtrarPorTipoYDispositivo(String tipoDispositivo, int dispositivoId) {
        String sqlQuery = "SELECT e.* FROM Evento e JOIN Dispositivo d ON e.id_dispositivo = d.id_dispositivo WHERE d.tipo_dispositivo = :tipoDispositivo AND d.id_dispositivo = :dispositivoId";
        NativeQuery<Evento> query = (org.hibernate.query.NativeQuery<Evento>) entityManager.createNativeQuery(sqlQuery, Evento.class);
        query.setParameter("tipoDispositivo", tipoDispositivo);
        query.setParameter("dispositivoId", dispositivoId);

        return query.getResultList();
    }*/

    public List<Evento> filtrarPorTipoYDispositivo(String tipoDispositivo, int dispositivoId) {
        List<Evento> eventosFiltradosPorTipo = filtrarPorTipo(tipoDispositivo);
        List<Evento> eventosFiltradosPorTipoYDispositivo = new ArrayList<>();

        for (Evento evento : eventosFiltradosPorTipo) {
            if (evento.getDispositivo().getIdDispositivo() == dispositivoId) {
                eventosFiltradosPorTipoYDispositivo.add(evento);
            }
        }

        return eventosFiltradosPorTipoYDispositivo;
    }
/* ESTA PORDIRA SER LA QUERY SI ESTUVIERA EN EL REPO PARA FILTRAR POR FECHA, TIPO Y DISPOSITIVO, NOTESE QUE TODAS ESTAS CONSULTAS SON SQL Y NO HQL, YA QUE NO TENGO EL DATO TIPO_DISPOSITIVO EN LA CLASE, SOLO LO TENGO EN BD
"SELECT e.* FROM Evento e " +
                      "JOIN Dispositivo d ON e.id_dispositivo = d.id_dispositivo " +
                      "WHERE d.tipo_dispositivo = :tipoDispositivo " +
                      "AND d.id_dispositivo = :dispositivoId " +
                      "AND e.fecha_hora >= :fechaHoraInicio " +
                      "AND e.fecha_hora <= :fechaHoraFin";
 */
    public List<Evento> filtrarPorTipoYDispositivoYFecha(String tipoDispositivo, int dispositivoId, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        List<Evento> eventosFiltrados = filtrarPorTipoYDispositivo(tipoDispositivo, dispositivoId);

        // Filtrar por fechas
        List<Evento> eventosFiltradosPorFecha = new ArrayList<>();

        for (Evento evento : eventosFiltrados) {
            LocalDateTime fechaHoraEvento = evento.getFechaHora();

            if (fechaHoraEvento.isAfter(fechaHoraInicio) && fechaHoraEvento.isBefore(fechaHoraFin)) {
                eventosFiltradosPorFecha.add(evento);
            }
        }

        return eventosFiltradosPorFecha;
    }
    public List<Evento> filtrarPorTipoYFecha(String tipoDispositivo, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        List<Evento> eventosFiltrados = filtrarPorTipo(tipoDispositivo);

        // Filtrar por fechas
        List<Evento> eventosFiltradosPorFecha = new ArrayList<>();

        for (Evento evento : eventosFiltrados) {
            LocalDateTime fechaHoraEvento = evento.getFechaHora();

            if (fechaHoraEvento.isAfter(fechaHoraInicio) && fechaHoraEvento.isBefore(fechaHoraFin)) {
                eventosFiltradosPorFecha.add(evento);
            }
        }

        return eventosFiltradosPorFecha;
    }




}
