package unla.oo2.grupo24.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.repository.EventoRepo;
import unla.oo2.grupo24.service.EventoService;
import unla.oo2.grupo24.service.GenericService;

import java.util.List;
@Service

public class EventoServiceImp implements EventoService {

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
}
