package example;
/**
 * @author Majrul Ansari
 */
public class Bid {

	private int id;
	private double amount;
	private Item item;
	private Member member;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public String toString() {
		return "<===Bid ID = "+id+", Bid Value = "+amount+"==>";
	}
}
