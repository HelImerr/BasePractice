package ru.HelImerr.dictionary.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;


@Entity
@lombok.Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Table(name ="data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    @Schema(hidden = true)
    private Long id;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    @Column(name = "dictionary_id")
    @Schema(name = "dictionary_id", example = "1", required = true)
    private Long dictionary_id;

    public Long getDictionary_id(){
        return dictionary_id;
    }
    public void setDictionary_id(Long id){
        this.dictionary_id = dictionary_id;
    }

    @Column(name = "code", nullable = false)
    @Schema(name = "code", example = "test", required = true)
    private String code;

    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Column(name = "value", nullable = false)
    @Schema(name = "test", example = "test", required = true)
    private String value;

    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value = value;
    }


}
