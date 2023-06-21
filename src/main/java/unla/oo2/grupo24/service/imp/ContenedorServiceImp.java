package unla.oo2.grupo24.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unla.oo2.grupo24.entity.Contenedor;
import unla.oo2.grupo24.repository.ContenedorRepo;
import unla.oo2.grupo24.service.GenericService;

@Service
public class ContenedorServiceImp implements GenericService<Contenedor> {

    @Autowired
    private ContenedorRepo contenedorRepo;

    @Override
    public List<Contenedor> getAll() {

        return contenedorRepo.findAll();
    }




    @Override
    public boolean add(Contenedor objet) {
        contenedorRepo.save(objet);
        return true;
    }

    @Override
    public Contenedor getById(long id) {

        return contenedorRepo.findById(id).orElse(null);
    }

    @Override
    public boolean delete(long id) {
        contenedorRepo.deleteById(id);
        return true;
    }

    @Override
    public Contenedor modify(Contenedor object) {
        return contenedorRepo.save(object);
    }



}