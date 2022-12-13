package api.PutRequest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegresInEditModel {
    private String updatedAt;
}
