package recursos;

import java.util.List;

import entidades.Curso;
import io.quarkus.panache.common.Sort;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("cursos")

public class CursoRecurso {
    @GET 
    public List <Curso> listar(){
        return Curso.listAll(Sort.ascending("nome"));
    }
}
