package com.localhost.cadastrodealunosv2.dao;

import com.localhost.cadastrodealunosv2.model.CursoAlunoModel;
import java.util.List;

/**
 * @author Diego Barbosa da Silva
 */
public class CursoAlunoDAO extends Conexao {
    
    /**
     * Faz o insert de um novo registro de matrícula.
     * @param cursoAluno
     * @return int
     */
    public int cadastrarCursoAluno(CursoAlunoModel cursoAluno) {
        try {
            super.conectar();
            entityManager.persist(cursoAluno);
            super.desconectar();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * Atualiza o registro de matrícula.
     * @param aluno
     * @return boolean
     */
    public boolean atualizarCursoAluno(CursoAlunoModel aluno) {
        try {
            super.conectar();
            entityManager.merge(aluno);
            super.desconectar();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Deleta o registro de matrícula.
     * @param id
     * @return boolean
     */
    public boolean excluirCursoAluno(Long id) {
        CursoAlunoModel cursoAlunoModel = new CursoAlunoModel();
        try {
            super.conectar();
            cursoAlunoModel = entityManager.find(CursoAlunoModel.class, id);
            if (cursoAlunoModel != null) {
                entityManager.remove(cursoAlunoModel);
            }
            super.desconectar();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Retorna o registro de um matrícula.
     * @param id
     * @return AlunoModel
     */
    public CursoAlunoModel retornarCursoAluno(Long id) {
        CursoAlunoModel cursoAlunoModel = new CursoAlunoModel();
        try {
            super.conectar();
            cursoAlunoModel = entityManager.find(CursoAlunoModel.class, id);
            super.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursoAlunoModel;
    }
    
    /**
     * Retorna uma lista de registro de alunos.
     * @return List<AlunoModel>
     */
    public List<CursoAlunoModel> retornarListaCursoAluno() {
        List<CursoAlunoModel> cursoAlunoModel = entityManager
                .createQuery("SELECT u FROM cursos_alunos u", CursoAlunoModel.class)
                .getResultList();
        return cursoAlunoModel;
    }
    
    
}
