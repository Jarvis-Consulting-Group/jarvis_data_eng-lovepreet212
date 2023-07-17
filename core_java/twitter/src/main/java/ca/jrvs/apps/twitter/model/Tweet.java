package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.RequestHeader;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "created_at",
        "id",
        "id_str",
        "text",
        "entities",
        "coordinates",
        "retweet_count",
        "favorite_count",
        "favorited",
        "retweeted"
})
public class Tweet {

    @JsonProperty("created_at")
    private String created_at;
    @JsonProperty("id")
    private long id;
    @JsonProperty("id_str")
    private String id_str;
    @JsonProperty("text")
    private String text;
    @JsonProperty("entities")
    private Entities entities;
    @JsonProperty("coordinates")
    private Coordinates coordinates;
    @JsonProperty("retweet_count")
    private int retweet_count;
    @JsonProperty("favorite_count")
    private Integer favorite_count;
    @JsonProperty("favorited")
    private Boolean favorited;
    @JsonProperty("retweeted")
    private Boolean retweeted;
    @JsonProperty
    public String getCreatedAt() {
        return created_at;
    }
    @JsonProperty
    public void setCreatedAt(String createdAt) {
        this.created_at = createdAt;
    }
    @JsonProperty
    public long getId() {
        return id;
    }
    @JsonProperty
    public void setId(long id) {
        this.id = id;
    }
    @JsonProperty
    public String getIdStr() {
        return id_str;
    }
    @JsonProperty
    public void setIdStr(String idStr) {
        this.id_str = idStr;
    }
    @JsonProperty
    public String getText() {
        return text;
    }
    @JsonProperty
    public void setText(String text) {
        this.text = text;
    }
    @JsonProperty
    public Entities getEntities() {
        return entities;
    }
    @JsonProperty
    public void setEntities(Entities entities) {
        this.entities = entities;
    }
    @JsonProperty
    public Coordinates getCoordinates() {
        return coordinates;
    }
    @JsonProperty
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    @JsonProperty
    public int getRetweetCount() {
        return retweet_count;
    }
    @JsonProperty
    public void setRetweetCount(int retweetCount) {
        this.retweet_count = retweetCount;
    }
    @JsonProperty
    public Integer getFavCount() {
        return favorite_count;
    }
    @JsonProperty
    public void setFavCount(Integer favCount) {
        this.favorite_count = favCount;
    }
    @JsonProperty
    public Boolean getFavorited() {
        return favorited;
    }
    @JsonProperty
    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }
    @JsonProperty
    public Boolean getRetweeted() {
        return retweeted;
    }
    @JsonProperty
    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    public Tweet(String text,Coordinates coordinates) {
        this.text = text;
        this.coordinates = coordinates;
    }

    public Tweet() {
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "created_at='" + created_at + '\'' +
                ", id=" + id +
                ", idStr='" + id_str + '\'' +
                ", text='" + text + '\'' +
                ", entities=" + entities +
                ", coordinates=" + coordinates +
                ", retweet_count=" + retweet_count +
                ", favorite_count=" + favorite_count +
                ", favorited=" + favorited +
                ", retweeted=" + retweeted +
                '}';
    }
}