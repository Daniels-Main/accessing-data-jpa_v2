package com.example.accessingdatajpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

/**
 * Created by: Daniels
 * Date: 14/05/2021
 * Description:
 */
@RestController
public class JsonController {

    private final alumnoService alumnoService;

    @Autowired
    public JsonController(alumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }


    @PostMapping("/processJson")
    public Long getSubmit(@RequestBody String processJson, alumnoRepository repository) throws IOException {

        AlumnoEntity alumnoEntity;
        ObjectMapper om = new ObjectMapper();
        String result = java.net.URLDecoder.decode(processJson, StandardCharsets.UTF_8.name());
        result = result.substring(12);
        alumnoEntity = om.readValue(result, AlumnoEntity.class);
        AlumnoEntity alumnocreado = alumnoService.add(alumnoEntity);
        System.out.println(alumnoEntity);

        return alumnocreado.getId();
    }

    @GetMapping("find/{id}")
    public String findAlumnoById (@PathVariable("id") long id){
        Optional<AlumnoEntity> alumno = alumnoService.findAlumnoById(id);
        String texto = alumno.toString().substring(8);
        return texto;
    }
    @GetMapping("findAll")
    private ResponseEntity<List<AlumnoEntity>> findAllAlumnos() {
        List<AlumnoEntity> alumnos = alumnoService.findAllAlumnos();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }
}
