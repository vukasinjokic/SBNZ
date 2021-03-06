package sbnz.integracija.example.facts;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class WeeklyProfitTrigger {
	
	private double profitSum;
	private Date date;
	
	public WeeklyProfitTrigger() {
		this.profitSum = 0.0;
		this.date = new Date();
	}
	
	public void setProfitSum(Double profitSum) {
		this.profitSum = profitSum;
	}
	
	public double getProfitSum() {
		return this.profitSum;
	}

}
