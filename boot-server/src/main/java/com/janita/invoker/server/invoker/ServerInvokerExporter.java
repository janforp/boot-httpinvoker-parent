package com.janita.invoker.server.invoker;

import com.janita.invoker.server.service.IUserService;
import com.janita.invoker.server.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

/**
 * Created by Janita on 2017-03-24 14:59
 */
@Configuration
public class ServerInvokerExporter {

    @Autowired(required = false)
    private IUserService userService;

    /**
     * name = "/remote/userService" 客户的的服务的url就是：
     * IP:PORT/remote/userService
     * @return
     */
    @Bean(name = "/remote/userService")
    public HttpInvokerServiceExporter httpInvokerServiceExporter(){
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(userService);
        exporter.setServiceInterface(IUserService.class);

        return exporter;
    }

    /**
     * springMVC中需要此配置
     * 但在此，上面的name = "/remote/userService"已经做了相同的事情
     */
//    @Bean
//    public SimpleUrlHandlerMapping handlerMapping(){
//        SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
//        Properties properties = new Properties();
//        properties.put("/userService",httpInvokerServiceExporter());
//        handlerMapping.setMappings(properties);
//
//        return handlerMapping;
//    }
}
