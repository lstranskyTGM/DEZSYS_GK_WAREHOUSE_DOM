package warehouse.model;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

public class WarehouseData {

    private String warehouseID;
    private String warehouseName;
    private LocalDateTime timestamp;
    private String warehousePostalCode;
    private String warehouseCity;
    private String warehouseCountry;
    private List<ProductData> productData;

    /**
     * Constructor
     */
    public WarehouseData() {
    }

    public WarehouseData(String warehouseID, String warehouseName, LocalDateTime timestamp, String warehousePostalCode, String warehouseCity, String warehouseCountry, List<ProductData> productData) {
        super();
        this.warehouseID = warehouseID;
        this.warehouseName = warehouseName;
        if(timestamp == null) this.timestamp = LocalDateTime.now();
        else{this.timestamp=timestamp;}
        this.warehousePostalCode = warehousePostalCode;
        this.warehouseCity = warehouseCity;
        this.warehouseCountry = warehouseCountry;
        this.productData = productData;
    }


    /**
     * Methods
     */
    @Override
    public String toString() {
        String info = String.format("WarehouseInfo: WarehouseID = %s, WarehouseName = %s, Timestamp = %s, WarehousePostalCode = %s, WarehouseCity = %s, WarehouseCountry = %s, ProductData = %s",
                warehouseID, warehouseName, timestamp, warehousePostalCode, warehouseCity, warehouseCountry, this.productListToString());
        return info;
    }

    public String productListToString(){
        String out = "\n";
        for(ProductData x: productData){
            out += x.toString() + "\n";
        }
        return out;
    }
}
