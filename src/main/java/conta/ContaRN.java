package conta;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import usuario.Usuario;
import util.DAOFactory;

public class ContaRN {
	
	private ContaDAO contaDAO;
	
	public ContaRN() {
		this.contaDAO = DAOFactory.criarContaDAO();
	}
	
	public List<Conta> listar(Usuario usuario){
		return this.contaDAO.listar(usuario);
	}
	
	public Conta carregar(Integer conta) {
		return this.contaDAO.carregar(conta);
	}
	
	public void salvar(Conta conta) {
		conta.setDataCadastro(new Date());
		this.contaDAO.salvar(conta);
	}
	
	public void excluir(Conta conta) {
		this.contaDAO.excluir(conta);
	}
	
	//altera??o de c?digo...no livro est? o if sem o else
	public void tornarFavorita(Conta contaFavorita) {
		Conta conta = this.contaDAO.buscarFavorita(contaFavorita.getUsuario());
		if(conta != null) {
			conta.setFavorita(false);
			this.contaDAO.salvar(conta);
		} 
		contaFavorita.setFavorita(true);
		this.contaDAO.salvar(contaFavorita);
		
	}
	
	public Conta buscarFavorita(Usuario usuario) {
		return this.contaDAO.buscarFavorita(usuario);
	}
	

}
