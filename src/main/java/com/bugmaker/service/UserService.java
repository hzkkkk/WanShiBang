package com.bugmaker.service;

import java.util.List;
import com.bugmaker.entity.User;

/**
 * Created by kinthon on 17-6-23.
 */
public interface UserService {
    public boolean addUser(User user);

    public boolean login(User user);

    public List getAllUser();

    public User getUserById(int id);

    public boolean updateUser(User user);

    public boolean deleteUser(int id);
}