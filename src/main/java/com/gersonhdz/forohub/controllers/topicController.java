package com.gersonhdz.forohub.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gersonhdz.forohub.domain.models.topicos.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.net.URI;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





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

    @GetMapping
    public ResponseEntity<Page<ListadoTopicDTO>> listarTopics(@PageableDefault(size=10) Pageable paginacion) {

        return ResponseEntity.ok(topicRepository.findByEstadoTrue(paginacion).map(ListadoTopicDTO::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopic(@RequestBody @Valid ActualizarTopicDTO actualizarTopicDTO) {
        Topic topic = topicRepository.getReferenceById(actualizarTopicDTO.id());
        topic.actualizarDatos(actualizarTopicDTO);
        
        return ResponseEntity.ok(new ActualizarTopicDTO(actualizarTopicDTO.id(),actualizarTopicDTO.titulo(),actualizarTopicDTO.mensaje(),actualizarTopicDTO.nombreCurso()));
    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional    
    public ResponseEntity eliminarTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        topic.desactivarTopic();
        return ResponseEntity.noContent().build();
    }
    
    


}
