package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.IMetadata;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "metadata")
public class Metadata implements IMetadata {

    @Id
    @GeneratedValue
    private Long id;

    private String course;
    private List<String> settings;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCourse() {
        return course;
    }

    @Override
    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public List<String> getSettings() {
        return settings;
    }

    @Override
    public void setSettings(List<String> settings) {
        this.settings = settings;
    }

    @Override
    public void addSetting(String setting) {
        settings.add(setting);
    }
}
