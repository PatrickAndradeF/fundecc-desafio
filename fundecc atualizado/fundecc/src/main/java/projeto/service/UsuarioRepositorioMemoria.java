package projeto.service;

import org.springframework.stereotype.Service;
import projeto.Cargo;
import projeto.Perfil;
import projeto.Usuario;

import java.time.LocalDate;
import java.util.*;

@Service
public class UsuarioRepositorioMemoria {

	private List<Usuario> usuarios = new ArrayList<>();
	
	private boolean validaNome(String nome){
		if(nome == null) return false;
		if(nome.trim().isEmpty()) return false;
		return true;
	}
	
	private boolean validaUsuario(Usuario usuario, List<Usuario> usuarios){
		String cpf = usuario.getCpf();
		if(cpf.isEmpty()) return false;
		if(cpf.trim().isEmpty()) return false;
		
		for(Usuario i : usuarios){
			if(i.equals(usuario)) return false;
		}
		
		return true;
	}
	
	public List<Usuario> cadastraUsuario(Usuario usuario, List<Usuario> usuarios){
		if(!(validaUsuario(usuario, usuarios))) return usuarios;
		
		usuario.setCadastro(LocalDate.now());
		usuarios.add(usuario);
		return usuarios;
	}
	
	public boolean editarUsuario(String cpf, List<Usuario> usuarios){
		Usuario usuario = new Usuario("Carlinho", "123456", new Cargo("teste"));
		usuario.setCpf(cpf);
		for(Usuario i : usuarios){
			if(i.equals(usuario)){
				
				return true;
			}
		}
		return false;
	}

	public List<Usuario> buscaUsuario() {
		usuarios.sort(null);
		return usuarios;
	}
	
	public Usuario buscaUsuarioPorNome(String nome) {
		Optional<Usuario> usuarioResultado = this.usuarios.stream().filter(usuario -> usuario.getNome().equals(nome)).findFirst();
		return usuarioResultado.orElse(null);
	}
	
}
