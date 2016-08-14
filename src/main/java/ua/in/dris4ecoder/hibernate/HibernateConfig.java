package ua.in.dris4ecoder.hibernate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Alex Korneyko on 13.08.2016 18:46.
 */
@Configuration
public class HibernateConfig {

    @Bean
    public ComboPooledDataSource comboPooledDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        dataSource.setDriverClass(properties.getProperty("jdbc.driver.class"));
        dataSource.setJdbcUrl(properties.getProperty("jdbc.url"));
        dataSource.setUser(properties.getProperty("jdbc.user"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));
        dataSource.setMinPoolSize(Integer.parseInt(properties.getProperty("jdbc.min.connection")));
        dataSource.setMaxPoolSize(Integer.parseInt(properties.getProperty("jdbc.max.connection")));
        dataSource.setAcquireIncrement(Integer.parseInt(properties.getProperty("jdbc.acquire.increment")));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(ComboPooledDataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("ua.in.dris4ecoder.hibernate.model");
        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        sessionFactoryBean.setHibernateProperties(properties);

        return sessionFactoryBean;
    }


    @Bean
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactoryBean) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean);

        return transactionManager;
    }
}
