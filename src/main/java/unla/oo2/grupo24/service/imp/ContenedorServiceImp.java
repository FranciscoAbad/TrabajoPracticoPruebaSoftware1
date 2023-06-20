package unla.oo2.grupo24.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unla.oo2.grupo24.entity.Contenedor;
import unla.oo2.grupo24.repository.ContenedorRepo;
import unla.oo2.grupo24.service.IContenedorService;

@Service
public class ContenedorServiceImp implements IContenedorService {

    @Autowired
    private ContenedorRepo repo;

    @Override
    public List<Contenedor> listarTodos() {

        return repo.findAll();
    }

    @Override
    public void guardarDispositivo(Contenedor b) {
        repo.save(b);

    }

    @Override
    public Contenedor buscarId(long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        repo.deleteById(id);

    }



}