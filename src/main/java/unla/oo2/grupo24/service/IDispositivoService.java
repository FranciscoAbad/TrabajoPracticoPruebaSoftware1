package unla.oo2.grupo24.service;

import java.util.List;

import unla.oo2.grupo24.entity.Banio;
import unla.oo2.grupo24.entity.Dispositivo;

public interface IDispositivoService {
	
	public List<Dispositivo> listarTodos();
	
	public void guardarDispositivo(Dispositivo b);
	
	public Dispositivo buscarId(long id);
	
	public void eliminar(long id);


}
