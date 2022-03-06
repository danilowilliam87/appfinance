package testes;

import java.util.Objects;

public class Item {

	private String nome;
	private String marca;
	private Double preco;
	private int qtdItem;

	public Item() {
		super();
	}

	public Item(String nome, String marca, Double preco) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
	}

	public Item(String nome, String marca, Double preco, int qtdItem) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.qtdItem = qtdItem;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getQtdItem() {
		return this.qtdItem;
	}

	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.marca, this.nome);
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
		Item other = (Item) obj;
		return Objects.equals(this.marca, other.marca) && Objects.equals(this.nome, other.nome);
	}

}
