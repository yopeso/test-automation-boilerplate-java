package api.routes;

import api.interfaces.IRoutes;

public enum OpenHttpRoutes implements IRoutes {
    OPEN_HTTP_BIN_BASE("https://httpbin.org",""),

    OPEN_HTTP_BIN_POST(OPEN_HTTP_BIN_BASE.absolute_url,"/post"),

    OPEN_HTTP_BIN_PUT(OPEN_HTTP_BIN_BASE.absolute_url,"/put");

    private final String service_url;
    private final String endpoint_path;
    private final String absolute_url;

    OpenHttpRoutes(String service_url, String endpoint_path) {
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
