package example;

import java.util.Date;

/**
 * @author Majrul Ansari
 */
public class OldItem {

	private int id;
	private String name;
	private Date expiredOn;
	
	public Date getExpiredOn() {
		return expiredOn;
	}
	public void setExpiredOn(Date expiredOn) {
		this.expiredOn = expiredOn;
	}
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

	
}