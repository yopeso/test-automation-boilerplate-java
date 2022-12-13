package api.routes;

import api.interfaces.IRoutes;

public enum RegresInRoutes implements IRoutes {
    REGRESS_IN_API_BASE("https://reqres.in","/api"),
    REGRESS_IN_API_ALL_USERS(REGRESS_IN_API_BASE.absolute_url, "/users"),

    REGRESS_IN_API_USER(REGRESS_IN_API_ALL_USERS.absolute_url, "/2");
    private final String service_url;
    private final String endpoint_path;
    private final String absolute_url;

    RegresInRoutes(String service_url, String endpoint_path) {
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
