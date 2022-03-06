package testes;

public class ServicoCarrinho {

	private Item item;
	private CarrinhoDeCompras carrinhoDeCompras;

	public ServicoCarrinho() {
		this.item = new Item();
		this.carrinhoDeCompras = new CarrinhoDeCompras();
	}

	public void addItem(Item item) {
		this.carrinhoDeCompras.getItens().add(item);

	}

	public void removeItem(Item item) {
		this.carrinhoDeCompras.getItens().remove(item);

	}

	public double calcularTotal() {
		double retorno = 0.0;
		for (Item item : this.carrinhoDeCompras.getItens()) {
			retorno += (item.getPreco() * item.getQtdItem());
		}
		return retorno;
	}

	public void alterarQuantidade(Item item, int qtd) {
		if (this.carrinhoDeCompras.getItens().contains(item)) {
			int index = this.carrinhoDeCompras.getItens().indexOf(item);
			this.carrinhoDeCompras.getItens().get(index).setQtdItem(qtd);
		}
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public CarrinhoDeCompras getCarrinhoDeCompras() {
		return this.carrinhoDeCompras;
	}

	public void setCarrinhoDeCompras(CarrinhoDeCompras carrinhoDeCompras) {
		this.carrinhoDeCompras = carrinhoDeCompras;
	}

}
