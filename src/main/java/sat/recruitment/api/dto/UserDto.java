package sat.recruitment.api.dto;

import javax.validation.constraints.NotNull;


public class UserDto {
        @NotNull(message = "The name is required")
	private String name;
        @NotNull(message = "The email is required")
	private String email;
        @NotNull(message = "The address is required")
	private String address;
        @NotNull(message = "The phone is required")
	private String phone;
	private String userType;
	private Double money;
	
	public UserDto() {
		
	}

	public UserDto(String name, String email, String address, String phone, String userType, Double money) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.userType = userType;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
        

}
