package warehouse.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import warehouse.model.*;

public interface WarehouseRepository extends MongoRepository<WarehouseData, String> {

    public WarehouseData findByWarehouseID(String warehouseID);

    // public List<ProductData> findByProductID(String productID);

    // public ProductData findByWarehouseIDAndProductName(String warehouseID);

    // public ProductData findByWarehouseIDAndProductName(String warehouseID, String productName);

    // public List<ProductData> findByProductQuantityLessThan(int quantity);

    // public List<ProductData> findByWarehouseIDAndProductQuantityLessThan(String warehouseID, int quantity);
}
