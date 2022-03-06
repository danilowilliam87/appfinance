package testes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "user") // or @Named("user")
@ViewScoped
public class User {

	private String name = "";
	private String password;

	public String getName() {
		return this.name;
	}

	public void setName(String newValue) {
		this.name = newValue;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String newValue) {
		this.password = newValue;
	}

	public void getGreeting() {
		System.out.print("invocacao do metodo");
	}
}
