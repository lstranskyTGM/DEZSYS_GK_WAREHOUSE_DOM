package warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
		repository.deleteAll();


		List<ProductData> pd = new ArrayList<>();

		pd.add(new ProductData("1", "00-112233", "Bio Erdbeersaft Sonne", "Getraenk", 2100));
		pd.add(new ProductData("1", "01-112233", "Ariel Waschmittel Universal", "Waschmittel", 500));
		pd.add(new ProductData("1", "02-112233", "Whiskas Katzenfutter Huhn", "Tierfutter", 1200));
		pd.add(new ProductData("1", "03-112233", "Swiffer Staubmagnet Tücher", "Reinigung", 7200));

		repository.save(new WarehouseData("1", "Linz Bahnhof", "1111", "4010", "Linz", "Austria", pd));


		List<ProductData> pd2 = new ArrayList<>();

		pd2.add(new ProductData("2", "00-445566", "Bio Orangensaft Sonne", "Getraenk", 1800));
		pd2.add(new ProductData("2", "01-445566", "Persil Waschmittel Color", "Waschmittel", 700));
		pd2.add(new ProductData("2", "02-445566", "Sheba Katzenfutter Rind", "Tierfutter", 1500));
		pd2.add(new ProductData("2", "03-445566", "Mr. Proper Allzweckreiniger", "Reinigung", 6200));

		repository.save(new WarehouseData("2", "Graz Hauptplatz", "2222", "8010", "Graz", "Austria", pd2));

		List<ProductData> pd3 = new ArrayList<>();

		pd3.add(new ProductData("3", "00-778899", "Apfelschorle Frisch", "Getraenk", 2500));
		pd3.add(new ProductData("3", "01-778899", "Vanish Oxi Action Fleckenentferner", "Waschmittel", 600));
		pd3.add(new ProductData("3", "02-778899", "Whiskas Katzenfutter Lachs", "Tierfutter", 1100));
		pd3.add(new ProductData("3", "03-778899", "Cif Power & Shine Badreiniger", "Reinigung", 8000));

		repository.save(new WarehouseData("3", "Vienna Westbahnhof", "3333", "1150", "Vienna", "Austria", pd3));
		/*
		repository.save(new ProductData("1", "00-112233", "Bio Erdbeersaft Sonne", "Getraenk", 2100));
		repository.save(new ProductData("2", "00-445566", "Bio Himbeersaft Sonne", "Getraenk", 2650));
		repository.save(new ProductData("3", "00-778899", "Bio Multivitaminsaft Sonne", "Getraenk", 2980));
		repository.save(new ProductData("4", "00-987654", "Bio Birnensaft Sonne", "Getraenk", 3100));
		repository.save(new ProductData("5", "01-654321", "Bio Traubensaft Sonne", "Getraenk", 2780));

		repository.save(new ProductData("1", "01-112233", "Ariel Waschmittel Universal", "Waschmittel", 500));
		repository.save(new ProductData("2", "01-445566", "Persil Waschmittel Color", "Waschmittel", 510));
		repository.save(new ProductData("3", "01-778899", "Spee Waschmittel Weiß", "Waschmittel", 480));
		repository.save(new ProductData("4", "01-987654", "Lenor Weichspüler Frühling", "Waschmittel", 530));
		repository.save(new ProductData("5", "02-654321", "Vernel Duftperlen Sommerfrische", "Waschmittel", 490));

		repository.save(new ProductData("1", "02-112233", "Whiskas Katzenfutter Huhn", "Tierfutter", 1200));
		repository.save(new ProductData("2", "02-445566", "Pedigree Hundetrockenfutter Rind", "Tierfutter", 1500));
		repository.save(new ProductData("3", "02-778899", "Felix Katzenfutter Mix", "Tierfutter", 1350));
		repository.save(new ProductData("4", "02-987654", "Royal Canin Hundetrockenfutter Lamm", "Tierfutter", 1420));
		repository.save(new ProductData("5", "03-654321", "Sheba Katzenfutter Geflügel", "Tierfutter", 1300));

		repository.save(new ProductData("1", "03-112233", "Swiffer Staubmagnet Tücher", "Reinigung", 7200));
		repository.save(new ProductData("2", "03-445566", "WC-Ente Aktiv Gel Frische", "Reinigung", 7600));
		repository.save(new ProductData("3", "03-778899", "Bref Power WC-Kraftgel", "Reinigung", 7900));
		repository.save(new ProductData("4", "03-987654", "Domestos Power 5 Ocean Frisch", "Reinigung", 8100));
		repository.save(new ProductData("5", "04-654321", "Sagrotan Desinfektionsspray", "Reinigung", 7500));

		System.out.println();
		*/


		// fetch all products
		/*
		System.out.println("ProductData found with findAll():");
		System.out.println("-------------------------------");
		for (ProductData productdata : repository.findAll()) {
			System.out.println(productdata);
		}
		System.out.println();

		// Fetch single product
		System.out.println("Record(s) found with ProductID(\"00-871895\"):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByProductID("00-871895"));
		System.out.println();

		// Fetch all products of Warehouse 1
		System.out.println("Record(s) found with findByWarehouseID(\"1\"):");
		System.out.println("--------------------------------");
		for (ProductData productdata : repository.findByWarehouseID("1")) {
			System.out.println(productdata);
		}
		System.out.println();

		// Fetch all products of Warehouse 2
		System.out.println("Record(s) found with findByWarehouseID(\"2\"):");
		System.out.println("--------------------------------");
		for (ProductData productdata : repository.findByWarehouseID("2")) {
			System.out.println(productdata);
		}
		*/

		// Fetch all product from Warehouse 1
		System.out.println("Record(s) found with findByWarehouseID(\"1\"):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByWarehouseID("1"));

		// Fetch all product from Warehouse 2
		System.out.println("Record(s) found with findByWarehouseID(\"2\"):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByWarehouseID("2"));
	}

}
