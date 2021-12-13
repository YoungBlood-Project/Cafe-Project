package edu.sp5.jvx330.cafe.web.container;

import edu.sp5.jvx330.cafe.common.command.CustomerCommand;
import edu.sp5.jvx330.cafe.common.command.MileageCommand;
import edu.sp5.jvx330.cafe.common.command.OrderItemsCommand;

public class orderContainer {
	private CustomerCommand customerCommand;
	private MileageCommand mileageCommand;
	private OrderItemsCommand orderItemsCommand;
	
	public CustomerCommand getCustomerCommand() {
		return customerCommand;
	}
	public void setCustomerCommand(CustomerCommand customerCommand) {
		this.customerCommand = customerCommand;
	}
	public MileageCommand getMileageCommand() {
		return mileageCommand;
	}
	public void setMileageCommand(MileageCommand mileageCommand) {
		this.mileageCommand = mileageCommand;
	}
	public OrderItemsCommand getOrderItemsCommand() {
		return orderItemsCommand;
	}
	public void setOrderItemsCommand(OrderItemsCommand orderItemsCommand) {
		this.orderItemsCommand = orderItemsCommand;
	}
	
	@Override
	public String toString() {
		return "orderContainer [customerCommand=" + customerCommand + ", mileageCommand=" + mileageCommand
				+ ", orderItemsCommand=" + orderItemsCommand + "]";
	}
}
