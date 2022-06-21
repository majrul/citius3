package jpa.anyone;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

@Entity
@Table(name = "order_jpa")
public class Order {

	@Id
	@GeneratedValue
	private int id;

	private Date orderDate;
	private double amount;

	@Any(metaColumn = @Column(name = "billing_type"))
	@AnyMetaDef(idType = "int", metaType = "string",
			metaValues = {
				@MetaValue(value = "BA", targetEntity = BankAccount.class),
				@MetaValue(value = "CC", targetEntity = CreditCard.class)
			})
	@JoinColumn(name = "billing_id")
	private BillingDetails billingDetails; // polymorphic association

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public BillingDetails getBillingDetails() {
		return billingDetails;
	}

	public void setBillingDetails(BillingDetails billingDetails) {
		this.billingDetails = billingDetails;
	}

}
