package projeto;

public class Perfil implements Comparable<Perfil> {


	public Perfil(String nome){
		this.nome = nome;
	}
    private String nome;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Perfil)) return false;
        Perfil perfil = (Perfil)obj;

        if(perfil.nome.equals(this.nome)) return true;
        return false;
    }

	@Override
	public int compareTo(Perfil perfil) {
		return this.getNome().compareTo(perfil.getNome());
	}
}
