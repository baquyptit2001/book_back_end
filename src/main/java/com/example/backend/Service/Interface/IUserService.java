package com.example.backend.Service.Interface;

import com.example.backend.Model.User;
import com.example.backend.Record.UserRecord;

import java.util.List;

public interface IUserService {
    User add(User user);
    List<UserRecord> getAllUsers();
    void delete(String email);
    User getUser(String email);
    User update(User user);
}
