package fr.nexa.billquote.activity.data;

import fr.nexa.billquote.activity.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
//            LoggedInUser fakeUser =
//                    new LoggedInUser(
//                            java.util.UUID.randomUUID().toString(),
//                            "Jane Doe");
//            return new Result.Success<>(fakeUser);
            LoggedInUser fakeUser = new LoggedInUser("123456", "Odeya");
            if (username.trim().equals("odeya@gmail.com") && password.trim().equals("odeyaa")) {
                return new Result.Success<>(fakeUser);
            } else {
                return new Result.Error(new IOException("Erreur d'authentification !"));
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Erreur d'authentification", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}