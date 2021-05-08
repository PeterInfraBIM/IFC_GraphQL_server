package nl.infrabim.ifc.dataserver;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class DataserverApplication implements CommandLineRunner {

	@Autowired
	public DataserverApplication() {
		MongoClient mongoClient = MongoClients.create(
				"mongodb+srv://m001-student:m001-mongodb-basics@sandbox.9l3sa.mongodb.net/building_smart?retryWrites=true&w=majority");
		MongoDatabase database = mongoClient.getDatabase("building_smart");
		MongoCollection<Document> roots = database.getCollection("Ifc_json_2");
		System.out.println(roots.countDocuments());
		for (Document root : roots.find()) {
			System.out.println(
					"type:" + root.get("type") + " globalId:" + root.get("globalId") + " name:" + root.get("name"));
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DataserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(rootRepository.count());
//		for (IfcJason2 root: rootRepository.findAll()) {
//			System.out.println(root);
//		}
	}

}
