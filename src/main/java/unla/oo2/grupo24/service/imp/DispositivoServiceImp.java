package unla.oo2.grupo24.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unla.oo2.grupo24.entity.Banio;
import unla.oo2.grupo24.entity.Dispositivo;
import unla.oo2.grupo24.service.IDispositivoService;
import unla.oo2.grupo24.repository.DispositivoRepo;

@Service
public class DispositivoServiceImp implements IDispositivoService {
	
	@Autowired
	private DispositivoRepo repo;
	
	@Override
	public List<Dispositivo> listarTodos() {
		
		return (List<Dispositivo>) repo.findAll();
	}

	@Override
	public void guardarDispositivo(Banio b) {
		repo.save(b);
	}

	@Override
	public Dispositivo buscarId(long id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
	repo.deleteById(id);
	}
	

}
