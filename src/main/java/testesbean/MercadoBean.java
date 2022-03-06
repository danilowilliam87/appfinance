package testesbean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

import testes.Item;
import testes.ServicoCarrinho;

@ManagedBean(name = "mercadoBean")
@ApplicationScoped
public class MercadoBean {

	private List<Item> listaDeItens = new ArrayList<Item>(Arrays.asList(new Item("tomate", "sn", 3.00),
			new Item("melao", "sn", 15.00), new Item("manga", "marca3", 2.00), new Item("melancia", "marca3", 4.00),
			new Item("abacaxi", "marca3", 7.00), new Item("pera", "sn", 12.00), new Item("pimentao", "marca2", 9.00),
			new Item("morango", "marca2", 13.00), new Item("abacate", "marca2", 10.00), new Item("uva", "sn", 2.00)));

	private List<Integer> quantidades = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));

	private List<String> rotulos = new ArrayList<String>(Arrays.asList(new String[] { "escolha uma opcao", "melao",
			"abacaxi", "morango", "manga", "pera", "abacate", "tomate", "melancia", "pimentao", "uva" }));

	private List<String> marcas = new ArrayList<String>(
			Arrays.asList(new String[] { "escolha uma opcao", "sn", "marca2", "marca3" }));

	private Item item = new Item();
	private List<Item> listaParaCarrinho = new ArrayList<>();
	private ServicoCarrinho servicoCarrinho = new ServicoCarrinho();
	private Double preco = 0.0;

	private boolean desabilitar = true;
	private boolean desabilitarComboQuantidade = true;

	public String addItem() {
		this.listaParaCarrinho.add(this.item);
		this.item = new Item();
		return null;
	}

	public String removeItem() {
		this.listaParaCarrinho.remove(this.item);
		return null;
	}

	public String calcularTotal() {
		this.servicoCarrinho.getCarrinhoDeCompras().getItens().addAll(this.listaParaCarrinho);
		this.servicoCarrinho.calcularTotal();
		return null;
	}

	public String alterarQuantidade() {
		this.servicoCarrinho.getCarrinhoDeCompras().getItens().addAll(this.listaParaCarrinho);
		this.servicoCarrinho.alterarQuantidade(this.item, this.item.getQtdItem());
		return null;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public ServicoCarrinho getServicoCarrinho() {
		return this.servicoCarrinho;
	}

	public void setServicoCarrinho(ServicoCarrinho servicoCarrinho) {
		this.servicoCarrinho = servicoCarrinho;
	}

	public List<Item> getListaDeItens() {
		return this.listaDeItens;
	}

	public void setListaDeItens(List<Item> listaDeItens) {
		this.listaDeItens = listaDeItens;
	}

	public List<Integer> getQuantidades() {
		return this.quantidades;
	}

	public void setQuantidades(List<Integer> quantidades) {
		this.quantidades = quantidades;
	}

	public List<String> getRotulos() {
		return this.rotulos;
	}

	public void setRotulos(List<String> rotulos) {
		this.rotulos = rotulos;
	}

	public List<String> getMarcas() {
		return this.marcas;
	}

	public void setMarcas(List<String> marcas) {
		this.marcas = marcas;
	}

	public List<Item> getListaParaCarrinho() {
		return this.listaParaCarrinho;
	}

	public void setListaParaCarrinho(List<Item> listaParaCarrinho) {
		this.listaParaCarrinho = listaParaCarrinho;
	}

	public boolean isDesabilitar() {
		return this.desabilitar;
	}

	public void setDesabilitar(boolean desabilitar) {
		this.desabilitar = desabilitar;
	}

	public Double getPreco() {
		for (Item item : this.listaDeItens) {
			if (this.item.getNome().equals(item.getNome()) && this.item.getMarca().equals(item.getMarca())) {
				this.preco = item.getPreco();
			}
		}
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setarPreco() {
		for (Item item : this.listaDeItens) {
			if (this.item.getNome().equals(item.getNome()) && this.item.getMarca().equals(item.getMarca())) {
				this.item.setPreco(item.getPreco());
			}
		}

	}

	public boolean isDesabilitarComboQuantidade() {
		return this.desabilitarComboQuantidade;
	}

	public void setDesabilitarComboQuantidade(boolean desabilitarComboQuantidade) {
		this.desabilitarComboQuantidade = desabilitarComboQuantidade;
	}

	public void acaoAlterarValorNome(ValueChangeEvent event) {
		this.item.setNome(event.getNewValue().toString());
		System.out.println("Source" + event.getSource());
		System.out.println("Class" + event.getClass());
	}

	public void acaoAlterarValorMarca(ValueChangeEvent event) {
		this.item.setMarca(event.getNewValue().toString());
		if (!this.listaDeItens.contains(this.item)) {
			setDesabilitarComboQuantidade(true);
			getItem().setPreco(0.0);
		} else {
			setDesabilitarComboQuantidade(false);
			setarPreco();
		}
	}

	public void acaoAlterarQuantidade(ValueChangeEvent event) {
		int valor = Integer.parseInt(event.getNewValue().toString());
		if (valor > 0) {
			setDesabilitar(false);
		} else {
			setDesabilitar(true);
		}
	}

}
