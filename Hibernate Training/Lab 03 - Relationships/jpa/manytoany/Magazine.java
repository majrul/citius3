package jpa.manytoany;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="magazines_jpa")
public class Magazine extends Subscription {

	private String name;
	private String type;

	public Magazine() {
	}

	public Magazine(String duration, double fees, String name, String type) {
		super(duration, fees);
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
