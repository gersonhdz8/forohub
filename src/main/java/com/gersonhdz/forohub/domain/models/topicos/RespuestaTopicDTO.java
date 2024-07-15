package com.gersonhdz.forohub.domain.models.topicos;

import java.time.LocalDate;

public record RespuestaTopicDTO(
    
    Long id, 
    String titulo,
    String mensaje,
    LocalDate fechaCreacion,   
    String nombreCurso

) {

}
