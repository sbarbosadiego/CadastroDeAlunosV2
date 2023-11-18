package com.localhost.cadastrodealunosv2.model;

import com.localhost.cadastrodealunosv2.exception.CursoException;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/**
 * @author Diego Barbosa da Silva
 */
@Data
@Entity(name = "cursos")
public class CursoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_codigo_curso")
    private Long codigoCurso;

    @Column(name = "curso_ementa")
    private String ementaCurso;

    @Column(name = "curso_descricao", length = 50, nullable = false)
    private String descricaoCurso;

    @CreationTimestamp
    @Column(name = "data_cadastro")
    private LocalDateTime dataCriacao;

    public CursoModel() {

    }

    public void setDescricaoCurso(String descricao) {
        if (descricao.length() >= 50) {
            throw new CursoException("A descrição não pode ter mais de 50 caracteres.");
        } else if (descricao.isEmpty()) {
            throw new CursoException("A descrição não pode estar vazio.");
        }
        this.descricaoCurso = descricao;
    }

}
