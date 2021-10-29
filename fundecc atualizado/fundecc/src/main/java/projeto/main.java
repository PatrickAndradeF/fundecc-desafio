package projeto;

import projeto.service.CargoRepositorioDeMemoria;
import projeto.service.PerfilRepositorioDeMemoria;

import java.util.List;

public class main {
	
    public static void main(String[] args) {
	    CargoRepositorio cargoRepositorio = new CargoRepositorioDeMemoria();
        List<Cargo> cargos = cargoRepositorio.buscaCargo();

	    PerfilRepositorio  perfilRepositorioDeMemoria = new PerfilRepositorioDeMemoria();
	    List<Perfil> perfis =  perfilRepositorioDeMemoria.buscaPerfil();
        
	    Perfil perfil = new Perfil("Administrador");
	    perfis = perfilRepositorioDeMemoria.inserePerfil(perfis, perfil);

	    perfil = new Perfil("Comum");
	    perfis = perfilRepositorioDeMemoria.inserePerfil(perfis, perfil);

	    perfil = new Perfil("Master");
	    perfis = perfilRepositorioDeMemoria.inserePerfil(perfis, perfil);

	    perfil = new Perfil("Desenvolvedor");
	    perfis = perfilRepositorioDeMemoria.inserePerfil(perfis, perfil);
	    
        Cargo cargo = new Cargo("Desenvolvedor Junior");
        cargos = cargoRepositorio.insereCargo(cargos, cargo);
        
        cargo = new Cargo("Desenvolvedor Pleno");
	    cargos = cargoRepositorio.insereCargo(cargos, cargo);
	    
	    cargo = new Cargo("Desenvolvedor Pleno");
	    cargos = cargoRepositorio.insereCargo(cargos, cargo);
	    
	    cargos.sort(null);
	    for(Cargo i : cargos){
		    System.out.print(i.getNome() + " ");
	    }
	    
	    perfis.sort(null);
	    System.out.println();
	    for(Perfil i : perfis){
		    System.out.print(i.getNome()+ " ");
	    }
	    System.out.println();
	   // LocalDate.now();

	    cargoRepositorio.editarCargo(cargo, cargos);
	    for(Cargo i : cargos){
		    System.out.print(i.getNome() + " ");
	    }

	    perfilRepositorioDeMemoria.editarPerfil(perfil, perfis);
	    System.out.println();
	    for(Perfil i : perfis){
		    System.out.print(i.getNome()+ " ");
	    }
	    
    }
    
	
	
}
