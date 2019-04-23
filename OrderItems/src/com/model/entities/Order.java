package com.model.entities;

import java.awt.ItemSelectable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.enums.OrderStatus;

public class Order {

	private static double sum;

	private static SimpleDateFormat sdfmoment = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdfbirthdate = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	private Client client;

	public Order() {
		super();
	}

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.setMoment(moment);
		this.setStatus(status);
		this.setClient(client);
	}

	public Date getMoment() {
		return moment;
	}

	private void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	private void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	private void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Client getClient() {
		return client;
	}

	private void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {

		this.items.add(item);
	}

	public void removeItem(OrderItem item) {

		this.items.remove(item);
	}

	public Double total() {

		for (OrderItem odit : items) {

			sum += odit.subTotal();
		}

		return sum;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Order moment: " + sdfmoment.format(this.getMoment()) + "\n");
		sb.append("Order statud: " + this.getStatus() + "\n");
		sb.append("Client: " + this.getClient().getName() + " (" + sdfbirthdate.format(this.getClient().getBirthdate())
				+ ") - " + this.getClient().getEmail() + "\n");
		sb.append("Order items: " + "\n");

		for (OrderItem odr : items) {

			sb.append(odr.getProduct().getName() + ", $" + String.format("%.2f", odr.getPrice()) + ", Quantity: "
					+ odr.getQuantity() + ", Subtotal: $" + String.format("%.2f", odr.subTotal()) + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f", this.total()) + "\n");

		return sb.toString();
	}

}
