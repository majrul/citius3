
package hibernate.component;

import java.util.Map;

public class User {

	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;

	private Address billingAddress;
	private Address shippingAddress;
	
	private Map<String, String> userAttributes;
	
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setUserAttributes(Map<String, String> userAttributes) {
		this.userAttributes = userAttributes;
	}
	public Map<String, String> getUserAttributes() {
		return userAttributes;
	}
}
