package com.gersonhdz.forohub.domain.models.topicos;

import jakarta.validation.constraints.NotBlank;

public record ActualizarTopicDTO(
    @NotBlank
    Long id,
    String titulo,
    String mensaje,
    String nombreCurso
) {

}
