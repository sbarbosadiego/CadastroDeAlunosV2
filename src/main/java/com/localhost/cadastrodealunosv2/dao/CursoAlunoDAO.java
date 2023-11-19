package com.localhost.cadastrodealunosv2.dao;

import com.localhost.cadastrodealunosv2.model.CursoAlunoModel;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * @author Diego Barbosa da Silva
 */
public class CursoAlunoDAO extends Conexao {

    /**
     * Faz o insert de um novo registro de matrícula.
     *
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
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    /**
     * Atualiza o registro de matrícula.
     *
     * @param matricula
     * @return Boolean
     */
    public boolean atualizarCursoAluno(CursoAlunoModel matricula) {
        try {
            super.conectar();
            entityManager.merge(matricula);
            super.desconectar();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    /**
     * Deleta o registro de matrícula.
     *
     * @param id
     * @return Boolean
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
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    /**
     * Retorna o registro de uma matrícula.
     *
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
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return cursoAlunoModel;
    }
    
    /**
     * Retorna uma lista geral de registro de alunos.
     *
     * @return List
     */
    public List<CursoAlunoModel> retornarListaCursoAluno() {
        try {
            List<CursoAlunoModel> cursoAlunoModel = entityManager
                    .createQuery("SELECT u FROM cursos_alunos u", CursoAlunoModel.class)
                    .getResultList();
            return cursoAlunoModel;
        } catch (NoResultException | NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar resultado para a consulta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public List<CursoAlunoModel> retornarListaMatriculaNomeAluno(String nome) {
        try {
            List<CursoAlunoModel> cursoAlunoModel = entityManager
                    .createQuery("SELECT m "
                            + "FROM cursos_alunos m "
                            + "JOIN m.codigoAluno a "
                            + "WHERE a.nomeAluno LIKE :nome", CursoAlunoModel.class)
                    .setParameter("nome", "%" + nome + "%")
                    .getResultList();
            return cursoAlunoModel;
        } catch (NoResultException | NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar resultado para a consulta");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<CursoAlunoModel> retornarListaMatriculaNomeCurso(String nome) {
        try {
            List<CursoAlunoModel> cursoAlunoModel = entityManager
                    .createQuery("SELECT m "
                            + "FROM cursos_alunos m "
                            + "JOIN m.codigoCurso c "
                            + "WHERE c.descricaoCurso LIKE :nome", CursoAlunoModel.class)
                    .setParameter("nome", "%" + nome + "%")
                    .getResultList();
            return cursoAlunoModel;
        } catch (NoResultException | NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar resultado para a consulta");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<CursoAlunoModel> retornarListaMatriculaId(Long id) {
        try {
            List<CursoAlunoModel> cursoAlunoModel = entityManager
                    .createQuery("SELECT m "
                            + "FROM cursos_alunos m "
                            + "WHERE m.codigoCursoAluno = :id", CursoAlunoModel.class)
                    .setParameter("id",  id)
                    .getResultList();
            return cursoAlunoModel;
        } catch (NoResultException | NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar resultado para a consulta");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
