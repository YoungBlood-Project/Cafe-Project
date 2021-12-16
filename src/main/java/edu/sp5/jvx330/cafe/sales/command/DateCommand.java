package edu.sp5.jvx330.cafe.sales.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DateCommand {

	private String year;
	private String month;
	private String day;
	
	public DateCommand() {
		
	}

	public DateCommand(String year, String month, String day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
}
