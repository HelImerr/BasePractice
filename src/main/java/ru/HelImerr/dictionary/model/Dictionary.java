package ru.HelImerr.dictionary.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@lombok.Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "code", nullable = false)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "description", nullable = false)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String id) {
        this.description = description;
    }

}
