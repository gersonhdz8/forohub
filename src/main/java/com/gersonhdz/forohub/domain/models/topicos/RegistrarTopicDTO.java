package com.gersonhdz.forohub.domain.models.topicos;

import jakarta.validation.constraints.NotBlank;


public record RegistrarTopicDTO(

    @NotBlank(message = "El nombre debe ser obligatorio.")
    String titulo,

    @NotBlank(message = "El mensaje debe ser obligatorio.")
    String mensaje,    

    @NotBlank(message = "El nombre del curso debe ser obligatorio.")
    String nombreCurso
) {

}
