package exercises8;

public class StockHolding {
	private final String stockName, stockOwner;
	private int shareNum;
	private int pricePerShare;
	public StockHolding(String stockName, String stockOwner, int shareNum, int pricePerShare) {

		this.stockName = stockName;
		this.stockOwner = stockOwner;
		this.shareNum = shareNum;
		this.pricePerShare = pricePerShare;
	}
	public int getShareNum() {
		return this.shareNum;
	}
	public void setShareNum(int shareNum) {
		this.shareNum = shareNum;
	}
	public int getPricePerShare() {
		return this.pricePerShare;
	}
	public void setPricePerShare(int pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public String getStockName() {
		return this.stockName;
	}
	public String getStockOwner() {
		return this.stockOwner;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stockName == null) ? 0 : stockName.hashCode());
		result = prime * result + ((stockOwner == null) ? 0 : stockOwner.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockHolding other = (StockHolding) obj;
		if (stockName == null) {
			if (other.stockName != null)
				return false;
		} else if (!stockName.equals(other.stockName))
			return false;
		if (stockOwner == null) {
			if (other.stockOwner != null)
				return false;
		} else if (!stockOwner.equals(other.stockOwner))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StockHolding [stockName=" + stockName + ", stockOwner=" + stockOwner + ", shareNum=" + shareNum
				+ ", pricePerShare=" + pricePerShare + "]";
	}
	
	
}
