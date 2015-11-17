package at.fhv.itm14.fhvgis.webservice.app.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.URL;

/**
 * Author: Philip Heimböck
 * Date: 05.11.15.
 */
@Path("/app")
public class AppController {

    @Path("version")
    @GET
    public Response getVersions() {

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(AppController.class.getResourceAsStream("/versions.json")));

            String content = "";
            String line;
            while ((line = fileReader.readLine()) != null) {
                content += line;
            }

            return Response.status(200)
                    .entity(content)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();

        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @Path("download/{version}")
    @GET
    public Response download(@PathParam("version") String version) {

        File file = new File("/home/webuser/apk/gps_hawk_" + version + ".apk");
        //File file = new File("/Users/philipheimbockprivat/Projects/FHVGIS/fhvgis/webservice/WebContent/gps_hawk_" + version + ".apk");
        if(file.exists()) {

            return Response.status(200)
                    .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"")
                    .entity(file)
                    .type("application/vnd.android.package-archive")
                    .build();

        }

        return Response.status(500).build();
    }
}
