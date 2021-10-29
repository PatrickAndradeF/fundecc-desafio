package projeto;

import java.time.LocalDate;

public abstract class Pessoa {
	
	public Pessoa(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
		
	}
	
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Sexo sexo;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }


    public Sexo getSexo() {
        return sexo;
    }

    public String getCpf() {
        return cpf;
    }
}
