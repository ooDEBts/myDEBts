package com.DE.Bots.core.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bidds")
public class BidDetails extends BaseModel {
	private String ids;
	private String cName;
	private double minPrice;
	private double sellPrice;
	private double expectedSellingPrice;
	private String biddedBy;
	private Long bidDate;
	private String qty;

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getExpectedSellingPrice() {
		return expectedSellingPrice;
	}

	public void setExpectedSellingPrice(double expectedSellingPrice) {
		this.expectedSellingPrice = expectedSellingPrice;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getBiddedBy() {
		return biddedBy;
	}

	public void setBiddedBy(String biddedBy) {
		this.biddedBy = biddedBy;
	}

	public Long getBidDate() {
		return bidDate;
	}

	public void setBidDate(Long bidDate) {
		this.bidDate = bidDate;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

}