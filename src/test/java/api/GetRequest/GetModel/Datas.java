package api.GetRequest.GetModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class Datas {
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
}
