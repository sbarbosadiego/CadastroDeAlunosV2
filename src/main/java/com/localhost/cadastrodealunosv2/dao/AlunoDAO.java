package com.localhost.cadastrodealunosv2.dao;

import com.localhost.cadastrodealunosv2.model.AlunoModel;
import java.util.List;

/**
 * @author Diego Barbosa da Silva
 */
public class AlunoDAO extends Conexao {
    
    /**
     * Faz o insert de um novo registro de aluno.
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
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * Atualiza o registro de um aluno.
     * @param aluno
     * @return boolean
     */
    public boolean atualizarAluno(AlunoModel aluno) {
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
     * Deleta o registro de um aluno.
     * @param id
     * @return boolean
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
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Retorna o registro de um aluno.
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
            e.printStackTrace();
        }
        return alunoModel;
    }
    
    /**
     * Retorna uma lista de registro de alunos.
     * @return List<AlunoModel>
     */
    public List<AlunoModel> retornarListaAluno() {
        List<AlunoModel> listaAlunos = entityManager
                .createQuery("SELECT u FROM alunos u", AlunoModel.class)
                .getResultList();
        return listaAlunos;
    }
    
    /**
     * Retorna a 
     * @param nome
     * @return 
     */
    public List<AlunoModel> retornarListaAlunoNome(String nome) {
        List<AlunoModel> listaAlunos = entityManager
                .createQuery("SELECT u FROM alunos u WHERE u.nomeAluno LIKE :nome", AlunoModel.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
        return listaAlunos;
    }
    
}
