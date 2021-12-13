package edu.sp5.jvx330.cafe.web.container;

import java.util.List;

import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.domain.SalesTotalPrice;
import edu.sp5.jvx330.cafe.membership.command.CustomerCommand;
import edu.sp5.jvx330.cafe.membership.command.MileageCommand;
import edu.sp5.jvx330.cafe.menu.command.OrderItemsCommand;

public class OrderContainer {
	private SalesTotalPrice salesTotalPrice;
	private MileageCommand mileageCommand;
	private List<OrderItemsCommand> orderItemsList;
	
	public SalesTotalPrice getSalesTotalPrice() {
		return salesTotalPrice;
	}
	public void setSalesTotalPrice(SalesTotalPrice salesTotalPrice) {
		this.salesTotalPrice = salesTotalPrice;
	}
	public MileageCommand getMileageCommand() {
		return mileageCommand;
	}
	public void setMileageCommand(MileageCommand mileageCommand) {
		this.mileageCommand = mileageCommand;
	}
	public List<OrderItemsCommand> getOrderItemsList() {
		return orderItemsList;
	}
	public void setOrderItemsList(List<OrderItemsCommand> orderItemsList) {
		this.orderItemsList = orderItemsList;
	}
	@Override
	public String toString() {
		return "OrderContainer [salesTotalPrice=" + salesTotalPrice + ", mileageCommand=" + mileageCommand
				+ ", orderItemsList=" + orderItemsList + "]";
	}
}
