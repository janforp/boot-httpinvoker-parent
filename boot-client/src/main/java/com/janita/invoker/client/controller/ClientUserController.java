package com.janita.invoker.client.controller;

import com.janita.invoker.server.bean.User;
import com.janita.invoker.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-03-24 14:40
 */
@RequestMapping("/client")
@RestController
public class ClientUserController {

    /**
     * 若直接注入则：
     * Field userService in com.janita.invoker.client.controller.ClientUserController required a bean of type 'com.janita.invoker.server.service.IUserService' that could not be found.
     * 需要类似springmvc中使用那样配置
     */
    @Autowired
    private IUserService userService;

    @GetMapping("/fetch")
    public User getUserById(Long userId){
        return userService.getUserById(userId);
    }
}
