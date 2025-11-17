package recursos;

import java.util.List;

import entidades.Turma;
import io.quarkus.panache.common.Sort;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("turmas")

public class TurmaRecurso {
    @GET 
    public List <Turma> listar(){
        return Turma.listAll(Sort.ascending("nome"));
    }
}
