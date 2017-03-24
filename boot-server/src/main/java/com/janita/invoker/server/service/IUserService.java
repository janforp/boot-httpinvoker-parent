package com.janita.invoker.server.service;

import com.janita.invoker.server.bean.User;

/**
 * Created by Janita on 2017-03-24 14:33
 */
public interface IUserService {

    User getUserById(Long userId);
}
