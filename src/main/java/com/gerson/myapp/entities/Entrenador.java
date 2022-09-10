package com.gerson.myapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "entrenadores")
@Data
@NoArgsConstructor
public class Entrenador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "es requerido")
    @Size(min = 4, max = 12, message = "el tamaño tiene que estar entre 4 y 12")
    @Column(name="nombre")
    private String nombre;

    @NotEmpty(message = "es requerido")
    @Column(name="foto")
    private String foto;


    @NotNull(message = "es requerido")
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    @Email(message = "Error en formato")
    @NotEmpty(message = "es requerido")
    @Column(name="email")
    private String email;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;


    @PrePersist
    public void prePersist() {
        fechaCreacion = new Date();
    }
}
