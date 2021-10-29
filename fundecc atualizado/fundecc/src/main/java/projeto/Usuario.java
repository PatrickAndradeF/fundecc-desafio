package projeto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Usuario extends Pessoa {
	
	public Usuario(String nome, String cpf, Cargo cargo){
		super(nome, cpf);
		this.cargo  = cargo;
	}
	
    private Cargo cargo;
    private List<Perfil> perfil;
    private LocalDate cadastro;
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

	public void setPerfil(List<Perfil> perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getPerfil() {
		return perfil;
	}

	public Cargo getCargo() {
        return cargo;
    }

	public void setCadastro(LocalDate cadastro) {
		this.cadastro = cadastro;
	}

	public LocalDate getCadastro() {
		return cadastro;
	}

	public boolean equals(Object obj){
		if(!(obj instanceof Usuario)) return false;
		Usuario usuario = (Usuario)obj;

		if(usuario.getCpf().equals(getCpf()))  return true;

		return false;
	}
}
