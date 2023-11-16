package com.localhost.cadastrodealunosv2.dao;

import static com.localhost.cadastrodealunosv2.dao.Conexao.entityManager;
import com.localhost.cadastrodealunosv2.model.CursoModel;
import java.util.List;

/**
 * @author Diego Barbosa da Silva
 */
public class CursoDAO extends Conexao {
    
    /**
     * Faz o insert de um novo registro de curso.
     * @param curso
     * @return int
     */
    public int cadastrarCurso(CursoModel curso) {
        try {
            super.conectar();
            entityManager.persist(curso);
            super.desconectar();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * Atualiza o registro de um curso.
     * @param curso
     * @return boolean
     */
    public boolean atualizarCurso(CursoModel curso) {
        try {
            super.conectar();
            entityManager.merge(curso);
            super.desconectar();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Deleta o registro de um curso.
     * @param id
     * @return boolean
     */
    public boolean excluirCurso(Long id) {
        CursoModel cursoModel = new CursoModel();
        try {
            super.conectar();
            cursoModel = entityManager.find(CursoModel.class, id);
            if (cursoModel != null) {
                entityManager.remove(cursoModel);
            }
            super.desconectar();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Retorna o registro de um curso.
     * @param id
     * @return CursoModel
     */
    public CursoModel retornarCurso(Long id) {
        CursoModel cursoModel = new CursoModel();
        try {
            super.conectar();
            cursoModel = entityManager.find(CursoModel.class, id);
            super.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursoModel;
    }
    
    /**
     * Retorna uma lista de registro de cursos.
     * @return List<CursoModel>
     */
    public List<CursoModel> retornarListaCurso() {
        List<CursoModel> listaCursos = entityManager
                .createQuery("SELECT u FROM cursos u", CursoModel.class)
                .getResultList();
        return listaCursos;
    }
    
    /**
     * Retorna a 
     * @param curso
     * @return 
     */
    public List<CursoModel> retornarListaCursoNome(String curso) {
        List<CursoModel> listaCursos = entityManager
                .createQuery("SELECT u FROM cursos u WHERE u.descricaoCurso LIKE :curso", CursoModel.class)
                .setParameter("curso", "%" + curso + "%")
                .getResultList();
        return listaCursos;
    }
    
    public CursoModel retornarCursoNome(String curso) {
        CursoModel cursoModel = new CursoModel();
        cursoModel = entityManager
                .createQuery("SELECT u FROM cursos u WHERE u.descricaoCurso LIKE :curso", CursoModel.class)
                .setParameter("curso", "%" + curso + "%")
                .setMaxResults(1)
                .getSingleResult();
        return cursoModel;
    }
    
}
