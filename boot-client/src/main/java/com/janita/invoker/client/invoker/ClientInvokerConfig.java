package com.janita.invoker.client.invoker;

import com.janita.invoker.server.service.IUserService;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpComponentsHttpInvokerRequestExecutor;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

/**
 * Created by Janita on 2017-03-24 15:52
 */
@Configuration
public class ClientInvokerConfig {

    @Bean
    @SuppressWarnings("deprecation")
    public HttpComponentsHttpInvokerRequestExecutor httpComponentsHttpInvokerRequestExecutor(){
        HttpComponentsHttpInvokerRequestExecutor bean = new HttpComponentsHttpInvokerRequestExecutor();
        ThreadSafeClientConnManager manager = new ThreadSafeClientConnManager();
        manager.setMaxTotal(100);

        HttpClient httpClient = new DefaultHttpClient(manager);
        bean.setHttpClient(httpClient);
        return bean;
    }

//    @Bean
//    public IUserService userService(){
//        HttpInvokerProxyFactoryBean bean = new HttpInvokerProxyFactoryBean();
//        bean.setServiceInterface(IUserService.class);
//        bean.setServiceUrl("http://localhost:9999/remote/userService");
//        bean.afterPropertiesSet();
//
//        return (IUserService) bean.getObject();
//    }

    @Bean
    public HttpInvokerProxyFactoryBean userService(){
        HttpInvokerProxyFactoryBean bean = new HttpInvokerProxyFactoryBean();
        bean.setServiceUrl("http://localhost:9999/remote/userService");
        bean.setServiceInterface(IUserService.class);
        bean.setHttpInvokerRequestExecutor(httpComponentsHttpInvokerRequestExecutor());

        return bean;
    }

}
