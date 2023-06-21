package unla.oo2.grupo24.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unla.oo2.grupo24.entity.Dispositivo;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.repository.EventoRepo;
import unla.oo2.grupo24.service.EventoService;
import unla.oo2.grupo24.service.GenericService;

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
        return null;
    }

    @Override
    public Evento modify(Evento object) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    public List<Evento> filtrarPorDispositivo(int dispositivoId) {
        // Obtener el dispositivo por su ID utilizando el servicio DispositivoServiceImp
        Dispositivo dispositivo = serviceDispositivo.buscarId(dispositivoId);



        // Obtener todos los eventos asociados con el dispositivo
        List<Evento> eventos = new ArrayList<>();
        for (Evento evento : getAll()) {
            if (evento.getDispositivo().equals(dispositivo)) {
                eventos.add(evento);
            }
        }

        return eventos;
    }
}
