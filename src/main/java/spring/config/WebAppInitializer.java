package spring.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//Для использования Spring MVC в приложении, надо зарегистрировать Spring Dispatcher Servlet при запуске приложения, написав следующий класс
public class WebAppInitializer implements WebApplicationInitializer {

	//Метод onStartup() этого класса будет автоматически вызываться сервлетом при загрузке приложения. 
	//Spring Dispatcher Servlet обарабатывает все запросы cопоставляя URL "/" и ищет конфигурацию в классе WebMvcConfig
	//@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(WebMvcConfig.class);
          
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
