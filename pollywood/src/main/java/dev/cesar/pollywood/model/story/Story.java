package dev.cesar.pollywood.model.story;

import java.util.List;

public class Story {
    private String title;
    private List<String> tags;
    private List<String> warning;
    private String summary;
    private List<Character> characters;
    private List<Location> locations;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getWarning() {
        return warning;
    }

    public void setWarning(List<String> warning) {
        this.warning = warning;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
