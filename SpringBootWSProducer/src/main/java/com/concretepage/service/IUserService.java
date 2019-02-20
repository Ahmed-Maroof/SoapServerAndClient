package com.concretepage.service;

import com.concretepage.entity.User;

public interface IUserService {

    User getUserById(Long id);
    User checkUserNameAndPassword (String username , String password);

}
