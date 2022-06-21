package jpa.manytoany;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="onlineservice_jpa")
public class OnlineService extends Subscription {

	private String website;

	public OnlineService() {
	}
	public OnlineService(String duration, double fees, String website) {
		super(duration, fees);
		this.website = website;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
}
