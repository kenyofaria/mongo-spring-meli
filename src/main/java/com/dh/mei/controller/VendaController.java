package com.dh.mei.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dh.mei.dto.AnuncioDto;
import com.dh.mei.dto.VendaDto;
import com.dh.mei.form.ItemVendaPayload;
import com.dh.mei.model.Venda;
import com.dh.mei.repository.AnuncioRepository;
import com.dh.mei.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private AnuncioRepository anuncioRepository;
	
	@PostMapping("/{data}")
	public void cadastra(@RequestBody List<ItemVendaPayload> payLoad, @PathVariable String data) {
		
		Venda venda = new Venda(LocalDate.parse(data));
		payLoad.forEach(item -> venda.addAnuncio(item.converteToModel(anuncioRepository), item.getQuantidade()));
		vendaService.realizaVenda(venda);
	}
	@GetMapping("/{dataInicial}/{dataFinal}")
	public List<VendaDto> listagem(@PathVariable String dataInicial, @PathVariable String dataFinal){
		LocalDate inicio = LocalDate.parse(dataInicial);
		LocalDate fim = LocalDate.parse(dataFinal);
		List<Venda> listagem = vendaService.listagem(inicio, fim);
		List<VendaDto> listagemDto = new ArrayList<>();
		
		listagem.forEach(item ->{
			listagemDto.add(new VendaDto(item.getDataVenda(), AnuncioDto.converter(item.getAnuncios())));
		});
		
		return listagemDto;
	}
	@GetMapping("/list")
	public List<VendaDto> listagem(@RequestParam int pagina, @RequestParam int quantidade){
		Pageable pageable = PageRequest.of(pagina, quantidade, Direction.ASC, "dataVenda");
		Page<Venda> listagem = vendaService.listagem(pageable);
		List<VendaDto> listagemDto = new ArrayList<>();
		
		listagem.forEach(item ->{
			listagemDto.add(new VendaDto(item.getDataVenda(), AnuncioDto.converter(item.getAnuncios())));
		});
		return listagemDto;
	}
}
