package unla.oo2.grupo24.service.imp;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import unla.oo2.grupo24.entity.Banio;
import unla.oo2.grupo24.entity.MedicionBanio;
import unla.oo2.grupo24.repository.DispositivoRepo;
import unla.oo2.grupo24.repository.IMedicionBanio;
import unla.oo2.grupo24.service.GenericService;
import unla.oo2.grupo24.service.IMedicionBanioService;

@Service
public class MedicionBanioImp  implements IMedicionBanioService {

	@Autowired
	IMedicionBanio repo;
	
	@Override
	public boolean add(MedicionBanio object) {
		repo.save(object);
		return true;
	}

	@Override
	public List<MedicionBanio> getAll() {
	
		return repo.findAllMedicionBanio();
	}

	@Override
	public MedicionBanio getById(long id) {
		
		return (MedicionBanio) repo.findById(id).orElse(null);
	}

	@Override
	public MedicionBanio modify(MedicionBanio object) {
		
		return null;
	}

	@Override
	public boolean delete(long id) {
		
		return false;
	}
	
	

}
