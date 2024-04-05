package warehouse.repository;

import java.util.Optional;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import warehouse.model.*;

public interface WarehouseRepository extends MongoRepository<WarehouseData, String> {

    public Optional<WarehouseData> findFirstByWarehouseIDOrderByTimestampDesc(String warehouseID);

    public List<WarehouseData> findByWarehouseIDAndTimestampBetween(String warehouseID, LocalDateTime startTime, LocalDateTime endTime);

}
