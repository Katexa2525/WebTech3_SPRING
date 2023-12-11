package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// класс конфигурации
@Configuration // сообщает Spring, что это файл конфигурации
@ComponentScan("spring.config") //говорит Spring искать классы конфигурации в пакете "spring.config"
public class WebMvcConfig {

	@Bean(name = "viewResolver") //В этом классе создаём bean-компонент, который распознаёт представления (View), с помощью указания префикса и суффикса для этих представлений
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
