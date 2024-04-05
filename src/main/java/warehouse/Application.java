package warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;

import warehouse.model.ProductData;
import warehouse.model.*;
import warehouse.repository.WarehouseRepository;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private WarehouseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Initialize product data repository
		List<ProductData> pd = new ArrayList<>();

		// Save new Data
		/*
		pd.add(new ProductData("1", "00-112233", "Bio Erdbeersaft Sonne", "Getraenk", 2100, null));
		pd.add(new ProductData("1", "01-112233", "Ariel Waschmittel Universal", "Waschmittel", 500, null));
		pd.add(new ProductData("1", "02-112233", "Whiskas Katzenfutter Huhn", "Tierfutter", 1200,null));
		pd.add(new ProductData("1", "03-112233", "Swiffer Staubmagnet Tücher", "Reinigung", 7200,null));

		repository.save(new WarehouseData("1", "Linz Bahnhof", null, "4010", "Linz", "Austria", pd));


		List<ProductData> pd2 = new ArrayList<>();

		pd2.add(new ProductData("2", "00-445566", "Bio Orangensaft Sonne", "Getraenk", 1800,null));
		pd2.add(new ProductData("2", "01-445566", "Persil Waschmittel Color", "Waschmittel", 700,null));
		pd2.add(new ProductData("2", "02-445566", "Sheba Katzenfutter Rind", "Tierfutter", 1500,null));
		pd2.add(new ProductData("2", "03-445566", "Mr. Proper Allzweckreiniger", "Reinigung", 6200,null));

		repository.save(new WarehouseData("2", "Graz Hauptplatz", null, "8010", "Graz", "Austria", pd2));

		List<ProductData> pd3 = new ArrayList<>();

		pd3.add(new ProductData("3", "00-778899", "Apfelschorle Frisch", "Getraenk", 2500,null));
		pd3.add(new ProductData("3", "01-778899", "Vanish Oxi Action Fleckenentferner", "Waschmittel", 600,null));
		pd3.add(new ProductData("3", "02-778899", "Whiskas Katzenfutter Lachs", "Tierfutter", 1100,null));
		pd3.add(new ProductData("3", "03-778899", "Cif Power & Shine Badreiniger", "Reinigung", 8000,null));

		repository.save(new WarehouseData("3", "Vienna Westbahnhof", null, "1150", "Vienna", "Austria", pd3));
		*/


		// Fetch all product from Warehouse 1
		System.out.println("Record(s) found with findByWarehouseID(\"1\"):");
		System.out.println("--------------------------------");
		System.out.println(repository.findFirstByWarehouseIDOrderByTimestampDesc("1"));

		// Fetch all product from Warehouse 2
		System.out.println("Record(s) found with findByWarehouseID(\"2\"):");
		System.out.println("--------------------------------");
		System.out.println(repository.findFirstByWarehouseIDOrderByTimestampDesc("2"));

		System.out.println("Record(s) found with findByWarehouseID(\"1\") between the time of Now and 1 week ago:");
		System.out.println("--------------------------------");
		LocalDateTime endTime = LocalDateTime.now();
		LocalDateTime startTime = endTime.minus(7, ChronoUnit.DAYS);

		System.out.println("Start Time: " + startTime);
		System.out.println("End Time: " + endTime);
		for (WarehouseData data : repository.findByWarehouseIDAndTimestampBetween("1", startTime, endTime)) {
			System.out.println(data);
		}
	}

}
