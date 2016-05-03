package ru.kpfu.itis.lzakharov.barbershop.domain.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("ru.kpfu.itis.lzakharov.barbershop")
@EnableJpaRepositories("ru.kpfu.itis.lzakharov.barbershop.domain.repository")
public class PersistenceContext {
    private static final String HIKARI_PROPERTIES = "hikari.properties";
    private static final String HIBERNATE_PROPERTIES = "hibernate.properties";
    private static final String ENTITY_PACKAGES = "ru.kpfu.itis.lzakharov.barbershop.domain.model";

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        Properties hikariProperties = new Properties();
        try {
            hikariProperties.load(PersistenceContext.class.getClassLoader().getResourceAsStream(HIKARI_PROPERTIES));
        } catch (IOException e) {
            // TODO: handle exception
        }
        return new HikariDataSource(new HikariConfig(hikariProperties));
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);

        Properties jpaProperties = new Properties();

        try {
            jpaProperties.load(PersistenceContext.class.getClassLoader().getResourceAsStream(HIBERNATE_PROPERTIES));
        } catch (IOException e) {
            // TODO: handle exception
        }

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }
}
