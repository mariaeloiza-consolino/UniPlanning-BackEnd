package recursos;

import java.util.List;

import entidades.Resumos;
import io.quarkus.panache.common.Sort;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("resumos")

public class ResumosRecurso {
    @GET 
    public List <Resumos> listar(){
        return Resumos.listAll(Sort.ascending("nome"));
    }
}
