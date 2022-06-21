package jpa.manytoany;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.MetaValue;

@Entity
@Table(name="customer_jpa")
public class Customer {

	@Id @GeneratedValue private int id;
	private String name;
	
	@ManyToAny(metaColumn=@Column(name = "subscription_type"))
	@AnyMetaDef(idType = "int", metaType = "string",
		metaValues = {
			@MetaValue( value = "M", targetEntity = Magazine.class),
			@MetaValue( value = "I", targetEntity = OnlineService.class)})
	@JoinTable( name = "customer_subscriptions_jpa", 
			joinColumns = @JoinColumn(name = "cust_id"),
			inverseJoinColumns = @JoinColumn( name = "subscription_id"))
	@Cascade(CascadeType.ALL)
	private Set<Subscription> subscriptions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
}
