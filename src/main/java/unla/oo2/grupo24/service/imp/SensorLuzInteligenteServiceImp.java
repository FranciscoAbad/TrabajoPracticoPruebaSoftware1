package unla.oo2.grupo24.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unla.oo2.grupo24.entity.SensorLuzInteligente;
import unla.oo2.grupo24.repository.SensorLuzInteligenteRepository;
import unla.oo2.grupo24.service.SensorLuzInteligenteService;

@Service
public class SensorLuzInteligenteServiceImp implements SensorLuzInteligenteService {

    @Autowired
    SensorLuzInteligenteRepository sensorLuzInteligenteRepository;

    @Override
    public boolean add(SensorLuzInteligente object) {
        sensorLuzInteligenteRepository.save(object);
        return true;
    }

    @Override
    public List<SensorLuzInteligente> getAll() {
        return sensorLuzInteligenteRepository.findAll();
    }

    @Override
    public SensorLuzInteligente getById(long id) {
        return sensorLuzInteligenteRepository.findById(id).orElse(null);
    }

    @Override
    public SensorLuzInteligente modify(SensorLuzInteligente sensorLuzInteligente) {
        return sensorLuzInteligenteRepository.save(sensorLuzInteligente);
    }

    @Override
    public boolean delete(long id) {
        SensorLuzInteligente aux = getById(id);
        aux.setActivo(false);
        modify(aux);
        return true;
    }

}
