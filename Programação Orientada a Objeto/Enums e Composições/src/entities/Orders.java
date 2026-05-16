package entities;

import java.util.Date;

import entities.enums.OrdersStatus;

public class Orders {

	private Integer id;
	private Date moment;
	private OrdersStatus status;

	public Orders() {
	}

	public Orders(Integer id, Date moment, OrdersStatus status) {
		this.id = id;
		this.moment = moment;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrdersStatus getStatus() {
		return status;
	}

	public void setStatus(OrdersStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders ["
				+ "id=" + id + ", "
						+ "moment=" + moment + ", "
								+ "status=" + status + "]";
	}

}
