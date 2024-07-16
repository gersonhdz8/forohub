package com.gersonhdz.forohub.domain.models.topicos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "topicos")
@Entity(name = "Topic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")


public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    private Boolean estado;   
    private String nombreCurso;    

    public Topic(RegistrarTopicDTO datosTopicDTO){
        this.titulo = datosTopicDTO.titulo();
        this.mensaje = datosTopicDTO.mensaje();
        this.nombreCurso = datosTopicDTO.nombreCurso();
        this.fechaCreacion = LocalDate.now();
        this.estado = true;
    }

    public void actualizarDatos(@Valid ActualizarTopicDTO actualizarTopicDTO) {
        if (actualizarTopicDTO.titulo() != null) {
            this.titulo = actualizarTopicDTO.titulo();
        }
        if (actualizarTopicDTO.mensaje() != null) {
            this.mensaje = actualizarTopicDTO.mensaje();
        }
        if (actualizarTopicDTO.nombreCurso() != null) {
            this.nombreCurso = actualizarTopicDTO.nombreCurso();
        }
    }

    public void desactivarTopic() {
        this.estado = false;
    }
}
