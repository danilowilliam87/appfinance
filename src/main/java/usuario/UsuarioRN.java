package usuario;

import java.util.List;

import util.DAOFactory;

public class UsuarioRN {

	private UsuarioDAO usuarioDAO;
	
	public UsuarioRN() {
		// TODO Auto-generated constructor stub
		this.usuarioDAO = DAOFactory.criarUsuario();
	}
	
	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}
	
	public Usuario buscaPorLogin(String login) {
		return this.usuarioDAO.buscaPorlogin(login);
	}
	
	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		if(codigo == null  || codigo == 0) {
			usuario.getPermissao().add("ROLE_USUARIO");
			this.usuarioDAO.salvar(usuario);
		}else {
			this.usuarioDAO.atualizar(usuario);
		}
	}
	
	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}
	
	public List<Usuario> listar(){
		return this.usuarioDAO.listar();
	}

}
