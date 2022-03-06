package util;

import conta.ContaDAO;
import conta.ContaDAOHibernate;
import usuario.UsuarioDAO;
import usuario.UsuarioDAOHibernate;

public class DAOFactory {
	

	public DAOFactory() {
		// TODO Auto-generated constructor stub
	}

	public static UsuarioDAO criarUsuario() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSf().getCurrentSession());
		return usuarioDAO;
	}
	
	public static ContaDAO criarContaDAO() {
		ContaDAOHibernate contaDAO = new ContaDAOHibernate();
		contaDAO.setSession(HibernateUtil.getSf().getCurrentSession());
		return contaDAO;
	}
}
