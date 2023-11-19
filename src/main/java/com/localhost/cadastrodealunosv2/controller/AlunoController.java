package com.localhost.cadastrodealunosv2.controller;

import com.localhost.cadastrodealunosv2.dao.AlunoDAO;
import com.localhost.cadastrodealunosv2.model.AlunoModel;
import java.util.List;

/**
 * @author Diego Barbosa da Silva
 */
public class AlunoController {

    private AlunoDAO alunoDao = new AlunoDAO();
    
    /**
     * Faz a insert de um novo registro de um aluno.
     * @param aluno
     * @return 
     */
    public int salvarAlunoController(AlunoModel aluno) {
        return this.alunoDao.cadastrarAluno(aluno);
    }
    
    /**
     * Atualiza o registro de um aluno.
     * @param aluno
     * @return Boolean
     */
    public boolean atualizarAlunoController(AlunoModel aluno) {
        return this.alunoDao.atualizarAluno(aluno);
    }
    
    /**
     * Deleta o registo de um aluno pelo id.
     * @param id
     * @return Boolean
     */
    public boolean excluirAlunoController(Long id) {
        return this.alunoDao.excluirAluno(id);
    }
    
    /**
     * Retorna o registro de um único aluno fazendo a busca pelo id.
     * @param id
     * @return AlunoModel
     */
    public AlunoModel retornarAlunoController(Long id) {
        return this.alunoDao.retornarAluno(id);
    }
    
    /**
     * Retorna o registro de um único aluno fazendo a busca pelo nome.
     * @param nome
     * @return AlunoModel
     */
    public AlunoModel retornarAlunoNomeController(String nome) {
        return this.alunoDao.retornarAlunoNome(nome);
    }
    
    /**
     * Retorna uma lista geral de alunos.
     * @return List
     */
    public List<AlunoModel> retornarListarAlunosController() {
        return this.alunoDao.retornarListaAluno();
    }
    
    /**
     * Retorna uma lista de alunos fazendo a busca pelo nome.
     * @param nome
     * @return List
     */
    public List<AlunoModel> retornarListarAlunoNomeController(String nome) {
        return this.alunoDao.retornarListaAlunoNome(nome);
    }

}
