package unla.oo2.grupo24.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unla.oo2.grupo24.entity.MedicionEstacionamiento;
import unla.oo2.grupo24.repository.MedicionRepo;
import unla.oo2.grupo24.service.IMedicionEstacionamientoService;
@Service
public class MedicionEstacionamientoServiceImp implements IMedicionEstacionamientoService {

    @Autowired
    MedicionRepo repo;

    @Override
    public boolean add(MedicionEstacionamiento object) {
        repo.save(object);
        return true;
    }

    @Override
    public List<MedicionEstacionamiento> getAll() {
      return  repo.findAllMedicionEstacionamiento();

    }

    @Override
    public MedicionEstacionamiento getById(long id) {
        return (MedicionEstacionamiento) repo.findById(id).orElse(null);
    }

    @Override
    public MedicionEstacionamiento modify(MedicionEstacionamiento object) {
        return repo.save(object);
    }

    @Override
    public boolean delete(long id) {
        repo.deleteById(id);
        return true;
    }
}
