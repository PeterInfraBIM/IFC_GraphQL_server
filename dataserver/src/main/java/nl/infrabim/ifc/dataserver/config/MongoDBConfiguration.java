package nl.infrabim.ifc.dataserver.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@Service
public class MongoDBConfiguration {
	private ConnectionString connectionString;
	private MongoClient mongoClient;

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public MongoClient mongoClient(@Value("${spring.data.mongodb.uri}") String connectionString) {

		this.connectionString = new ConnectionString(connectionString);

		WriteConcern wc = WriteConcern.MAJORITY.withWTimeout(2500, TimeUnit.MILLISECONDS);
		MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(this.connectionString)
				.writeConcern(wc).build();
		mongoClient = MongoClients.create(settings);

		return mongoClient;
	}

	public MongoClient getMongoClient() {
		return mongoClient;
	}
}
