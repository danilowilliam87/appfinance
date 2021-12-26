package testes;

import java.util.Date;

import conta.Conta;
import conta.ContaRN;
import usuario.Usuario;
import usuario.UsuarioRN;

public class TesteConta {
  
	public static void main(String[] args) {
		UsuarioRN usuarioRN = new UsuarioRN();
		//ContaRN contaRN = new ContaRN();
		Usuario usuario = new Usuario();
		usuario = usuarioRN.buscaPorLogin("dwilliamreis87");
		Conta conta = new Conta();
		conta.setDataCadastro(new Date());
		conta.setDescricao("Santander");
		conta.setSaldoInicial(1000.00F);
		conta.setFavorita(true);
		conta.setUsuario(usuario);
		System.out.println(usuario.getNome());
		//contaRN.salvar(conta);
		
	}
}
