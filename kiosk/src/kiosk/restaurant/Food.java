package kiosk.restaurant;

public class Food {
	private int num;
	private String name;
	private int price;
	private int amount;
	
	public Food(){
	}
	public Food(int num, String name, int price) {
		this.num = num;
		this.name = name;
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Food [num=" + num + ", name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
}
