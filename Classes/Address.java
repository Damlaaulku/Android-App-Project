
public class Address {
	
	private String name,city,town,quarter,details;

	//Constructor
	public Address(String name, String city, String town, String quarter, String details) {
		this.name = name;
		this.city = city;
		this.town = town;
		this.quarter = quarter;
		this.details = details;
	}

	//Getters&Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	
}
