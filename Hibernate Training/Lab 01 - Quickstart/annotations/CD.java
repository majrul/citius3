package annotations;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CD")
@GenericGenerator(name="incr", strategy="increment")
public class CD {

	@Id
	@GeneratedValue(generator="incr")
	private int id;

	private String title;
	private String artist;

	@Temporal(TemporalType.DATE)
	@Column(name="purchase_date")
	private Date purchaseDate;

	private double cost;

	public CD(String title, String artist, Date purchaseDate, double cost) {
		this.title = title;
		this.artist = artist;
		this.purchaseDate = purchaseDate;
		this.cost = cost;
	}

	public CD() {
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
