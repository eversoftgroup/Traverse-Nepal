package io.github.traverse_nepal.entities;

import com.google.gson.annotations.SerializedName;

public class Contributors {

    @SerializedName("username")
    private String username;

    @SerializedName("url")
    private String url;

    @SerializedName("avatar_url")
    private String avatar_url;

    @SerializedName("contributions")
    private String contributions;

    @SerializedName("repository_name")
    private String repository_name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getContributions() {
        return contributions;
    }

    public void setContributions(String contributions) {
        this.contributions = contributions;
    }

    public String getRepository_name() {
        return repository_name;
    }

    public void setRepository_name(String repository_name) {
        this.repository_name = repository_name;
    }
}
