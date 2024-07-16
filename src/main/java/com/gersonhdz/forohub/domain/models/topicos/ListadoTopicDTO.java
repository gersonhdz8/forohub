package com.gersonhdz.forohub.domain.models.topicos;

import java.time.LocalDate;

public record ListadoTopicDTO(

    Long id, 
    String titulo,
    String mensaje,
    LocalDate fechaCreacion,   
    String nombreCurso
) {
    public ListadoTopicDTO(Topic topic){
        this(topic.getId(), topic.getTitulo(), topic.getMensaje(), topic.getFechaCreacion(), topic.getNombreCurso());
    }

}
