package api.GetRequest.GetModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class Support {
    private String url;
    private String text;
}
