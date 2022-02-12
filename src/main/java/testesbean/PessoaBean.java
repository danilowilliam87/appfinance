package testesbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import testes.Pessoa;

@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas = new ArrayList<>();

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String addPessoa() {
		this.pessoas.add(this.pessoa);
		this.pessoa = new Pessoa();
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

}
