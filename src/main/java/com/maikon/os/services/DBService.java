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
		Tecnico t3 = new Tecnico(null, "Alan Turing", "705.339.350-08", "(88) 99999-1020");
		Tecnico t4 = new Tecnico(null, "Richard Stallman", "040.806.200-20", "(88) 99999-9999");
		Tecnico t5 = new Tecnico(null, "Tim Berners-Lee", "686.812.440-60", "(88) 99999-1000");
		Tecnico t6 = new Tecnico(null, "Larry Page", "936.151.940-98", "(88) 99999-7898");
		Cliente c1 = new Cliente(null, "Betina Campos", "171.526.320-06", "(88) 98888-7777");
		Cliente c2 = new Cliente(null, "Gabriel Barros", "476.959.560-31", "(88) 98888-0000");
		Cliente c3 = new Cliente(null, "Leandro Silva", "962.454.830-77", "(88) 98888-1111");
		Cliente c4 = new Cliente(null, "Diego Vasconcelos", "912.466.180-52", "(88) 98888-2222");
		Cliente c5 = new Cliente(null, "Odair Silva", "424.293.100-07", "(88) 98888-3333");
		Cliente c6 = new Cliente(null, "Matheus Rodrigues", "077.893.160-95", "(88) 98888-4444");

		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OD", Status.ANDAMENTO, t1, c1);
		OS os2 = new OS(null, Prioridade.MEDIA, "Teste create OD", Status.ANDAMENTO, t5, c4);
		OS os3 = new OS(null, Prioridade.ALTA, "Teste create OD", Status.ANDAMENTO, t2, c6);
		OS os4 = new OS(null, Prioridade.BAIXA, "Teste create OD", Status.ANDAMENTO, t3, c2);
		OS os5 = new OS(null, Prioridade.MEDIA, "Teste create OD", Status.ANDAMENTO, t4, c1);
		OS os6 = new OS(null, Prioridade.BAIXA, "Teste create OD", Status.ANDAMENTO, t6, c3);

		t1.getList().add(os1);
		c1.getList().add(os1);
		t5.getList().add(os2);
		c4.getList().add(os2);
		t2.getList().add(os3);
		c6.getList().add(os3);
		t3.getList().add(os4);
		c2.getList().add(os4);
		t4.getList().add(os5);
		c1.getList().add(os5);
		t6.getList().add(os6);
		c3.getList().add(os6);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6));
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		osRepository.saveAll(Arrays.asList(os1, os2, os3, os4, os5, os6));
	}

}
