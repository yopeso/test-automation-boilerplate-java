package api.GetRequest.GetModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestUserModel {
        public int id;
        public String name;
        public String email;
        public String gender;
        public String status;

        @Override
        public String toString() {
                return "GoRestUserModel{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", email='" + email + '\'' +
                        ", gender='" + gender + '\'' +
                        ", status='" + status + '\'' +
                        '}';
        }
}
