package util;

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
}
