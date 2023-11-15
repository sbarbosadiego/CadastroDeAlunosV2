package com.localhost.cadastrodealunosv2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import lombok.Data;

/**
 * @author Diego Barbosa da Silva
 */
@Data
@Entity(name = "cursos_alunos")
public class CursoAlunoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_codigo")
    private Long codigoCursoAluno;
    
    @ManyToOne
    @JoinColumn(name = "fk_aluno", referencedColumnName = "pk_codigo_aluno")
    private AlunoModel codigoAluno;

    @ManyToOne
    @JoinColumn(name = "fk_curso", referencedColumnName = "pk_codigo_curso")
    private CursoModel codigoCurso;
    
    @Transient
    private String aluno;
    
    @Transient
    private String curso;

    public CursoAlunoModel() {
        
    }
    
    public CursoAlunoModel(AlunoModel aluno, CursoModel curso) {
        this.codigoAluno = aluno;
        this.codigoCurso = curso;
    }

}
