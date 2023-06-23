package unla.oo2.grupo24.service.imp;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import unla.oo2.grupo24.entity.Dispositivo;
import unla.oo2.grupo24.entity.SensorEstacionamiento;
import unla.oo2.grupo24.service.IDispositivoService;
import unla.oo2.grupo24.repository.DispositivoRepo;

@Service
public class DispositivoServiceImp implements IDispositivoService {
	@Autowired
	EntityManager entityManager;
	@Autowired
	private DispositivoRepo repo;

	@Override
	public List<Dispositivo> listarTodos() {

		return (List<Dispositivo>) repo.findAll();
	}

	@Override
	public void guardarDispositivo(Dispositivo b) {
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


	public List<Dispositivo> listarPorTipoDispositivo(String tipo) {


		List<Dispositivo> dispositivos = listarTodos();


		List<Dispositivo> nuevaLista = new ArrayList<>();

		if (tipo == "SensorEstacionamiento") {
			for (Dispositivo dispositivo : dispositivos) {
				if (dispositivo instanceof SensorEstacionamiento) {
					System.out.println("------------------------------------------------------>"+dispositivo);
					nuevaLista.add(dispositivo);
					// Realiza las operaciones específicas para un dispositivo de tipo Banio
				}
			}


		}

		return nuevaLista;
	}

}