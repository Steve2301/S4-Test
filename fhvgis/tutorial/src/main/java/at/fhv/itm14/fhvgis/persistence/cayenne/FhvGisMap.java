package at.fhv.itm14.fhvgis.persistence.cayenne;

import at.fhv.itm14.fhvgis.persistence.cayenne.auto._FhvGisMap;

public class FhvGisMap extends _FhvGisMap {

    private static FhvGisMap instance;

    private FhvGisMap() {}

    public static FhvGisMap getInstance() {
        if(instance == null) {
            instance = new FhvGisMap();
        }

        return instance;
    }
}
