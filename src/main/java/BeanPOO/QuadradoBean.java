package BeanPOO;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import POO.Quadrado;


@ManagedBean(name = "quadradoBean")
@RequestScoped
public class QuadradoBean {

	private Quadrado quadrado = new Quadrado();
	private double lado = 0;
	private boolean renderiza = false;
	private String saida = "";
	
	public Quadrado getQuadrado() {
		return quadrado;
	}
	public void setQuadrado(Quadrado quadrado) {
		this.quadrado = quadrado;
	}
	public double getLado() {
		return lado;
	}
	public void setLado(double lado) {
		this.lado = lado;
	}
	public boolean isRenderiza() {
		return renderiza;
	}
	public void setRenderiza(boolean renderiza) {
		this.renderiza = renderiza;
	}
	

	public String getSaida() {
		return saida;
	}
	public void setSaida(String saida) {
		this.saida = saida;
	}

	public void load(){
		this.lado = 0.0;
	}
	
	public String calcularArea() {
		double res = this.quadrado.area(this.lado);
		this.saida = String.valueOf(res);
		//load();
		return null;
	}
	
}
