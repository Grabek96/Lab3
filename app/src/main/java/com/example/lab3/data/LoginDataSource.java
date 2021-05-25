package com.example.lab3.data;

import com.example.lab3.data.model.LoggedInUser;
import com.example.lab3.ui.login.LoginActivity;

import java.io.IOException;
import java.util.UUID;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {if (LoginActivity.tab[0].equals(username) && LoginActivity.tab[1].equals(password)){
            return new Result.Success(new LoggedInUser("1","Witaj! "));
        }
        else
        {
            return new Result.Success(new LoggedInUser(UUID.randomUUID().toString(), " " + username+ " Twoje konto zostało utworzone. "  ));
        }
            // TODO: handle loggedInUser authentication


        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}