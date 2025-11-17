package recursos;

import java.util.List;

import entidades.Disciplina;
import io.quarkus.panache.common.Sort;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("disciplinas")

public class DisciplinaRecurso {
    @GET 
    public List <Disciplina> listar(){
        return Disciplina.listAll(Sort.ascending("nome"));
    }
}
