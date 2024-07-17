package ru.HelImerr.dictionary.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(name = "id", hidden = true)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "code", nullable = false)
    @Schema(name = "code", example = "test", required = true)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "description", nullable = false)
    @Schema(name = "description", example = "test", required = true)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String id) {
        this.description = description;
    }

}
