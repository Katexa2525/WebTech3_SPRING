package spring.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Для работы с Spring Data JPA надо создать два beans-компонента: EntityManagerFactory и JpaTransactionManager.
//Поэтому создаю еще один конфигурационный класс JpaConfig
 
@Configuration
//@EnableJpaRepositories(basePackages = {"spring.model"})
@EnableTransactionManagement
public class JpaConfig {
	
	// метод создаёт экземпляр EntityManagerFactory для управления Persistence Unit моей FilmsDB (это имя указано в persistence.xml)
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("FilmsDB");
          
        return factoryBean;
    }
    
    //метод создаёт экземпляр JpaTransactionManager для EntityManagerFactory, созданный методом ранее
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
          
        return transactionManager;
    } 
}
