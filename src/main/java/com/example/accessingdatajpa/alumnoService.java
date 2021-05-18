package com.example.accessingdatajpa;/*
    Created by: Daniel
    Date: 18/05/2021
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class alumnoService {

    private final alumnoRepository alumnoRepository;

    public AlumnoEntity add(AlumnoEntity alumno){
        return alumnoRepository.save(alumno);
    }

    @Autowired
    public alumnoService(alumnoRepository alumnoRepository){this.alumnoRepository = alumnoRepository;}

    public Optional<AlumnoEntity> findAlumnoById(long id){
        return alumnoRepository.findById(id);
    }

    public List<AlumnoEntity> findAllAlumnos(){
        return alumnoRepository.findAll();
    }

}
