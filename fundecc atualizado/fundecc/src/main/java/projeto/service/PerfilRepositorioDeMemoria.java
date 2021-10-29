package projeto.service;


import org.springframework.stereotype.Service;
import projeto.Cargo;
import projeto.Perfil;
import projeto.PerfilRepositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@Service
public class PerfilRepositorioDeMemoria implements PerfilRepositorio {
	
	private List<Perfil> perfis = new ArrayList<>();
	
	@Override
	public List<Perfil> inserePerfil(List<Perfil> perfis, Perfil perfil) {
		if(perfil == null) return perfis;
		
		boolean insere =  true;
		
		if(!validaNome(perfil.getNome())) {
			System.out.println("Nome inv�lido");
			return perfis;
		}
		
		if(perfis.isEmpty()) perfis.add(perfil);
		else{
			for(Perfil i : perfis){
				if(i.equals(perfil)){
					insere = false;
					break;
				}
			}
			if(insere) perfis.add(perfil);
		}
		return perfis;
	}

	private boolean validaNome(String nome){
		if(nome == null) return false;
		if(nome.trim().isEmpty()) return false;
		return true;
	}

	@Override
	public List<Perfil> buscaPerfil() {
		perfis.sort(null);
		return perfis;
	}

	@Override
	public boolean editarPerfil(Perfil perfil, List<Perfil> perfis) {
		if(perfis.isEmpty()) return false;
		else {
			for(Perfil i : perfis){
				if(i.equals(perfil)){
					System.out.println("Digite o novo nome do perfil");
					Scanner leitor = new Scanner(System.in);
					i.setNome(leitor.nextLine());
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Perfil buscaPerfilPorNome(String nome) {
		Optional<Perfil> perfilResultado = this.perfis.stream().filter(perfil -> perfil.getNome().equals(nome)).findFirst();
		return perfilResultado.orElse(null);
	}
}
