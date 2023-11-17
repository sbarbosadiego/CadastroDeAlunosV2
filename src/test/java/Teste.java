
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
        //modelAluno = alunoDao.retornarAlunoNome("cau");
        //System.out.println(modelAluno.toString());
        
        // Curso
        CursoModel modelCurso = new CursoModel();
        CursoDAO cursoDao = new CursoDAO();
        //modelCurso = cursoDao.retornarCursoNome("java");
        //System.out.println(modelCurso.toString());
        
        
        // CursoAluno
        //CursoAlunoModel matricula = new CursoAlunoModel(modelAluno, modelCurso);
        CursoAlunoModel matricula = new CursoAlunoModel();
        
        
        CursoAlunoDAO matriculaDao = new CursoAlunoDAO();
        
        /**
         * Primeiro é feito a consulta para receber as informações no objeto matricula,
         * em seguida pelo objeto da matrícula é passado as informações aos objetos de aluno e curso.
         */
        matricula = matriculaDao.retornarCursoAluno(4L);
        modelAluno = matricula.getCodigoAluno();
        modelCurso = matricula.getCodigoCurso();
        System.out.println(matricula.toString() + "Inicio da edição");
        System.out.println(modelAluno.toString() + "Inicio da edição");
        System.out.println(modelCurso.toString() + "Inicio da edição");
        
        /**
         * Realizado uma nova consulta que utiliza o método para encontrar um curso pelo nome,
         * dessa forma é atribuído um outro curso ao objeto.
         */
        modelCurso = cursoDao.retornarCursoNome("javascript");
        System.out.println(modelCurso.toString() + "Editado");
        
        // Atribuído o objeto com o curso atualizado novamente a matrícula.
        matricula.setCodigoCurso(modelCurso);
        System.out.println(matricula.toString() + "Pós edição");
        
        matriculaDao.atualizarCursoAluno(matricula);
        
        
        List<CursoAlunoModel> lista = new ArrayList<>();
        lista = matriculaDao.retornarListaCursoAluno();
        
        for (CursoAlunoModel matriculas: lista) {
            System.out.println(matriculas.toString());
        }
        
        //matriculaDao.cadastrarCursoAluno(matricula);
        //matriculaDao.excluirCursoAluno(5L);
        
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
        
        /*
        List<CursoModel> lista = new ArrayList<>();
        lista = cursoDao.retornarListaCursoNome("java");
        
        for (CursoModel aluno: lista) {
            System.out.println(aluno.toString());
        }
        */
        
        
    }
    
}
