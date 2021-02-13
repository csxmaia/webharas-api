package com.webharas.service;

import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Cavalo;
import com.webharas.model.Venda;
import com.webharas.model.exceptions.CavaloNaoDisponivel;
import com.webharas.model.exceptions.NotFoundException;
import com.webharas.repository.CavaloRepository;
import com.webharas.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private CavaloService cavaloService;
	
	public Venda realizarVenda(Venda venda) throws CavaloNaoDisponivel, NotFoundException {
		Cavalo cavalo = cavaloService.findById(venda.getCavalo_id());
		
		if(cavalo == null) {
			throw new NotFoundException();
		}
		if(cavalo.getVendido() == true) {
			throw new CavaloNaoDisponivel();
		}
		
		Date date = new Date();
		venda.setData(date);
		
		cavalo.setVendido(true);
		cavaloService.update(cavalo.getId(), cavalo);
		
		return vendaRepository.save(venda);
	}
	
	public List<Venda> findAll() {
		return vendaRepository.findAll();
	}
	
	public Venda findById(long id) {
		return vendaRepository.findById(id);
	}
	
	public Venda save(Venda venda) {
		return vendaRepository.save(venda);
	}
	
	public Venda update(long id, Venda venda) {
		venda.setId(id);
		return vendaRepository.save(venda);
	}
	
	public void delete(long id) {
		vendaRepository.deleteById(id);
		return;
	}

}
