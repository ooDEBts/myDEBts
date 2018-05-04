package com.DE.Bots.core.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class Product extends BaseModel {
	private String ids;
	private String name;
	private String description;
	private double meanBidPrice;
	private double suggestedBidPrice;
	private long addOn;
	private int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getAddOn() {
		return addOn;
	}

	public double getMeanBidPrice() {
		return meanBidPrice;
	}

	public void setMeanBidPrice(double meanBidPrice) {
		this.meanBidPrice = meanBidPrice;
	}

	public double getSuggestedBidPrice() {
		return suggestedBidPrice;
	}

	public void setSuggestedBidPrice(double suggestedBidPrice) {
		this.suggestedBidPrice = suggestedBidPrice;
	}

	public void setAddOn(long addOn) {
		this.addOn = addOn;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
