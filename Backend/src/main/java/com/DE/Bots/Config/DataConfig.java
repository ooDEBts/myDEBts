package com.DE.Bots.Config;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.DE.Bots.Repository.RepositoryPackage;
import com.DE.Bots.Repository.TemplatePackage;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@Component
@EnableMongoRepositories(basePackageClasses = RepositoryPackage.class)
@ComponentScan(basePackageClasses = TemplatePackage.class)
public class DataConfig  extends AbstractMongoConfiguration{
    private static final Log LOG = LogFactory.getLog(DataConfig.class);
    private String host;
    private int port;
    private String dbUserId;
	private String dbPassword;
	private static DataConfig myObj;
	static AnnotationConfigApplicationContext ctx = null;
	MongoClient client = null;
	
	private DataConfig() {

	}
	
	public static DataConfig getInstance() {
		System.out.println("myObj  " + myObj);
		if (myObj == null) {
			myObj = new DataConfig();
		}
		return myObj;
	}
	
    @Override
    public String getDatabaseName() {
        Properties properties = new Properties();
        try {
            InputStream in = getClass().getClassLoader().getResourceAsStream("ServerDataConfig.properties");
            properties.load(in);

        } catch (IOException e) {
            LOG.info(e);
        }
        return properties.getProperty("config.db");
    }

    @Override
    @Bean
    public MongoClient mongo() throws Exception {
    	if (client == null) {
        Properties properties = new Properties();
        try {
            InputStream in = getClass().getClassLoader().getResourceAsStream("ServerDataConfig.properties");
            properties.load(in);
            host = properties.getProperty("config.host");
            port = Integer.parseInt(properties.getProperty("config.port"));
            dbUserId = properties.getProperty("config.userId");
			dbPassword = properties.getProperty("config.password");
            LOG.info("host  " + host);
            LOG.info("port  " + port);
        } catch (Exception e) {
            LOG.info(e);
            LOG.error("File not found  " + e.getMessage());
        }
        @SuppressWarnings("deprecation")
		MongoClientOptions mongoClientOptions= MongoClientOptions.builder().connectionsPerHost(50)
        		 .connectTimeout(1000).socketKeepAlive(false).cursorFinalizerEnabled(true).maxConnectionLifeTime(5000)
        		.writeConcern(WriteConcern.SAFE).threadsAllowedToBlockForConnectionMultiplier(50).readPreference(ReadPreference.primary()).build();
        
        ServerAddress serverAddr = new ServerAddress(host, port);
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(dbUserId, "admin",
				dbPassword.toCharArray());
        client = new MongoClient(serverAddr,Collections.singletonList(mongoCredential),mongoClientOptions);
    	}
        return client;
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.bolt.dashboard.Model";
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }

    public static AnnotationConfigApplicationContext getContext() {
		if (ctx == null || !ctx.isActive()) {
			ctx = new AnnotationConfigApplicationContext(DataConfig.class);
			return ctx;
		} else {
			return ctx;
		}

	}


}
