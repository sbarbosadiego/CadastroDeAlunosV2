package com.localhost.cadastrodealunosv2.dao;

import com.localhost.cadastrodealunosv2.model.AlunoModel;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.swing.JOptionPane;

/**
 * @author Diego Barbosa da Silva
 */
public class AlunoDAO extends Conexao {

    /**
     * Faz o insert de um novo registro de aluno.
     *
     * @param aluno
     * @return int
     */
    public int cadastrarAluno(AlunoModel aluno) {
        try {
            super.conectar();
            entityManager.persist(aluno);
            super.desconectar();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    /**
     * Atualiza o registro de um aluno.
     *
     * @param aluno
     * @return Boolean
     */
    public boolean atualizarAluno(AlunoModel aluno) {
        try {
            super.conectar();
            entityManager.merge(aluno);
            super.desconectar();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    /**
     * Deleta o registro de um aluno.
     *
     * @param id
     * @return Boolean
     */
    public boolean excluirAluno(Long id) {
        AlunoModel alunoModel = new AlunoModel();
        try {
            super.conectar();
            alunoModel = entityManager.find(AlunoModel.class, id);
            if (alunoModel != null) {
                entityManager.remove(alunoModel);
            }
            super.desconectar();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    /**
     * Retorna o registro de um aluno.
     *
     * @param id
     * @return AlunoModel
     */
    public AlunoModel retornarAluno(Long id) {
        AlunoModel alunoModel = new AlunoModel();
        try {
            super.conectar();
            alunoModel = entityManager.find(AlunoModel.class, id);
            super.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return alunoModel;
    }

    /**
     * Retorna uma lista geral de registros de alunos.
     *
     * @return List
     */
    public List<AlunoModel> retornarListaAluno() {
        try {
            List<AlunoModel> listaAlunos = entityManager
                    .createQuery("SELECT u FROM alunos u", AlunoModel.class)
                    .getResultList();
            return listaAlunos;
        } catch (NoResultException | NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar resultado para consulta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    /**
     * Retorna uma lista de alunos pelo nome.
     *
     * @param nome
     * @return List
     */
    public List<AlunoModel> retornarListaAlunoNome(String nome) {
        try {
            List<AlunoModel> listaAlunos = entityManager
                    .createQuery("SELECT u FROM alunos u WHERE u.nomeAluno LIKE :nome", AlunoModel.class)
                    .setParameter("nome", "%" + nome + "%")
                    .getResultList();
            return listaAlunos;
        } catch (NoResultException | NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar resultado para consulta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    /**
     * Retorna um único registro de aluno pelo nome.
     *
     * @param nome
     * @return AlunoModel
     */
    public AlunoModel retornarAlunoNome(String nome) {
        AlunoModel alunoModel = new AlunoModel();
        try {
            alunoModel = entityManager
                    .createQuery("SELECT u FROM alunos u WHERE u.nomeAluno LIKE :nome", AlunoModel.class)
                    .setParameter("nome", "%" + nome + "%")
                    .setMaxResults(1)
                    .getSingleResult();
            return alunoModel;
        } catch (NoResultException | NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar resultado para consulta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

}
