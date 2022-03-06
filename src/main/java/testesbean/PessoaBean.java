package testesbean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import testes.Pessoa;

@ManagedBean(name = "pessoaBean")
@ApplicationScoped
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas = new ArrayList<>();
	private boolean renderiza = false;
	private List<String> cursos = new ArrayList<String>(
			Arrays.asList("Analise de Sistemas", "Sistemas de Informacao", "Banco de dados",
					"Engenharia de Software", "Analise de Processos", "Seguran�a da Informa��o"));

	private List<String> semestres = new ArrayList<>(Arrays.asList("1 semestre", "2 semestre",
			"3 semestre", "4 semestre", "5 semestre", "6 semestre", "7 semestre", "8 semestre"));

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String addPessoa() {
		if (!this.pessoas.contains(this.pessoa)) {
			this.pessoas.add(this.pessoa);
			this.pessoa = new Pessoa();
		}
		return null;
	}

	public String removePessoa() {
		if (this.pessoas.contains(this.pessoa)) {
			this.pessoas.remove(this.pessoa);
		}
		this.pessoa = new Pessoa();
		return null;
	}

	public String updatePessoa() {
		if (this.pessoas.contains(this.pessoa)) {
			int index = this.pessoas.indexOf(this.pessoa);
			this.pessoas.remove(this.pessoa);
			this.pessoas.add(index, this.pessoa);
		}
		return null;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public int qtdRegistros() {
		return this.pessoas.size();
	}

	public boolean isRenderiza() {
		this.renderiza = this.pessoas.size() > 0;
		return this.renderiza;
	}

	public void setRenderiza(boolean renderiza) {
		this.renderiza = renderiza;
	}

	public List<String> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}

	public List<String> getSemestres() {
		return this.semestres;
	}

	public void setSemestres(List<String> semestres) {
		this.semestres = semestres;
	}

}
