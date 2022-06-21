package hibernate.manytoany;

public class Subscription {

	private int id;
	private String duration; //monthly, quarterly, yearly
	private double fees;

	public Subscription() {
	}

	public Subscription(String duration, double fees) {
		super();
		this.duration = duration;
		this.fees = fees;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
}
