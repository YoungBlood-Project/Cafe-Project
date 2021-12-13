package edu.sp5.jvx330.cafe.common.command;

//@Getter
//@Setter
//왜 Getter, Setter 사용 못...
public class CustomerCommand {
	private String name;
	private String phone;
	
	public CustomerCommand() {
		
	}
	
	public CustomerCommand(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "CustomerCommand [name=" + name + ", phone=" + phone + "]";
	}
}
