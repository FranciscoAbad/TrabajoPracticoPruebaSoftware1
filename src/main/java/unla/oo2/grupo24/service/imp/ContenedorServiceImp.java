package unla.oo2.grupo24.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unla.oo2.grupo24.entity.Contenedor;

import unla.oo2.grupo24.repository.DispositivoRepo;
import unla.oo2.grupo24.service.GenericService;

@Service
public class ContenedorServiceImp implements GenericService<Contenedor> {

    @Autowired
    private DispositivoRepo DispositivoRepo;

    @Override
    public List<Contenedor> getAll() {

        return DispositivoRepo.findAllContenedor();
    }




    @Override
    public boolean add(Contenedor objet) {
        DispositivoRepo.save(objet);
        return true;
    }

    @Override
    public Contenedor getById(long id) {

        return (Contenedor) DispositivoRepo.findById(id).orElse(null);
    }

    @Override
    public boolean delete(long id) {
        DispositivoRepo.deleteById(id);
        return true;
    }

    @Override
    public Contenedor modify(Contenedor object) {
        return DispositivoRepo.save(object);
    }



}