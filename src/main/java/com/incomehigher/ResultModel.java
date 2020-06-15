package com.incomehigher;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ResultModel {

	private List<BtcModel> btcs=new ArrayList<BtcModel>();
	
	private BigDecimal total=BigDecimal.ZERO;
	
	public List<BtcModel> getBtcs() {
		return btcs;
	}
	
	public void addBtcs(String address,BigDecimal number) {
		BtcModel model=new BtcModel(address,number);
		this.btcs.add(model);
		this.total=this.total.add(number);
		System.out.println();
	}
	public void setBtcs(List<BtcModel> btcs) {
		this.btcs = btcs;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ResultModel [btcs=" + btcs + ", total=" + total + "]";
	}

	public static class BtcModel{
		private String address;
		
		private BigDecimal number;

		public BtcModel() {
			super();
		}

		public BtcModel(String address, BigDecimal number) {
			super();
			this.address = address;
			this.number = number;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public BigDecimal getNumber() {
			return number;
		}

		public void setNumber(BigDecimal number) {
			this.number = number;
		}

		@Override
		public String toString() {
			return "BtcModel [address=" + address + ", number=" + number + "]";
		}
		
	}
}
