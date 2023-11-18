package com.localhost.cadastrodealunosv2.controller;

import com.localhost.cadastrodealunosv2.dao.CursoAlunoDAO;
import com.localhost.cadastrodealunosv2.model.CursoAlunoModel;
import java.util.List;

/**
 * @author Diego Barbosa da Silva
 */
public class CursoAlunoController {

    private CursoAlunoDAO cursoAlunoDao = new CursoAlunoDAO();

    public int salvarCursoAlunoController(CursoAlunoModel cursoAluno) {
        return this.cursoAlunoDao.cadastrarCursoAluno(cursoAluno);
    }

    public boolean atualizarCursoAlunoController(CursoAlunoModel cursoAluno) {
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
    
    public List<CursoAlunoModel> retornarListarMatriculaAlunosController(String nome) {
        return this.cursoAlunoDao.retornarListaMatriculaNomeAluno(nome);
    }
    
    public List<CursoAlunoModel> retornarListarMatriculaCursosController(String nome) {
        return this.cursoAlunoDao.retornarListaMatriculaNomeCurso(nome);
    }
}
