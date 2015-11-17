package at.fhv.itm14.fhvgis.webservice.app.controller;

import at.fhv.itm14.fhvgis.domain.User;
import at.fhv.itm14.fhvgis.webservice.app.exceptions.BadRequestException;
import at.fhv.itm14.fhvgis.webservice.app.exceptions.WrongCredentialsException;
import at.fhv.itm14.fhvgis.webservice.app.helper.UserService;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Author: Philip Heimböck
 * Date: 05.11.15.
 */
@Path("/app/users")
public class UserController {

    private UserService userService = new UserService();

    @Path("exists/{username}")
    @GET
    public Response userExists(@PathParam("username") String username) {
        boolean exists = userService.userExists(username);

        return Response.status(exists ? Response.Status.OK : Response.Status.NOT_FOUND)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }

    @Path("login/{deviceId}")
    @GET
    public Response login(@HeaderParam("Authorization") String authorization, @PathParam("deviceId") String deviceId) {

        String token = null;
        boolean success = true;
        Response.Status status = Response.Status.OK;

        try {
            // Check the credentials
            User user = userService.checkLogin(authorization);

            // Generate and persist token!
            token = userService.createToken(user, deviceId);

        } catch (WrongCredentialsException ex) {
            status = Response.Status.UNAUTHORIZED;
            success = false;

        } catch (BadRequestException e) {
            status = Response.Status.BAD_REQUEST;
            success = false;
        }

        return Response.status(status)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new JSONObject().put("success", success).put("token", token).toString())
                .build();
    }

    @Path("register")
    @POST
    public Response register(@FormParam("username") String username, @FormParam("password") String password, @FormParam("deviceId") String deviceId) {

        String token = null;
        boolean success = true;
        Response.Status status = Response.Status.OK;

        try {
            if(username == null || password == null || deviceId == null) {
                throw new BadRequestException("Missing parameters");
            }

            // Create the user
            User user = userService.register(username, password);

            // Generate and persist token!
            token = userService.createToken(user, deviceId);

        } catch (WrongCredentialsException | BadRequestException e) {

            status = Response.Status.BAD_REQUEST;
            success = false;
        }

        return Response.status(status)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new JSONObject().put("success", success).put("token", token).toString())
                .build();
    }
}
