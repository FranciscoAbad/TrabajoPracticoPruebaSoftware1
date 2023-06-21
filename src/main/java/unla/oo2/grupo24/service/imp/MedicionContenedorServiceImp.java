package unla.oo2.grupo24.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unla.oo2.grupo24.entity.MedicionContenedor;
import unla.oo2.grupo24.service.IMedicionContenedorService;
import unla.oo2.grupo24.repository.MedicionRepo;


import java.util.List;
@Service
public class MedicionContenedorServiceImp implements IMedicionContenedorService {

    @Autowired
    MedicionRepo repo;

    @Override
    public boolean add(MedicionContenedor object) {

        repo.save(object);
        return true;
    }

    @Override
    public List<MedicionContenedor> getAll() {

        return repo.findAllMedicionContenedor();
    }

    @Override
    public MedicionContenedor getById(long id) {
        return (MedicionContenedor) repo.getById(id);
    }

    @Override
    public MedicionContenedor modify(MedicionContenedor object) {
        return repo.save(object);
    }

    @Override
    public boolean delete(long id) {
        repo.deleteById(id);
        return true;
    }
}
