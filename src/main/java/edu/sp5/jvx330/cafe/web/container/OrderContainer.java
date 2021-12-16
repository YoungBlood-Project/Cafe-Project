package edu.sp5.jvx330.cafe.web.container;

import java.util.List;

import edu.sp5.jvx330.cafe.membership.domain.Customer;
import edu.sp5.jvx330.cafe.membership.domain.Mileage;
import edu.sp5.jvx330.cafe.membership.domain.MileageHistory;
import edu.sp5.jvx330.cafe.menu.command.OrderItemsCommand;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

public class OrderContainer {
	private SalesTotalPrice salesTotalPrice;
	private Customer customer;
	private Integer mileage;
	private MileageHistory mileageHistory;
	private List<OrderItemsCommand> orderItemsList;
	
	public SalesTotalPrice getSalesTotalPrice() {
		return salesTotalPrice;
	}
	public void setSalesTotalPrice(SalesTotalPrice salesTotalPrice) {
		this.salesTotalPrice = salesTotalPrice;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getMileage() {
		return mileage;
	}
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}
	public MileageHistory getMileageHistory() {
		return mileageHistory;
	}
	public void setMileageHistory(MileageHistory mileageHistory) {
		this.mileageHistory = mileageHistory;
	}
	public List<OrderItemsCommand> getOrderItemsList() {
		return orderItemsList;
	}
	public void setOrderItemsList(List<OrderItemsCommand> orderItemsList) {
		this.orderItemsList = orderItemsList;
	}
	@Override
	public String toString() {
		return "OrderContainer [salesTotalPrice=" + salesTotalPrice + ", customer=" + customer + ", mileage=" + mileage
				+ ", mileageHistory=" + mileageHistory + ", orderItemsList=" + orderItemsList + "]";
	}
}
