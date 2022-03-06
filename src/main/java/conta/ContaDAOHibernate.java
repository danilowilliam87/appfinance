package conta;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import usuario.Usuario;

public class ContaDAOHibernate implements ContaDAO {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void excluir(Conta conta) {
		// TODO Auto-generated method stub
        this.session.delete(conta);
	}

	@Override
	public void salvar(Conta conta) {
		// TODO Auto-generated method stub
        this.session.saveOrUpdate(conta);
	}

	@Override
	public Conta carregar(Integer conta) {
		// TODO Auto-generated method stub
		return (Conta) this.session.get(Conta.class, conta);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conta> listar(Usuario usuario) {
		// TODO Auto-generated method stub
		Criteria criteria = this.session.createCriteria(Conta.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return criteria.list();
	}

	@Override
	public Conta buscarFavorita(Usuario usuario) {
		// TODO Auto-generated method stub
		Criteria criteria = this.session.createCriteria(Conta.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("favorita", true));
		return (Conta) criteria.uniqueResult();
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		this.session.update(conta);
	}

}
