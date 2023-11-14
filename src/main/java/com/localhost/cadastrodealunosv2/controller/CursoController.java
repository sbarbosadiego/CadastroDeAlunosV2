package com.localhost.cadastrodealunosv2.controller;

import com.localhost.cadastrodealunosv2.dao.CursoDAO;
import com.localhost.cadastrodealunosv2.model.CursoModel;
import java.util.List;

/**
 * @author Diego Barbosa da Silva
 */
public class CursoController {
    
    private CursoDAO cursoDao = new CursoDAO();
    
    public int salvarCursoController(CursoModel curso) {
        return this.cursoDao.cadastrarCurso(curso);
    }
    
    public boolean atualizarCursoController(CursoModel curso) {
        return this.cursoDao.atualizarCurso(curso);
    }
    
    public boolean excluirCursoController(Long id) {
        return this.cursoDao.excluirCurso(id);
    }
    
    public CursoModel retornarCursoController(Long id) {
        return this.cursoDao.retornarCurso(id);
    }
    
    public List<CursoModel> retornarListarCursosController() {
        return this.cursoDao.retornarListaCurso();
    }
    
    public List<CursoModel> retornarListarCursoNomeController(String nome) {
        return this.cursoDao.retornarListaCursoNome(nome);
    }
    
}
