package com.maikon.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikon.os.domain.Tecnico;
import com.maikon.os.dtos.TecnicoDTO;
import com.maikon.os.repositories.TecnicoRepository;
import com.maikon.os.services.exceptions.DataIntegratyViolationException;
import com.maikon.os.services.exceptions.ObjectNotFondException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFondException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tecnico.class.getName()));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}
	
	public Tecnico create(TecnicoDTO objDTO) {
		if(findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		return repository.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));	
	}

	private Tecnico findByCPF(TecnicoDTO objDTO) {
		Tecnico obj = repository.findByCPF(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
	}
}