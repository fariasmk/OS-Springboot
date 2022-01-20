package com.maikon.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikon.os.domain.Cliente;
import com.maikon.os.domain.OS;
import com.maikon.os.domain.Tecnico;
import com.maikon.os.domain.enums.Prioridade;
import com.maikon.os.domain.enums.Status;
import com.maikon.os.repositories.ClienteRepository;
import com.maikon.os.repositories.OSRepository;
import com.maikon.os.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;
	
	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "Maikon Farias", "409.983.520-04", "(88) 88888-8888");
		Tecnico t2 = new Tecnico(null, "Linus Torvalds", "641.760.040-88", "(88) 94545-4545");
		Cliente c1 = new Cliente(null, "Betina Campos", "171.526.320-06", "(88) 98888-7777");

		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OD", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
