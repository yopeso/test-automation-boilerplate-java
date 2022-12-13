package api.routes;

import api.interfaces.IRoutes;

public enum OpenEnAirRoutes implements IRoutes {

    OPEN_ER_AIR_BASE("https://open.er-api.com","/v6/latest"),

    OPEN_ER_AIR_USD(OPEN_ER_AIR_BASE.absolute_url, "/USD"),

    OPEN_ER_AIR_EUR(OPEN_ER_AIR_BASE.absolute_url, "/EUR");
    private final String service_url;
    private final String endpoint_path;
    private final String absolute_url;

    OpenEnAirRoutes(String service_url, String endpoint_path) {
        this.service_url = service_url;
        this.endpoint_path = endpoint_path;
        this.absolute_url = service_url + endpoint_path;
    }

    public String service_url() {
        return service_url;
    }

    public String endpoint_path() {
        return endpoint_path;
    }

    public String absolute_url() {
        return absolute_url;
    }

    @Override
    public String field_name() {
        return this.name();
    }
}
