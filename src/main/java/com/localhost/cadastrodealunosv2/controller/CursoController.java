package com.localhost.cadastrodealunosv2.controller;

import com.localhost.cadastrodealunosv2.dao.CursoDAO;
import com.localhost.cadastrodealunosv2.model.CursoModel;
import java.util.List;

/**
 * @author Diego Barbosa da Silva
 */
public class CursoController {

    private CursoDAO cursoDao = new CursoDAO();

    /**
     * Faz a insert de um novo registro de um curso.
     *
     * @param curso
     * @return int
     */
    public int salvarCursoController(CursoModel curso) {
        return this.cursoDao.cadastrarCurso(curso);
    }

    /**
     * Atualiza o registro de um curso.
     *
     * @param curso
     * @return Boolean
     */
    public boolean atualizarCursoController(CursoModel curso) {
        return this.cursoDao.atualizarCurso(curso);
    }

    /**
     * Deleta o registo de um curso pelo id.
     *
     * @param id
     * @return Boolean
     */
    public boolean excluirCursoController(Long id) {
        return this.cursoDao.excluirCurso(id);
    }

    /**
     * Retorna o registro de um único curso fazendo a busca pelo id.
     *
     * @param id
     * @return CursoModel
     */
    public CursoModel retornarCursoController(Long id) {
        return this.cursoDao.retornarCurso(id);
    }

    /**
     * Retorna o registro de um curso pelo nome.
     *
     * @param curso
     * @return CursoModel
     */
    public CursoModel retornarCursoNomeController(String curso) {
        return this.cursoDao.retornarCursoNome(curso);
    }

    /**
     * Retorna uma lista geral de cursos.
     *
     * @return List
     */
    public List<CursoModel> retornarListarCursosController() {
        return this.cursoDao.retornarListaCurso();
    }

    /**
     * Retorna uma lista de cursos pelo nome.
     *
     * @param curso
     * @return List
     */
    public List<CursoModel> retornarListarCursoNomeController(String curso) {
        return this.cursoDao.retornarListaCursoNome(curso);
    }

}
