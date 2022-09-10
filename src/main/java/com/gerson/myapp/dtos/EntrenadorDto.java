package com.gerson.myapp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class EntrenadorDto implements Serializable {

    @JsonProperty(value = "id", index = 1)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty(value = "fechaNac", index = 2)
    private Date fechaNac;
}
