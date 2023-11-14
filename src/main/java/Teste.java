
import com.localhost.cadastrodealunosv2.dao.AlunoDAO;
import com.localhost.cadastrodealunosv2.model.AlunoModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        
        AlunoModel modelAluno = new AlunoModel();
        //modelAluno.setCodigoAluno(5L);
        
        
        AlunoDAO dao = new AlunoDAO();
        //dao.cadastrarAluno(modelAluno);
        modelAluno = dao.retornarAluno(6L);
        System.out.println(modelAluno.toString());
        System.out.println(modelAluno.getDataCriacao().format(DateTimeFormatter.ISO_LOCAL_DATE));
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
