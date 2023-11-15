package com.localhost.cadastrodealunosv2.controller;

import com.localhost.cadastrodealunosv2.dao.AlunoDAO;
import com.localhost.cadastrodealunosv2.model.AlunoModel;
import java.util.List;

/**
 * @author Diego Barbosa da Silva
 */
public class AlunoController {
    
    private AlunoDAO alunoDao = new AlunoDAO();
    
    
    public int salvarAlunoController(AlunoModel aluno) {
        return this.alunoDao.cadastrarAluno(aluno);
    }
    
    public boolean atualizarAlunoController(AlunoModel aluno) {
        return this.alunoDao.atualizarAluno(aluno);
    }
    
    public boolean excluirAlunoController(Long id) {
        return this.alunoDao.excluirAluno(id);
    }
    
    public AlunoModel retornarAlunoController(Long id) {
        return this.alunoDao.retornarAluno(id);
    }
    
    public AlunoModel retornarAlunoNomeController(String nome) {
        return this.alunoDao.retornarAlunoNome(nome);
    }
    
    public List<AlunoModel> retornarListarAlunosController() {
        return this.alunoDao.retornarListaAluno();
    }
    
    public List<AlunoModel> retornarListarAlunoNomeController(String nome) {
        return this.alunoDao.retornarListaAlunoNome(nome);
    }
    
}
