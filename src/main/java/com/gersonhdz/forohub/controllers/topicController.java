package com.gersonhdz.forohub.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gersonhdz.forohub.domain.models.topicos.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.net.URI;

import org.apache.catalina.connector.Response;
import org.hibernate.annotations.ValueGenerationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")

public class topicController {
    
    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    @Transactional
    public ResponseEntity <RespuestaTopicDTO> registrarTopic(@RequestBody @Valid RegistrarTopicDTO registrarTopicDTO , UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = new Topic(registrarTopicDTO);
        topicRepository.save(topic);
        RespuestaTopicDTO respuestaTopicDTO = new RespuestaTopicDTO(topic.getId(), topic.getTitulo(), topic.getTitulo(), topic.getFechaCreacion(), topic.getNombreCurso());   
        
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(respuestaTopicDTO);
    }
    


}
