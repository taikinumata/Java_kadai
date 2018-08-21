package dto;

public class House {
	private int number;
	private String income;
	private String spending;

	public House(int number,String income,String spending){
		this.number = number;
		this.income = income;
		this.spending = spending;


	}
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getSpending() {
		return spending;
	}

	public void setSpending(String spending) {
		this.spending = spending;
	}
	}
