package example;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Majrul Ansari
 */
public class Item {

	private int id;
	private String name;
	private String description;
	private double initialPrice;
	private double reservePrice;
	private Date validTill;
	private Set categories;
	private Set bids;
	
	public void placeBid(double amount, Member member) {
		Bid bid = new Bid();
		bid.setAmount(amount);
		bid.setItem(this);
		bid.setMember(member);
		getBids().add(bid);
	}
		
	public Set getBids() {
		return bids == null ? new HashSet() : bids;
	}
	public Set getCategories() {
		return categories == null ? new HashSet() : categories;
	}
	public void setBids(Set bids) {
		this.bids = bids;
	}
	public void setCategories(Set categories) {
		this.categories = categories;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public double getInitialPrice() {
		return initialPrice;
	}
	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getReservePrice() {
		return reservePrice;
	}
	public Date getValidTill() {
		return validTill;
	}
	public void setReservePrice(double reservePrice) {
		this.reservePrice = reservePrice;
	}
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public String toString() {
		return "<===Item ID = "+id+", Name = "+name+", Description = "+description+", InitialPrice = "+initialPrice+", ReservePrice = "+reservePrice+", ValidUntil = "+validTill+"===>";
	}
}
