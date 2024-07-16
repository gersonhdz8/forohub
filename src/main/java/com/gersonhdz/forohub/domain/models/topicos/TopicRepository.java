package com.gersonhdz.forohub.domain.models.topicos;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TopicRepository extends JpaRepository< Topic, Long> {

    Page<Topic> findByEstadoTrue(Pageable paginacion);
}
