package com.niit.shoppingcart.cofig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration//Indicates that a class declares one or more @Bean methods and may be 
               //processed by the Spring container to generate bean definitions and service requests for those beans at runtime. 
@ComponentScan("com.niit.shoppingcart") //Configures component scanning directives for use with @Configuration classes
@EnableTransactionManagement   //Enables Spring's annotation-driven transaction management capability, similar to the support found in Spring's <tx:*> XML namespace
public class ApplicationContextConfig {
	
	@Bean(name = "dataSource")         //@Bean is a method-level annotation and a direct analog of the XML <bean/> element
	public DataSource getH2DataSource() //Spring obtains a connection to the database through a DataSource
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource(); //Simple implementation of the standard JDBC DataSource interface, configuring the plain old JDBC DriverManager 
		                                                                    //via bean properties, and returning a new Connection from every getConnection call.
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/newshopping");//address used to locate database
		dataSource.setDriverClassName("org.h2.Driver");            //software component enabling a Java application to interact with a database.
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
	}

	private Properties getHibernateProperties() // Properties class is a subclass of Hashtable and represents a persistent set of properties
	{
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");  //This property makes Hibernate generate the appropriate SQL for the chosen database.
		properties.put("hibernate.show_sql", "true");   // Display Hibernate SQL to console
		properties.put("hibernate.hbm2ddl.auto", "update");//validates or exports schema DDL to the database when the SessionFactory is created, create | update | validate | create-drop
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) //SessinoFactorycreate Session instance, Once it is created this internal state is set.
	                                                               //This internal state includes all of the metadata about Object/Relational Mapping. immutable, thread safe
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource); //providing convenient ways to specify a DataSource and an application class loader
		sessionBuilder.addProperties(getHibernateProperties());   //Add the given hibernate properties
		sessionBuilder.scanPackages("com.niit");   //scan the given package
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
