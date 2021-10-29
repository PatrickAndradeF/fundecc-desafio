package projeto.service;

import org.springframework.stereotype.Service;
import projeto.Cargo;
import projeto.CargoRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CargoRepositorioDeMemoria implements CargoRepositorio {
	
	private List<Cargo> cargos = new ArrayList<>();
	
	public List<Cargo> insereCargo(List<Cargo> cargos, Cargo cargo){
		if(cargo == null) return cargos;
		boolean insere =  true;
		String nomeCargo = cargo.getNome();
		if(nomeCargo.isEmpty() || nomeCargo.trim().isEmpty()) return cargos;
		if(cargos.isEmpty()) cargos.add(cargo);
		else{
			for(Cargo i : cargos){
				if(i.equals(cargo)){
					insere = false;
					break;
				}
			}
			if(insere) cargos.add(cargo);
		}
		return cargos;
	}

	@Override
	public List<Cargo> buscaCargo() {
		return cargos;
	}

	@Override
	public boolean editarCargo(Cargo cargo, List<Cargo> cargos) {
		if(cargos.isEmpty()) return false;
		else {
			for(Cargo i : cargos){
				if(i.equals(cargo)){
					System.out.println("Digite o novo nome do cargo");
					Scanner leitor = new Scanner(System.in);
					i.setNome(leitor.nextLine());
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Cargo buscaCargoPorNome(String nome) {
		Optional<Cargo> cargoResultado = this.cargos.stream().filter(cargo -> cargo.getNome().equals(nome)).findFirst();
		return cargoResultado.orElse(null);
	}

}
