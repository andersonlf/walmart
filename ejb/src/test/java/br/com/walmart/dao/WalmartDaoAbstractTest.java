///*
// * Desenvolvido por Anderson Lobo Feitosa, 2014
// */
//package br.com.walmart.dao;
//
//import java.sql.Connection;
//import java.util.Properties;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//
//import org.hibernate.ejb.Ejb3Configuration;
//import org.hibernate.ejb.HibernateEntityManager;
//import org.hibernate.event.DeleteEventListener;
//import org.hibernate.event.FlushEntityEventListener;
//import org.hibernate.event.FlushEventListener;
//import org.hibernate.event.MergeEventListener;
//import org.hibernate.event.PersistEventListener;
//import org.hibernate.event.PostDeleteEventListener;
//import org.hibernate.event.PostInsertEventListener;
//import org.hibernate.event.PostLoadEventListener;
//import org.hibernate.event.PostUpdateEventListener;
//import org.hibernate.event.PreDeleteEventListener;
//import org.hibernate.event.PreInsertEventListener;
//import org.hibernate.event.PreLoadEventListener;
//import org.hibernate.event.PreUpdateEventListener;
//import org.hibernate.event.SaveOrUpdateEventListener;
//import org.hibernate.event.def.DefaultDeleteEventListener;
//import org.hibernate.event.def.DefaultFlushEntityEventListener;
//import org.hibernate.event.def.DefaultFlushEventListener;
//import org.hibernate.event.def.DefaultMergeEventListener;
//import org.hibernate.event.def.DefaultPersistEventListener;
//import org.hibernate.event.def.DefaultPostLoadEventListener;
//import org.hibernate.event.def.DefaultPreLoadEventListener;
//import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;
//import org.hibernate.tool.hbm2ddl.SchemaExport;
//import org.hibernate.validator.event.ValidateEventListener;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//
///**
// * Infraestrutura básica para criação de testes unitários para a camada de
// * persistência.
// *
// * @author andersonlf@gmail.com
// */
//public abstract class WalmartDaoAbstractTest {
//
//	private EntityManagerFactory entityManagerFactory;
//	private Ejb3Configuration configuration;
//
//	private EntityManager entityManager;
//	private EntityTransaction transaction;
//	private SchemaExport schemaExport;
//
//	private Boolean create = Boolean.TRUE;
//	private Boolean drop = Boolean.FALSE;
//	private Boolean exportDDL = Boolean.TRUE;
//
//	public WalmartDaoAbstractTest() {
//		if (configuration == null) {
//			configuration = newEjb3Configuration();
//		}
//		if (entityManagerFactory == null) {
//			entityManagerFactory = configuration.buildEntityManagerFactory();
//		}
//		if (entityManager == null) {
//			entityManager = entityManagerFactory.createEntityManager();
//		}
//		schemaExport = new SchemaExport(
//				configuration.getHibernateConfiguration());
//	}
//
//	@BeforeClass
//	public void before() {
//		if (exportDDL) {
//			schemaExport.setDelimiter(";");
//			schemaExport.setOutputFile("target/ddl.sql");
//		}
//		if (create) {
//			schemaExport.create(Boolean.TRUE, exportDDL);
//		}
//	}
//
//	@AfterClass
//	public void after() {
//		if (drop) {
//			schemaExport.drop(Boolean.TRUE, exportDDL);
//		}
//	}
//
//	protected EntityManager getEntityManager() {
//		return entityManager;
//	}
//
//	@SuppressWarnings("deprecation")
//	protected Connection getConnection() {
//
//		return ((HibernateEntityManager) entityManager).getSession()
//				.connection();
//	}
//
//	protected void roolBack() {
//		if (transaction != null && transaction.isActive()) {
//			transaction.rollback();
//		}
//	}
//
//	protected void commit() {
//		if (transaction != null && transaction.isActive()) {
//			transaction.commit();
//		}
//	}
//
//	protected void begin() {
//		if (transaction == null) {
//			transaction = entityManager.getTransaction();
//		}
//		transaction.begin();
//	}
//
//	private Ejb3Configuration newEjb3Configuration() {
//
//		Ejb3Configuration ejb3Configuration = new Ejb3Configuration();
//
//		Properties properties = new Properties();
//		properties.put("hibernate.connection.url",
//				"jdbc:hsqldb:mem:unit-testing-jpa");
//		properties.put("hibernate.connection.driver_class",
//				"org.hsqldb.jdbcDriver");
//		properties
//				.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
//		properties.put("hibernate.connection.username", "sa");
//		properties.put("hibernate.connection.password", "");
//		properties.put("hibernate.show_sql", "true");
//		properties.put("hibernate.format_sql", "false");
//		properties.put("hibernate.hbm2ddl.auto", "create-drop");
//		properties.put("hibernate.jdbc.batch_size", 0);
//		ejb3Configuration.setProperties(properties);
//
//		ejb3Configuration.getEventListeners().setPreDeleteEventListeners(
//				new PreDeleteEventListener[0]);
//		ejb3Configuration.getEventListeners().setDeleteEventListeners(
//				new DeleteEventListener[] { new DefaultDeleteEventListener() });
//		ejb3Configuration.getEventListeners().setPostDeleteEventListeners(
//				new PostDeleteEventListener[0]);
//		ejb3Configuration.getEventListeners().setPreInsertEventListeners(
//				new PreInsertEventListener[0]);
//		ejb3Configuration
//				.getEventListeners()
//				.setPersistEventListeners(
//						new PersistEventListener[] { new DefaultPersistEventListener() });
//		ejb3Configuration.getEventListeners().setPostInsertEventListeners(
//				new PostInsertEventListener[0]);
//		ejb3Configuration.getEventListeners().setMergeEventListeners(
//				new MergeEventListener[] { new DefaultMergeEventListener() });
//		ejb3Configuration
//				.getEventListeners()
//				.setPreLoadEventListeners(
//						new PreLoadEventListener[] { new DefaultPreLoadEventListener() });
//		ejb3Configuration.getEventListeners().setPreUpdateEventListeners(
//				new PreUpdateEventListener[] { new ValidateEventListener() });
//		ejb3Configuration
//				.getEventListeners()
//				.setPostLoadEventListeners(
//						new PostLoadEventListener[] { new DefaultPostLoadEventListener() });
//		ejb3Configuration.getEventListeners().setPostUpdateEventListeners(
//				new PostUpdateEventListener[0]);
//		ejb3Configuration
//				.getEventListeners()
//				.setFlushEntityEventListeners(
//						new FlushEntityEventListener[] { new DefaultFlushEntityEventListener() });
//		ejb3Configuration.getEventListeners().setFlushEventListeners(
//				new FlushEventListener[] { new DefaultFlushEventListener() });
//		ejb3Configuration
//				.getEventListeners()
//				.setUpdateEventListeners(
//						new SaveOrUpdateEventListener[] { new DefaultSaveOrUpdateEventListener() });
//
//		configureAnnotedClasses(ejb3Configuration);
//
//		return ejb3Configuration;
//	}
//
//	protected abstract void configureAnnotedClasses(
//			Ejb3Configuration configuration);
//
//}