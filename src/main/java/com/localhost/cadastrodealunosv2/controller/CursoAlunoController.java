package com.localhost.cadastrodealunosv2.controller;

import com.localhost.cadastrodealunosv2.dao.CursoAlunoDAO;
import com.localhost.cadastrodealunosv2.model.CursoAlunoModel;
import java.util.List;

/**
 * @author Diego Barbosa da Silva
 */
public class CursoAlunoController {
    
    private CursoAlunoDAO cursoAlunoDao = new CursoAlunoDAO();
    
    public int salvarAlunoController(CursoAlunoModel cursoAluno) {
        return this.cursoAlunoDao.cadastrarCursoAluno(cursoAluno);
    }
    
    public boolean atualizarAlunoController(CursoAlunoModel cursoAluno) {
        return this.cursoAlunoDao.atualizarCursoAluno(cursoAluno);
    }
    
    public boolean excluirCursoAlunoController(Long id) {
        return this.cursoAlunoDao.excluirCursoAluno(id);
    }
    
    public CursoAlunoModel retornarCursoAlunoController(Long id) {
        return this.cursoAlunoDao.retornarCursoAluno(id);
    }
    
    public List<CursoAlunoModel> retornarListarCursoAlunosController() {
        return this.cursoAlunoDao.retornarListaCursoAluno();
    }
    
}
