package com.silicon.hub.firepay;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM user_table")
    void deleteAllUser();

    @Query("SELECT * FROM user_table WHERE userEmail == :email AND userPasswordHashed == :passwordHashed ")
    User checkLoginCredentials(String email, String passwordHashed);
}
