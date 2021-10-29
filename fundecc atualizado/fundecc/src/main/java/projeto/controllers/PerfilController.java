package projeto.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.Cargo;
import projeto.Perfil;
import projeto.PerfilRepositorio;
import projeto.dto.CargoDto;
import projeto.dto.PerfilDto;
import projeto.service.PerfilRepositorioDeMemoria;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

	private PerfilRepositorio perfilRepositorio;
	
	@Autowired
	public  PerfilController(PerfilRepositorioDeMemoria perfilRepositorioDeMemoria){
		this.perfilRepositorio = perfilRepositorioDeMemoria;
	}
	
	@GetMapping
	public List<Perfil> recuperarCargos(){
		return  this.perfilRepositorio.buscaPerfil();
	}

	@PostMapping
	public String inserirCargos(@RequestBody PerfilDto perfilDto){
		List<Perfil> perfis = this.perfilRepositorio.buscaPerfil();
		Perfil perfil = new Perfil(perfilDto.getNomeDoPerfil());
		this.perfilRepositorio.inserePerfil(perfis, perfil);
		return perfil.getNome() + " Inserido com sucesso!";
	}
	
}
