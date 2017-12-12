package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.daoimpl.CartDaoImpl;
/*
import com.niit.daoimpl.CartDaoImpl;
*/import com.niit.daoimpl.categoryDaoImpl;
import com.niit.daoimpl.ordersdaoimpl;
import com.niit.daoimpl.productDaoImpl;
import com.niit.daoimpl.supplierDaoImpl;
import com.niit.daoimpl.usermodeldaoimpl;

@Configuration
@ComponentScan("com.niit.config")
@EnableTransactionManagement
public class Hibernateconfig {
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl("jdbc:h2:tcp://localhost/~/cdt");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("com.niit.model");
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired
	@Bean(name = "productDao")
	public productDaoImpl getproductmodeldao(SessionFactory sessionFactory)

	{
		return new productDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "CategoryDao")
	public categoryDaoImpl getcategorydao(SessionFactory sessionFactory)

	{
		return new categoryDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "suppliermodeldao")
	public supplierDaoImpl getsuppliermodeldao(SessionFactory sessionFactory)

	{
		return new supplierDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "UserDao")
	public usermodeldaoimpl getusermodeldao(SessionFactory sessionFactory)

	{
		return new usermodeldaoimpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "CartDao")
	public CartDaoImpl getcartmodeldao(SessionFactory sessionFactory)

	{
		return new CartDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "OrdersDao")
	public ordersdaoimpl getorderdao(SessionFactory sessionFactory)

	{
		return new ordersdaoimpl(sessionFactory);
	}
}

