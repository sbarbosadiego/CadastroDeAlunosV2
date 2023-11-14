package com.localhost.cadastrodealunosv2.model;

import com.localhost.cadastrodealunosv2.exception.AlunoException;
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
@Entity(name = "alunos")
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_codigo_aluno")
    private Long codigoAluno;

    @Column(name = "aluno_nome", length = 51, nullable = false)
    private String nomeAluno;

    @CreationTimestamp
    @Column(name = "data_cadastro")
    private LocalDateTime dataCriacao;

    public AlunoModel() {

    }

    public void setNomeAluno(String nome) {
        if (nome.length() >= 50) {
            throw new AlunoException("O nome do aluno não pode ter mais de 50 caracteres.");
        } else if (nome.isEmpty()) {
            throw new AlunoException("O nome do aluno não pode estar vazio.");
        }
        this.nomeAluno = nome;
    }

}
