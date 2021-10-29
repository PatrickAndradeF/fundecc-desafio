package projeto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.Perfil;
import projeto.PerfilRepositorio;
import projeto.Usuario;
import projeto.dto.PerfilDto;
import projeto.dto.UsuarioDto;
import projeto.service.PerfilRepositorioDeMemoria;
import projeto.service.UsuarioRepositorioMemoria;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	private UsuarioRepositorioMemoria usuarioRepositorioMemoria;
	PerfilRepositorio perfilRepositorio;
	
	public UsuarioController(UsuarioRepositorioMemoria usuarioRepositorioMemoria, PerfilRepositorio perfilRepositorio){
		this.usuarioRepositorioMemoria = usuarioRepositorioMemoria;
		this.perfilRepositorio = perfilRepositorio;
	}

	@GetMapping
	public List<Usuario> recuperarUsuarios(){
		return  this.usuarioRepositorioMemoria.buscaUsuario();
	}
	
	@PostMapping
	public String inserirCargos(@RequestBody UsuarioDto usuarioDto){
		List<Perfil> perfis = new ArrayList<>();
		List<Usuario> usuarios = this.usuarioRepositorioMemoria.buscaUsuario();
		Usuario usuario = new Usuario(usuarioDto.getNome(), usuarioDto.getCpf(), usuarioDto.getCargo());
		usuario.setSexo(usuarioDto.getSexo());
		usuario.setDataNascimento(usuarioDto.getDataNascimento());
		for(String i : usuarioDto.getPerfil()){
			if(perfilRepositorio.buscaPerfilPorNome(i) != null){
				perfis.add(perfilRepositorio.buscaPerfilPorNome(i));
			}
		}
		usuario.setPerfil(perfis);
		this.usuarioRepositorioMemoria.cadastraUsuario(usuario, usuarios);
		return usuario.getNome() + " Inserido com sucesso";
	}
}
