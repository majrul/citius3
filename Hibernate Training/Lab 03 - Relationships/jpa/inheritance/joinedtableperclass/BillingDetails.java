package jpa.inheritance.joinedtableperclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="billing_details_jpa_4")
@Inheritance(strategy=InheritanceType.JOINED)
@GenericGenerator(name="incr", strategy="increment")
public class BillingDetails {

	@Id @GeneratedValue(generator="incr") private int id;
	
	private String owner;
	private String number;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
}
