package recursos;

import java.util.List;

import entidades.Aluno;
import io.quarkus.panache.common.Sort;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("alunos")

public class AlunoRecurso {
    @GET 
    public List <Aluno> listar(){
        return Aluno.listAll(Sort.ascending("nome"));
    }
}
