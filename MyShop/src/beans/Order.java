package beans;

public class Order {
	private int orderID;
	private int cartID;
	private String userID;
	private String userName;
	private String userAdd;
	private String userTel;
	private int prodID;
	private int prodPrice;
	private String prodName;
	private int prodQuantity;
	private int totalPrice;
	private String farmID;
	private String farmTel;
	private boolean farmCheck;
	private int trackNum;
	private String is_status;
	
	
	
	public Order(int orderID, int cartID, String userID, String userName, String userAdd, String userTel, int prodID,
			int prodPrice, String prodName, int prodQuantity, int totalPrice, String farmID, String farmTel,
			boolean farmCheck, int trackNum, String is_status) {
		this.orderID = orderID;
		this.cartID = cartID;
		this.userID = userID;
		this.userName = userName;
		this.userAdd = userAdd;
		this.userTel = userTel;
		this.prodID = prodID;
		this.prodPrice = prodPrice;
		this.prodName = prodName;
		this.prodQuantity = prodQuantity;
		this.totalPrice = totalPrice;
		this.farmID = farmID;
		this.farmTel = farmTel;
		this.farmCheck = farmCheck;
		this.trackNum = trackNum;
		this.is_status = is_status;
	}

	public int getOrderID() {
		return orderID;
	}
	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAdd() {
		return userAdd;
	}
	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public int getProdID() {
		return prodID;
	}
	public void setProdID(int prodID) {
		this.prodID = prodID;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdQuantity() {
		return prodQuantity;
	}
	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getFarmID() {
		return farmID;
	}
	public void setFarmID(String farmID) {
		this.farmID = farmID;
	}
	public String getFarmTel() {
		return farmTel;
	}
	public void setFarmTel(String farmTel) {
		this.farmTel = farmTel;
	}
	public boolean getFarmCheck() {
		return farmCheck;
	}
	public void setFarmCheck(Boolean farmCheck) {
		this.farmCheck = farmCheck;
	}
	public int getTrackNum() {
		return trackNum;
	}
	public void setTrackNum(int trackNum) {
		this.trackNum = trackNum;
	}
	public String getIs_status() {
		return is_status;
	}
	public void setIs_status(String is_status) {
		this.is_status = is_status;
	}
	
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", cartID=" + cartID + ", userID=" + userID + ", userName=" + userName
				+ ", userAdd=" + userAdd + ", userTel=" + userTel + ", prodID=" + prodID + ", prodPrice=" + prodPrice
				+ ", prodName=" + prodName + ", prodQuantity=" + prodQuantity + ", totalPrice=" + totalPrice
				+ ", farmID=" + farmID + ", farmTel=" + farmTel + ", farmCheck=" + farmCheck + ", trackNum=" + trackNum
				+ ", is_status=" + is_status + "]";
	}
	
	
}
