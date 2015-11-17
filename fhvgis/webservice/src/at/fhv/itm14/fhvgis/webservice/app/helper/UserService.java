package at.fhv.itm14.fhvgis.webservice.app.helper;

import at.fhv.itm14.fhvgis.domain.User;
import at.fhv.itm14.fhvgis.webservice.app.exceptions.BadRequestException;
import at.fhv.itm14.fhvgis.webservice.app.exceptions.WrongCredentialsException;
import com.sun.jersey.core.util.Base64;

import java.util.HashMap;
import java.util.UUID;

/**
 * Author: Philip Heimböck
 * Date: 05.11.15.
 */
public class UserService {

    private static final HashMap<String, User> users;

    static {
        users = new HashMap<>();
        users.put("user1", new User("user1", "1234"));
        users.put("user2", new User("user2", "1234"));
        users.put("user3", new User("user3", "1234"));
    }

    /**
     * Check if the credentials for the user are ok
     *
     * @param authorization Basic credentials
     * @return The user
     * @throws WrongCredentialsException
     * @throws BadRequestException
     */
    public User checkLogin(String authorization) throws WrongCredentialsException, BadRequestException {
        String login = new String(Base64.decode(authorization.replaceFirst("(?i)basic ", "")));
        int seperatorIndex = login.indexOf(':');

        if (seperatorIndex >= 0) {
            String username = login.substring(0, seperatorIndex);
            String pass = login.substring(seperatorIndex + 1, login.length());

            User user = findUser(username);
            if (user == null || !user.getPassword().equals(pass)) {
                throw new WrongCredentialsException("The credentials are wrong");
            }

            return user;
        }
        throw new BadRequestException();
    }

    /**
     * Checks if the user is existing
     *
     * @param username
     * @return
     */
    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    /**
     * Creates a new token for the user
     *
     * @param user
     * @param deviceId
     * @return
     */
    public String createToken(User user, String deviceId) {
        // Todo: Connect the token to the device and persist it
        return UUID.randomUUID().toString();
    }

    /**
     * Creates a new user entity
     *
     * @param username
     * @param password
     * @return
     */
    public User register(String username, String password) throws WrongCredentialsException {
        // Check if user is already existing
        if(userExists(username)) {
            throw new WrongCredentialsException("User is already existing!");
        }

        // Create a new user
        User user = new User(username, password);
        // Todo: Persist it
        users.put(username, user);

        return user;
    }

    /**
     * Looks up the user based on its name
     *
     * @param user
     * @return
     */
    private User findUser(String user) {
        return users.get(user);
    }
}
