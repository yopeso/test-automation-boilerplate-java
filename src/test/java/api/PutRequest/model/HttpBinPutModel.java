package api.PutRequest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Map;

@Data
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpBinPutModel {
        private Map<String,String> args;
        private String data;
        private Map<String,String> files;
        private Map<String,String> form;
        private Map<String,String> headers;
        private Object json;
        private String origin;
        private String url;
    }
