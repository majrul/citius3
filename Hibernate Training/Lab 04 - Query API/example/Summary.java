package example;

public class Summary {

	private String name;
	private double amount;
	private int count;

	public Summary() {
	}
	public Summary(String name, double amount, int count) {
		this.name = name;
		this.amount = amount;
		this.count = count;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Name="+name+",Amount="+amount+",Count="+count;
	}
	
}
