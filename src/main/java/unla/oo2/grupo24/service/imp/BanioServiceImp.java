package unla.oo2.grupo24.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unla.oo2.grupo24.entity.Banio;
import unla.oo2.grupo24.repository.BanioRepo;
import unla.oo2.grupo24.service.IBanioService;

@Service
public class BanioServiceImp implements IBanioService {
	
	@Autowired
	private BanioRepo repo;
	
	@Override
	public List<Banio> listarTodos() {
		
		return repo.findAll();
	}

	@Override
	public void guardarDispositivo(Banio b) {
		repo.save(b);
		
	}

	@Override
	public Banio buscarId(long id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		repo.deleteById(id);
		
	}

	

}
