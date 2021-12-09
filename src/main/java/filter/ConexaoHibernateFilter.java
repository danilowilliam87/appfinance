package filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

@WebFilter(urlPatterns = {"*.jsf"})
public class ConexaoHibernateFilter implements Filter {
	
	private SessionFactory sf;

	public ConexaoHibernateFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.sf =  HibernateUtil.getSf();
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Session currentSession = this.sf.getCurrentSession();
		Transaction transaction = null;
		
        try {
			transaction = currentSession.beginTransaction();
			chain.doFilter(request, response);
			transaction.commit();
			if(currentSession.isOpen()) {
				currentSession.close();
			}
		} catch (Throwable e) {
			// TODO: handle exception
			try {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			} catch (Throwable t) {
				// TODO: handle exception
				t.printStackTrace();
			}
			throw new ServletException(e);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
