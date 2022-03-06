package testes;

import java.util.Objects;

public class Pessoa {

	private String nome;
	private String idade;
	private String email;
	private Float nota;
	private String situacao;
	private String curso;
	private String semestre;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String idade, String email) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.email = email;
	}

	public Pessoa(String nome, String idade, String email, Float nota) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.nota = nota;
	}

	public Pessoa(String nome, String idade, String email, Float nota, String situacao, String curso, String semestre) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.nota = nota;
		this.situacao = situacao;
		this.curso = curso;
		this.semestre = semestre;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return this.idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getNota() {
		return this.nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	public String getSituacao() {
		this.situacao = this.nota >= 5.0 ? "Aprovado" : "Reprovado";
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Pessoa other = (Pessoa) obj;
		return Objects.equals(this.nome, other.nome);
	}

}
