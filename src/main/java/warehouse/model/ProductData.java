package warehouse.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;


public class ProductData {

	@Id
	private String ID;

	private String warehouseID;
	private String productID;
	private String productName;
	private String productCategory;
	private double productQuantity;
	private LocalDateTime timestamp;

	/**
	 * Constructor
	 */
	public ProductData() {
	}

	public ProductData(String warehouseID, String productID, String productName, String productCategory, double productQuantity, LocalDateTime timestamp) {
		super();
		this.warehouseID = warehouseID;
		this.productID = productID;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
		if(timestamp == null) this.timestamp = LocalDateTime.now();
		else{this.timestamp=timestamp;}
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(double productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Product Info: WarehouseID = %s, ProductID = %s, ProductName = %s, ProductCategory = %s, ProductQuantity = %4.1f, Timestamp = %s",
				warehouseID, productID, productName, productCategory, productQuantity, timestamp );
		return info;
	}
}
