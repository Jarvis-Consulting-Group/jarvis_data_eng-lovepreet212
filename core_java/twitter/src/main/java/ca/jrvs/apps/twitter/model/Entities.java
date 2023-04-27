package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "hashtags",
        "user_mentions"
})
public class Entities {

    @JsonProperty("hashtags")
    private List<Hashtags> hashtags;
    @JsonProperty("user_mentions")
    private List<UserMentions> userMentions;

    @JsonGetter
    public List<Hashtags> getHashtags() {
        return hashtags;
    }

    @JsonSetter
    public void setHashtags(List<Hashtags> hashtags) {
        this.hashtags = hashtags;
    }

    @JsonGetter
    public List<UserMentions> getUserMentions() {
        return userMentions;
    }

    @JsonSetter
    public void setUserMentions(List<UserMentions> userMentions) {
        this.userMentions = userMentions;
    }
}
