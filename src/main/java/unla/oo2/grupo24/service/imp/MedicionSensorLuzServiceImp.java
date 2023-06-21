package unla.oo2.grupo24.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import unla.oo2.grupo24.entity.Medicion;
import unla.oo2.grupo24.entity.alumbradointeligente.MedicionSensorLuz;
import unla.oo2.grupo24.repository.MedicionRepo;
import unla.oo2.grupo24.service.MedicionSensorLuzService;

public class MedicionSensorLuzServiceImp implements MedicionSensorLuzService {

    @Autowired
    MedicionRepo medicionRepo;

    @Override
    public boolean add(MedicionSensorLuz object) {
        medicionRepo.save(object);
        return true;
    }

    @Override
    public List<MedicionSensorLuz> getAll() {
        return medicionRepo.findAllMedicionSensorLuz();
    }

    @Override
    public MedicionSensorLuz getById(long id) {
        return (MedicionSensorLuz)medicionRepo.findById(id).orElse(null);
    }

    @Override
    public MedicionSensorLuz modify(MedicionSensorLuz object) {
        return medicionRepo.save(object);
    }

    @Override
    public boolean delete(long id) {
        MedicionSensorLuz aux = getById(id);
        aux.setActivo(false);
        modify(aux);
        return true;
    }
    
}
