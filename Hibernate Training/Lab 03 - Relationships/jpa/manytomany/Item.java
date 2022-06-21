package jpa.manytomany;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {

	private int id;
	private String name;
	private String description;
	private double initialPrice;
	private Double totalBids;
	private Double maxBidAmount;
	private double reservePrice;
	private Date validTill;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="a_categories_items", 
			joinColumns={@JoinColumn(name="item_id")},
			inverseJoinColumns={@JoinColumn(name="cat_id")})
	private Set<Category> categories; //many to many
	
	@OneToMany(mappedBy="item", cascade=CascadeType.ALL)	
	private Set<Bid> bids; //one to many
		
	public Set<Bid> getBids() {
		return bids == null ? new HashSet<Bid>() : bids;
	}
	public Set<Category> getCategories() {
		return categories == null ? new HashSet<Category>() : categories;
	}
	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	public void setCategories(Set<Category> categories) {
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
	public Double getTotalBids() {
		return totalBids;
	}
	public void setTotalBids(Double totalBids) {
		this.totalBids = totalBids;
	}
	public Double getMaxBidAmount() {
		return maxBidAmount;
	}
	public void setMaxBidAmount(Double maxBidAmount) {
		this.maxBidAmount = maxBidAmount;
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

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description="
				+ description + ", initialPrice=" + initialPrice
				+ ", totalBids=" + totalBids + ", maxBidAmount=" + maxBidAmount
				+ ", reservePrice=" + reservePrice + ", validTill=" + validTill
				+ "]";
	}
}
