package projeto;

import java.util.List;

public interface CargoRepositorio {
	public List<Cargo> insereCargo(List<Cargo> cargos, Cargo cargo);
	public List<Cargo> buscaCargo();
	public boolean editarCargo(Cargo cargo, List<Cargo> cargos);
	public Cargo buscaCargoPorNome(String nome);
}
