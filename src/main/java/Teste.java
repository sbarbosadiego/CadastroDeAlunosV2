
import com.localhost.cadastrodealunosv2.dao.AlunoDAO;
import com.localhost.cadastrodealunosv2.dao.CursoAlunoDAO;
import com.localhost.cadastrodealunosv2.dao.CursoDAO;
import com.localhost.cadastrodealunosv2.model.AlunoModel;
import com.localhost.cadastrodealunosv2.model.CursoAlunoModel;
import com.localhost.cadastrodealunosv2.model.CursoModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        
        // Aluno
        AlunoModel modelAluno = new AlunoModel();
        AlunoDAO alunoDao = new AlunoDAO();
        modelAluno = alunoDao.retornarAluno(16L);
        System.out.println(modelAluno.toString());
        
        // Curso
        CursoModel modelCurso = new CursoModel();
        CursoDAO cursoDao = new CursoDAO();
        modelCurso = cursoDao.retornarCurso(21L);
        System.out.println(modelCurso.toString());
        
        
        // CursoAluno
        CursoAlunoModel matricula = new CursoAlunoModel(modelAluno, modelCurso);
        System.out.println(matricula.toString());
        
        CursoAlunoDAO matriculaDao = new CursoAlunoDAO();
        //matriculaDao.cadastrarCursoAluno(matricula);
        matriculaDao.excluirCursoAluno(5L);
        
        //AlunoDAO dao = new AlunoDAO();
        //dao.cadastrarAluno(modelAluno);
        //modelAluno = dao.retornarAluno(6L);
        //System.out.println(modelAluno.toString());
        //System.out.println(modelAluno.getDataCriacao().format(DateTimeFormatter.ISO_LOCAL_DATE));
        //dao.excluirAluno(4L);
        //modelAluno.setNomeAluno("Diego Silva");
        //dao.atualizarAluno(modelAluno);
        
        /*
        List<AlunoModel> lista = new ArrayList<>();
        lista = dao.retornarListaAlunoNome("Di");
        
        for (AlunoModel aluno: lista) {
            System.out.println(aluno.toString());
        }
        */
        
        
    }
    
}
