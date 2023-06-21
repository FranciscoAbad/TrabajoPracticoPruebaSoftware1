package unla.oo2.grupo24.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import unla.oo2.grupo24.entity.Medicion;
import unla.oo2.grupo24.repository.MedicionRepo;
import unla.oo2.grupo24.service.MedicionSensorLuzService;

public class MedicionSensorLuzServiceImp implements MedicionSensorLuzService {

    @Autowired
    MedicionRepo medicionRepo;

    @Override
    public boolean add(Medicion object) {
        medicionRepo.save(object);
        return true;
    }

    @Override
    public List<Medicion> getAll() {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Medicion getById(long id) {
        return (Medicion)medicionRepo.findById(id).orElse(null);
    }

    @Override
    public Medicion modify(Medicion object) {
        return medicionRepo.save(object);
    }

    @Override
    public boolean delete(long id) {
        Medicion aux = getById(id);
        aux.setActivo(false);
        modify(aux);
        return true;
    }
    
}
