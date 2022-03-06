package conta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import testes.CarrinhoDeCompras;
import testes.Item;
import testes.ServicoCarrinho;

public class TesteCarrinhoDeCompras {

	Item item1;
	Item item2;
	Item item3;
	CarrinhoDeCompras carrinho;
	List<Item> lista;
	ServicoCarrinho servico;

	@Before
	public void inicializar() {
		this.item1 = new Item("tomate", "sn", 3.00, 3);
		this.item2 = new Item("frango", "sn", 10.00, 5);
		this.item3 = new Item("cebola", "sn", 2.00, 3);
		this.lista = new ArrayList<Item>();
		this.lista.addAll(Arrays.asList(this.item1, this.item2, this.item3));
		this.carrinho = new CarrinhoDeCompras();
		this.carrinho.setItens(this.lista);
		this.servico = new ServicoCarrinho();
		this.servico.setCarrinhoDeCompras(this.carrinho);
	}

	@Test
	public void testeValorCompra() {
		Assert.assertEquals(65.00, this.servico.calcularTotal(), 0.1);
	}

	@Test
	public void testeRemoverEhCalcular() {
		this.carrinho.getItens().remove(this.item3);
		Assert.assertEquals(59.00, this.servico.calcularTotal(), 0.1);
	}

	@Test
	public void adicionarEhCalcular() {
		Item item4 = new Item("feijao", "sn", 7.00, 10);
		this.servico.getCarrinhoDeCompras().getItens().add(item4);
		Assert.assertEquals(135.00, this.servico.calcularTotal(), 0.1);
	}

	@Test
	public void alterarQuantidadeEhCalcular() {
		this.servico.alterarQuantidade(this.item1, 0);
		Assert.assertEquals(56.00, this.servico.calcularTotal(), 0.1);
	}

}
