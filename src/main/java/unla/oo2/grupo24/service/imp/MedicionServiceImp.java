package unla.oo2.grupo24.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import unla.oo2.grupo24.entity.Medicion;
import unla.oo2.grupo24.service.IMedicionService;
import unla.oo2.grupo24.repository.MedicionRepo;


import java.util.List;

public class MedicionServiceImp implements IMedicionService {

    @Autowired
    MedicionRepo repo;

    @Override
    public boolean add(Medicion object) {

        repo.save(object);
        return true;
    }

    @Override
    public List<Medicion> getAll() {

        return repo.findAll();
    }

    @Override
    public Medicion getById(long id) {
        return repo.getById(id);
    }

    @Override
    public Medicion modify(Medicion object) {
        return repo.save(object);
    }

    @Override
    public boolean delete(long id) {
        repo.deleteById(id);
        return true;
    }
}
