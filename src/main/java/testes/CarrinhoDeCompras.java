package testes;

import java.util.List;
import java.util.Objects;

public class CarrinhoDeCompras {

	private List<Item> itens;
	private Double total;

	public CarrinhoDeCompras() {
		super();
	}

	public CarrinhoDeCompras(List<Item> itens, Double total) {
		super();
		this.itens = itens;
		this.total = total;
	}

	public List<Item> getItens() {
		return this.itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.itens, this.total);
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
		CarrinhoDeCompras other = (CarrinhoDeCompras) obj;
		return Objects.equals(this.itens, other.itens) && Objects.equals(this.total, other.total);
	}

}
