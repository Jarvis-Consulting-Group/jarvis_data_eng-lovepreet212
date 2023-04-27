package ca.jrvs.apps.twitter.model;

import java.util.List;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "id_str",
        "indices",
        "name",
        "screen_name"

})
public class UserMentions {
    @JsonProperty("id")
    private long id;
    @JsonProperty("id_str")
    private String id_str;
    @JsonProperty("indices")
    private int [] indices;
    @JsonProperty("name")
    
    private String name;
    @JsonProperty("screen_name")
    private String screenName;

    @JsonGetter
    public long getId() {
        return id;
    }
    @JsonSetter
    public void setId(long id) {
        this.id = id;
    }
    @JsonGetter
    public String getIdStr() {
        return id_str;
    }
    @JsonSetter
    public void setIdStr(String idStr) {
        this.id_str = idStr;
    }
    @JsonGetter
    public int[] getIndices() {
        return indices;
    }
    @JsonSetter
    public void setIndices(int[] indices) {
        this.indices = indices;
    }
    @JsonGetter
    public String getName() {
        return name;
    }
    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }
    @JsonGetter
    public String getScreenName() {
        return screenName;
    }
    @JsonSetter
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
}
