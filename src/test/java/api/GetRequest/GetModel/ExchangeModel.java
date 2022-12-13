package api.GetRequest.GetModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Map;

@Data
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeModel {
private String result;
private String provider;
private String documentation;
private String terms_of_use;
private String time_last_update_unix;
private String time_last_update_utc;
private String time_next_update_unix;
private String time_next_update_utc;
private String time_eol_unix;
private String base_code;
private Map<String,String> rates;
}
