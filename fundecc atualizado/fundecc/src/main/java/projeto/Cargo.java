package projeto;

public class Cargo implements  Comparable<Cargo>{

	public Cargo(String nome) {
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
        if(!(obj instanceof Cargo)) return false;
        Cargo cargo = (Cargo)obj;

        if(cargo.nome.equals(this.nome)) return true;
        return false;
    }

	@Override
	public int compareTo(Cargo cargo) {
		return this.nome.compareTo(cargo.nome);
	}
}
