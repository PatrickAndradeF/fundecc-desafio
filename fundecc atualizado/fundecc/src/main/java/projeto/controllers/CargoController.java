package projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.Cargo;
import projeto.CargoRepositorio;
import projeto.dto.CargoDto;
import projeto.service.CargoRepositorioDeMemoria;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {
	private CargoRepositorio cargoRepositorio;
	
	@Autowired
	public CargoController(CargoRepositorioDeMemoria cargoRepositorioDeMemoria){
		this.cargoRepositorio = cargoRepositorioDeMemoria;
	}

	@GetMapping
	public List<Cargo> recuperarCargos(){
		return  this.cargoRepositorio.buscaCargo();
	}
	
	@PostMapping
	public String inserirCargos(@RequestBody CargoDto cargoDto){
		List<Cargo> cargos = this.cargoRepositorio.buscaCargo();
		Cargo cargo = new Cargo(cargoDto.getNomeDoCargo());
		this.cargoRepositorio.insereCargo(cargos, cargo);
		return cargo.getNome() + " Inserido com sucesso!"; 
	}
	
}
