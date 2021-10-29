package projeto.service;

import projeto.Cargo;
import projeto.CargoRepositorio;

import java.util.List;

public class CargoRepositorioBD implements CargoRepositorio {
	
	
	@Override
	public List<Cargo> insereCargo(List<Cargo> cargos, Cargo cargo) {
		return null;
	}

	@Override
	public List<Cargo> buscaCargo() {
		return null;
	}

	@Override
	public boolean editarCargo(Cargo cargo, List<Cargo> cargos) {
		return false;
	}

	@Override
	public Cargo buscaCargoPorNome(String nome) {
		return null;
	}
}
