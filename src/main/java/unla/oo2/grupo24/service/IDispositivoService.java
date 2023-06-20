package unla.oo2.grupo24.Service;

import java.util.List;

import unla.oo2.grupo24.Entity.Banio;
import unla.oo2.grupo24.Entity.Dispositivo;

public interface IDispositivoService {
	


	public List<Dispositivo> listarTodos();
	
	public void guardarDispositivo(Banio b);
	
	public Dispositivo buscarId(long id);
	
	public void eliminar(long id);


}
