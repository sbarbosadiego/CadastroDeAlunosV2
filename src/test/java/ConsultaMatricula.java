
import com.localhost.cadastrodealunosv2.dao.CursoAlunoDAO;
import com.localhost.cadastrodealunosv2.model.CursoAlunoModel;
import java.util.ArrayList;
import java.util.List;

public class ConsultaMatricula {
    
    public static void main(String[] args) {
        
        CursoAlunoModel matricula = new CursoAlunoModel();
        CursoAlunoDAO matriculaDao = new CursoAlunoDAO();
        
        List<CursoAlunoModel> lista = new ArrayList<>();
        lista = matriculaDao.retornarListaMatriculaId(18L);
        
        for (CursoAlunoModel matriculas: lista) {
            
            System.out.println(matriculas.toString());
        }
        
        
    }
    
}
