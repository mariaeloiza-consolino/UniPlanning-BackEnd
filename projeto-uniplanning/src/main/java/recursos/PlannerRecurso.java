package recursos;

import java.util.List;

import entidades.Planner;
import io.quarkus.panache.common.Sort;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("planners")

public class PlannerRecurso {
    @GET 
    public List <Planner> listar(){
        return Curso.listAll(Sort.ascending("prioridades"));
    }
}
