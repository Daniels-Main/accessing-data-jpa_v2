package com.example.accessingdatajpa;

import javax.persistence.*;

/**
 * Created by: Daniels
 * Date: 14/05/2021
 * Description:
 */
@Entity
@Table(name = "Alumnos")
public class AlumnoEntity {
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "edad")
    private int edad;

    protected AlumnoEntity() {}

    public AlumnoEntity( String nombre, int edad) {
        super();
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return String.format(
                "Alumno[id=%d, nombre='%s', edad='%s']",
                id, nombre, edad);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
