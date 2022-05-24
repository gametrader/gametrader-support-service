package com.gametrader.gametradersupportservice.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.gametrader.gametradersupportservice.dto.IssueDto;
import com.gametrader.gametradersupportservice.entity.IssueEntity;
import com.gametrader.gametradersupportservice.mapper.IssueMapper;
import com.gametrader.gametradersupportservice.model.Category;
import com.gametrader.gametradersupportservice.repository.IssueRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {IssueServiceImpl.class})
@ExtendWith(SpringExtension.class)
class IssueServiceImplTest {
    @MockBean
    private IssueMapper issueMapper;

    @MockBean
    private IssueRepository issueRepository;

    @Autowired
    private IssueServiceImpl issueServiceImpl;

    /**
     * Method under test: {@link IssueServiceImpl#createIssue(IssueDto)}
     */
    @Test
    void testCreateIssue() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: entityManagerFactory defined in org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1804)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:421)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at com.zaxxer.hikari.util.DriverDataSource.<init>(DriverDataSource.java:110)
        //       at com.zaxxer.hikari.pool.PoolBase.initializeDataSource(PoolBase.java:331)
        //       at com.zaxxer.hikari.pool.PoolBase.<init>(PoolBase.java:114)
        //       at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:108)
        //       at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112)
        //       at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122)
        //       at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:181)
        //       at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:44)
        //       at org.hibernate.tool.schema.internal.exec.ImprovedExtractionContextImpl.getJdbcConnection(ImprovedExtractionContextImpl.java:63)
        //       at org.hibernate.tool.schema.extract.spi.ExtractionContext.getQueryResults(ExtractionContext.java:43)
        //       at org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorLegacyImpl.extractMetadata(SequenceInformationExtractorLegacyImpl.java:39)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.initializeSequences(DatabaseInformationImpl.java:66)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.<init>(DatabaseInformationImpl.java:60)
        //       at org.hibernate.tool.schema.internal.Helper.buildDatabaseInformation(Helper.java:183)
        //       at org.hibernate.tool.schema.internal.AbstractSchemaValidator.doValidation(AbstractSchemaValidator.java:68)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:200)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:81)
        //       at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        //       at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        //       at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
        //       at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:58)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   See https://diff.blue/R026 to resolve this issue.

        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");
        when(this.issueRepository.save((IssueEntity) any())).thenReturn(issueEntity);

        IssueEntity issueEntity1 = new IssueEntity();
        issueEntity1.setAuthorId(123L);
        issueEntity1.setCategory(Category.BUG);
        issueEntity1.setContent("Not all who wander are lost");
        issueEntity1.setId(123L);
        issueEntity1.setIsResolved(true);
        issueEntity1.setTitle("Dr");
        when(this.issueMapper.dtoToEntity((IssueDto) any())).thenReturn(issueEntity1);
        this.issueServiceImpl.createIssue(new IssueDto());
        verify(this.issueRepository).save((IssueEntity) any());
        verify(this.issueMapper).dtoToEntity((IssueDto) any());
    }

    /**
     * Method under test: {@link IssueServiceImpl#updateIssue(IssueDto)}
     */
    @Test
    void testUpdateIssue() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: entityManagerFactory defined in org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1804)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:421)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at com.zaxxer.hikari.util.DriverDataSource.<init>(DriverDataSource.java:110)
        //       at com.zaxxer.hikari.pool.PoolBase.initializeDataSource(PoolBase.java:331)
        //       at com.zaxxer.hikari.pool.PoolBase.<init>(PoolBase.java:114)
        //       at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:108)
        //       at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112)
        //       at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122)
        //       at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:181)
        //       at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:44)
        //       at org.hibernate.tool.schema.internal.exec.ImprovedExtractionContextImpl.getJdbcConnection(ImprovedExtractionContextImpl.java:63)
        //       at org.hibernate.tool.schema.extract.spi.ExtractionContext.getQueryResults(ExtractionContext.java:43)
        //       at org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorLegacyImpl.extractMetadata(SequenceInformationExtractorLegacyImpl.java:39)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.initializeSequences(DatabaseInformationImpl.java:66)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.<init>(DatabaseInformationImpl.java:60)
        //       at org.hibernate.tool.schema.internal.Helper.buildDatabaseInformation(Helper.java:183)
        //       at org.hibernate.tool.schema.internal.AbstractSchemaValidator.doValidation(AbstractSchemaValidator.java:68)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:200)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:81)
        //       at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        //       at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        //       at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
        //       at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:58)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   See https://diff.blue/R026 to resolve this issue.

        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");
        when(this.issueRepository.save((IssueEntity) any())).thenReturn(issueEntity);

        IssueEntity issueEntity1 = new IssueEntity();
        issueEntity1.setAuthorId(123L);
        issueEntity1.setCategory(Category.BUG);
        issueEntity1.setContent("Not all who wander are lost");
        issueEntity1.setId(123L);
        issueEntity1.setIsResolved(true);
        issueEntity1.setTitle("Dr");
        when(this.issueMapper.dtoToEntity((IssueDto) any())).thenReturn(issueEntity1);
        this.issueServiceImpl.updateIssue(new IssueDto());
        verify(this.issueRepository).save((IssueEntity) any());
        verify(this.issueMapper).dtoToEntity((IssueDto) any());
    }

    /**
     * Method under test: {@link IssueServiceImpl#getAllIssues()}
     */
    @Test
    void testGetAllIssues() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: entityManagerFactory defined in org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1804)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:421)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at com.zaxxer.hikari.util.DriverDataSource.<init>(DriverDataSource.java:110)
        //       at com.zaxxer.hikari.pool.PoolBase.initializeDataSource(PoolBase.java:331)
        //       at com.zaxxer.hikari.pool.PoolBase.<init>(PoolBase.java:114)
        //       at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:108)
        //       at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112)
        //       at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122)
        //       at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:181)
        //       at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:44)
        //       at org.hibernate.tool.schema.internal.exec.ImprovedExtractionContextImpl.getJdbcConnection(ImprovedExtractionContextImpl.java:63)
        //       at org.hibernate.tool.schema.extract.spi.ExtractionContext.getQueryResults(ExtractionContext.java:43)
        //       at org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorLegacyImpl.extractMetadata(SequenceInformationExtractorLegacyImpl.java:39)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.initializeSequences(DatabaseInformationImpl.java:66)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.<init>(DatabaseInformationImpl.java:60)
        //       at org.hibernate.tool.schema.internal.Helper.buildDatabaseInformation(Helper.java:183)
        //       at org.hibernate.tool.schema.internal.AbstractSchemaValidator.doValidation(AbstractSchemaValidator.java:68)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:200)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:81)
        //       at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        //       at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        //       at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
        //       at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:58)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   See https://diff.blue/R026 to resolve this issue.

        when(this.issueRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(this.issueServiceImpl.getAllIssues().isEmpty());
        verify(this.issueRepository).findAll();
    }

    /**
     * Method under test: {@link IssueServiceImpl#getIssueById(Long)}
     */
    @Test
    void testGetIssueById() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: entityManagerFactory defined in org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1804)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:421)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at com.zaxxer.hikari.util.DriverDataSource.<init>(DriverDataSource.java:110)
        //       at com.zaxxer.hikari.pool.PoolBase.initializeDataSource(PoolBase.java:331)
        //       at com.zaxxer.hikari.pool.PoolBase.<init>(PoolBase.java:114)
        //       at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:108)
        //       at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112)
        //       at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122)
        //       at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:181)
        //       at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:44)
        //       at org.hibernate.tool.schema.internal.exec.ImprovedExtractionContextImpl.getJdbcConnection(ImprovedExtractionContextImpl.java:63)
        //       at org.hibernate.tool.schema.extract.spi.ExtractionContext.getQueryResults(ExtractionContext.java:43)
        //       at org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorLegacyImpl.extractMetadata(SequenceInformationExtractorLegacyImpl.java:39)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.initializeSequences(DatabaseInformationImpl.java:66)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.<init>(DatabaseInformationImpl.java:60)
        //       at org.hibernate.tool.schema.internal.Helper.buildDatabaseInformation(Helper.java:183)
        //       at org.hibernate.tool.schema.internal.AbstractSchemaValidator.doValidation(AbstractSchemaValidator.java:68)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:200)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:81)
        //       at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        //       at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        //       at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
        //       at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:58)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   See https://diff.blue/R026 to resolve this issue.

        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");
        when(this.issueRepository.getById((Long) any())).thenReturn(issueEntity);
        IssueDto issueDto = new IssueDto();
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(issueDto);
        assertSame(issueDto, this.issueServiceImpl.getIssueById(123L));
        verify(this.issueRepository).getById((Long) any());
        verify(this.issueMapper).entityToDto((IssueEntity) any());
    }

    /**
     * Method under test: {@link IssueServiceImpl#getIssuesByCategory(Category)}
     */
    @Test
    void testGetIssuesByCategory() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: entityManagerFactory defined in org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1804)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:421)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at com.zaxxer.hikari.util.DriverDataSource.<init>(DriverDataSource.java:110)
        //       at com.zaxxer.hikari.pool.PoolBase.initializeDataSource(PoolBase.java:331)
        //       at com.zaxxer.hikari.pool.PoolBase.<init>(PoolBase.java:114)
        //       at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:108)
        //       at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112)
        //       at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122)
        //       at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:181)
        //       at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:44)
        //       at org.hibernate.tool.schema.internal.exec.ImprovedExtractionContextImpl.getJdbcConnection(ImprovedExtractionContextImpl.java:63)
        //       at org.hibernate.tool.schema.extract.spi.ExtractionContext.getQueryResults(ExtractionContext.java:43)
        //       at org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorLegacyImpl.extractMetadata(SequenceInformationExtractorLegacyImpl.java:39)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.initializeSequences(DatabaseInformationImpl.java:66)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.<init>(DatabaseInformationImpl.java:60)
        //       at org.hibernate.tool.schema.internal.Helper.buildDatabaseInformation(Helper.java:183)
        //       at org.hibernate.tool.schema.internal.AbstractSchemaValidator.doValidation(AbstractSchemaValidator.java:68)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:200)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:81)
        //       at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        //       at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        //       at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
        //       at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:58)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   See https://diff.blue/R026 to resolve this issue.

        when(this.issueRepository.getAllByCategory((Category) any())).thenReturn(new ArrayList<>());
        assertTrue(this.issueServiceImpl.getIssuesByCategory(Category.BUG).isEmpty());
        verify(this.issueRepository).getAllByCategory((Category) any());
    }

    /**
     * Method under test: {@link IssueServiceImpl#getIssuesByCategory(Category)}
     */
    @Test
    void testGetIssuesByCategory2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: entityManagerFactory defined in org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1804)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:421)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at com.zaxxer.hikari.util.DriverDataSource.<init>(DriverDataSource.java:110)
        //       at com.zaxxer.hikari.pool.PoolBase.initializeDataSource(PoolBase.java:331)
        //       at com.zaxxer.hikari.pool.PoolBase.<init>(PoolBase.java:114)
        //       at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:108)
        //       at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112)
        //       at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122)
        //       at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:181)
        //       at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:44)
        //       at org.hibernate.tool.schema.internal.exec.ImprovedExtractionContextImpl.getJdbcConnection(ImprovedExtractionContextImpl.java:63)
        //       at org.hibernate.tool.schema.extract.spi.ExtractionContext.getQueryResults(ExtractionContext.java:43)
        //       at org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorLegacyImpl.extractMetadata(SequenceInformationExtractorLegacyImpl.java:39)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.initializeSequences(DatabaseInformationImpl.java:66)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.<init>(DatabaseInformationImpl.java:60)
        //       at org.hibernate.tool.schema.internal.Helper.buildDatabaseInformation(Helper.java:183)
        //       at org.hibernate.tool.schema.internal.AbstractSchemaValidator.doValidation(AbstractSchemaValidator.java:68)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:200)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:81)
        //       at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        //       at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        //       at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
        //       at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:58)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   See https://diff.blue/R026 to resolve this issue.

        when(this.issueRepository.getAllByCategory((Category) any())).thenReturn(new ArrayList<>());
        assertTrue(this.issueServiceImpl.getIssuesByCategory(Category.PAYMENTS).isEmpty());
        verify(this.issueRepository).getAllByCategory((Category) any());
    }

    /**
     * Method under test: {@link IssueServiceImpl#getIssuesByAuthorId(Long)}
     */
    @Test
    void testGetIssuesByAuthorId() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: entityManagerFactory defined in org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1804)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:421)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at com.zaxxer.hikari.util.DriverDataSource.<init>(DriverDataSource.java:110)
        //       at com.zaxxer.hikari.pool.PoolBase.initializeDataSource(PoolBase.java:331)
        //       at com.zaxxer.hikari.pool.PoolBase.<init>(PoolBase.java:114)
        //       at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:108)
        //       at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112)
        //       at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122)
        //       at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:181)
        //       at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:44)
        //       at org.hibernate.tool.schema.internal.exec.ImprovedExtractionContextImpl.getJdbcConnection(ImprovedExtractionContextImpl.java:63)
        //       at org.hibernate.tool.schema.extract.spi.ExtractionContext.getQueryResults(ExtractionContext.java:43)
        //       at org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorLegacyImpl.extractMetadata(SequenceInformationExtractorLegacyImpl.java:39)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.initializeSequences(DatabaseInformationImpl.java:66)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.<init>(DatabaseInformationImpl.java:60)
        //       at org.hibernate.tool.schema.internal.Helper.buildDatabaseInformation(Helper.java:183)
        //       at org.hibernate.tool.schema.internal.AbstractSchemaValidator.doValidation(AbstractSchemaValidator.java:68)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:200)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:81)
        //       at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        //       at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        //       at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
        //       at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:58)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   See https://diff.blue/R026 to resolve this issue.

        when(this.issueRepository.getAllByAuthorId((Long) any())).thenReturn(new ArrayList<>());
        assertTrue(this.issueServiceImpl.getIssuesByAuthorId(123L).isEmpty());
        verify(this.issueRepository).getAllByAuthorId((Long) any());
    }

    /**
     * Method under test: {@link IssueServiceImpl#getUnresolvedIssues()}
     */
    @Test
    void testGetUnresolvedIssues() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: entityManagerFactory defined in org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1804)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:421)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept jdbcUrl, jdbc:${DATABASE_URL}
        //       at com.zaxxer.hikari.util.DriverDataSource.<init>(DriverDataSource.java:110)
        //       at com.zaxxer.hikari.pool.PoolBase.initializeDataSource(PoolBase.java:331)
        //       at com.zaxxer.hikari.pool.PoolBase.<init>(PoolBase.java:114)
        //       at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:108)
        //       at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112)
        //       at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122)
        //       at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:181)
        //       at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:44)
        //       at org.hibernate.tool.schema.internal.exec.ImprovedExtractionContextImpl.getJdbcConnection(ImprovedExtractionContextImpl.java:63)
        //       at org.hibernate.tool.schema.extract.spi.ExtractionContext.getQueryResults(ExtractionContext.java:43)
        //       at org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorLegacyImpl.extractMetadata(SequenceInformationExtractorLegacyImpl.java:39)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.initializeSequences(DatabaseInformationImpl.java:66)
        //       at org.hibernate.tool.schema.extract.internal.DatabaseInformationImpl.<init>(DatabaseInformationImpl.java:60)
        //       at org.hibernate.tool.schema.internal.Helper.buildDatabaseInformation(Helper.java:183)
        //       at org.hibernate.tool.schema.internal.AbstractSchemaValidator.doValidation(AbstractSchemaValidator.java:68)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:200)
        //       at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:81)
        //       at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        //       at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        //       at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
        //       at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:58)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        //       at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$invokeInitMethods$5(AbstractAutowireCapableBeanFactory.java:1854)
        //       at java.security.AccessController.doPrivileged(Native Method)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        //       at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        //       at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
        //       at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
        //       at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
        //       at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:136)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
        //   See https://diff.blue/R026 to resolve this issue.

        when(this.issueRepository.getAllByIsResolvedFalse()).thenReturn(new ArrayList<>());
        assertTrue(this.issueServiceImpl.getUnresolvedIssues().isEmpty());
        verify(this.issueRepository).getAllByIsResolvedFalse();
    }
}

