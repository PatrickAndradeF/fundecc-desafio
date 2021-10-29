package projeto;

import java.util.List;

public interface PerfilRepositorio {
	public List<Perfil> inserePerfil(List<Perfil> perfis, Perfil perfil);
	public List<Perfil> buscaPerfil();
	public boolean editarPerfil(Perfil perfil, List<Perfil> perfis);
	public Perfil buscaPerfilPorNome(String nome);

}
