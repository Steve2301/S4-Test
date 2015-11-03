package test;

import java.util.List;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.SQLTemplate;
import org.apache.cayenne.query.SelectQuery;

import at.fhv.itm14.fhvgis.persistence.cayenne.Device;

public class Main {

	public static void main(String[] args) {
        ServerRuntime cayenneRuntime = new ServerRuntime("at/fhv/itm14/fhvgis/persistence/cayenne/cayenne-project.xml");
        ObjectContext context = cayenneRuntime.getContext();
        SelectQuery select = new SelectQuery(Device.class); 
        List result = context.performQuery(select);
    }

}
