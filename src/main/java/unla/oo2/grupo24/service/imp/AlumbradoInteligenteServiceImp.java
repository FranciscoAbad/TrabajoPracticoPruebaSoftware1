package unla.oo2.grupo24.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unla.oo2.grupo24.entity.alumbradointeligente.AlumbradoInteligente;
import unla.oo2.grupo24.repository.DispositivoRepo;
import unla.oo2.grupo24.service.AlumbradoInteligenteService;

@Service
public class AlumbradoInteligenteServiceImp implements AlumbradoInteligenteService {

    @Autowired
    DispositivoRepo dispositivoRepo;

    @Override
    public boolean add(AlumbradoInteligente object) {
        dispositivoRepo.save(object);
        return true;
    }

    @Override
    public List<AlumbradoInteligente> getAll() {
        return dispositivoRepo.findAllAlumbradoInteligente();
    }

    @Override
    public AlumbradoInteligente getById(long id) {
        return (AlumbradoInteligente)dispositivoRepo.findById(id).orElse(null);
    }

    @Override
    public AlumbradoInteligente modify(AlumbradoInteligente sensorLuzInteligente) {
        return dispositivoRepo.save(sensorLuzInteligente);
    }

    @Override
    public boolean delete(long id) {
        AlumbradoInteligente aux = getById(id);
        aux.setActivo(false);
        modify(aux);
        return true;
    }
}
