package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date date;
	private OrderStatus status;
	private Client client;

	private List<Items> items = new ArrayList<>();

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private SimpleDateFormat sdf2= new SimpleDateFormat("dd/MM/yyyy");
	
	public Order() {
	}

	public Order(Date date, OrderStatus status, Client client) {
		this.date = date;
		this.status = status;
		this.client = client;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem(Items item) {
		items.add(item);
	}

	public void removeItem(Items item) {
		items.remove(item);
	}

	public Double total() {
		double total = 0;

		for (Items i : items) {
			total += i.subTotal();
		}

		return total;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(date));
		sb.append("\nOrder status: " + status);
		sb.append("\nClient: " 
		+ client.getName() 
		+ " ("+ sdf2.format(client.getBirthDate())+ ") " 
		+ client.getEmail());
		
		for (Items i : items) {
			sb.append("\n"+i.getName());
			
			sb.append(String.format(", $%.2f", i.getPrice()) + 
					", Quantity: " + i.getQuantity());
			
			sb.append(String.format(", Subtotal: $%.2f", i.subTotal()));
		}
		
		String total = String.format("\nTotal price: $%.2f", total());
		sb.append(total);
	
		return  sb.toString();
	}

}
