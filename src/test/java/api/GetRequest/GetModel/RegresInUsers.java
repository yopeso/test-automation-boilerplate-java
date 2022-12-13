package api.GetRequest.GetModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;

@Data
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegresInUsers {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private ArrayList<Datas> data;
    private Support support;
}
