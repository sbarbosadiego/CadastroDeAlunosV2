package com.localhost.cadastrodealunosv2.controller;

import com.localhost.cadastrodealunosv2.dao.CursoAlunoDAO;
import com.localhost.cadastrodealunosv2.model.CursoAlunoModel;
import java.util.List;

/**
 * @author Diego Barbosa da Silva
 */
public class CursoAlunoController {

    private CursoAlunoDAO cursoAlunoDao = new CursoAlunoDAO();

    /**
     * Faz o insert de um novo registro de matrícula.
     *
     * @param cursoAluno
     * @return int
     */
    public int salvarCursoAlunoController(CursoAlunoModel cursoAluno) {
        return this.cursoAlunoDao.cadastrarCursoAluno(cursoAluno);
    }

    /**
     * Atualiza um registro de matrícula.
     *
     * @param cursoAluno
     * @return Boolean
     */
    public boolean atualizarCursoAlunoController(CursoAlunoModel cursoAluno) {
        return this.cursoAlunoDao.atualizarCursoAluno(cursoAluno);
    }

    /**
     * Deleta um registro de matrícula pelo Id.
     *
     * @param id
     * @return Boolean
     */
    public boolean excluirCursoAlunoController(Long id) {
        return this.cursoAlunoDao.excluirCursoAluno(id);
    }

    /**
     * Retorna um registro de uma única matrícula pelo Id.
     *
     * @param id
     * @return CursoAlunoModel
     */
    public CursoAlunoModel retornarCursoAlunoController(Long id) {
        return this.cursoAlunoDao.retornarCursoAluno(id);
    }

    /**
     * Retorna uma lista geral de matrículas.
     *
     * @return List
     */
    public List<CursoAlunoModel> retornarListarCursoAlunosController() {
        return this.cursoAlunoDao.retornarListaCursoAluno();
    }

    /**
     * Retorna uma lista de matrículas pelo nome do aluno.
     *
     * @param nome
     * @return List
     */
    public List<CursoAlunoModel> retornarListarMatriculaAlunosController(String nome) {
        return this.cursoAlunoDao.retornarListaMatriculaNomeAluno(nome);
    }

    /**
     * Retorna uma lista de matrículas pelo nome do curso.
     *
     * @param nome
     * @return List
     */
    public List<CursoAlunoModel> retornarListarMatriculaCursosController(String nome) {
        return this.cursoAlunoDao.retornarListaMatriculaNomeCurso(nome);
    }

    /**
     * Retorna um lista de matrícula pelo Id da matrícula.
     *
     * @param id
     * @return List
     */
    public List<CursoAlunoModel> retornarListarMatriculaIdController(Long id) {
        return this.cursoAlunoDao.retornarListaMatriculaId(id);
    }
}
