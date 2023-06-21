package unla.oo2.grupo24.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unla.oo2.grupo24.entity.SensorEstacionamiento;
import unla.oo2.grupo24.repository.DispositivoRepo;
import unla.oo2.grupo24.service.GenericService;

import java.util.List;
@Service
public class EstacionamientoSevicesImp implements GenericService<SensorEstacionamiento> {
    @Autowired
    private DispositivoRepo repo;
    @Override
    public boolean add(SensorEstacionamiento object) {
        repo.save(object);

        return true;
    }

    @Override
    public List<SensorEstacionamiento> getAll() {
       return repo.findAllSensorEstacionamiento();
    }

    @Override
    public SensorEstacionamiento getById(long id) {
        return (SensorEstacionamiento) repo.findById(id).orElse(null);
    }

    @Override
    public SensorEstacionamiento modify(SensorEstacionamiento object) {
        return repo.save(object);
    }

    @Override
    public boolean delete(long id) {
        repo.deleteById(id);
        return true;
    }
}
