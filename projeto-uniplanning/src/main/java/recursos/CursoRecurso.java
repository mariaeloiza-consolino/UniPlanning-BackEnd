package recursos;

import java.util.List;

import Entidades.Curso;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("cursos")

public class CursoRecurso {
    @GET 
    public List <Curso> listar(){
        return Curso.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar (Curso curso){
        curso.persist();
    }
    
   @DELETE 
   @Path("{id}")
   @Transactional 
    public void excluir(@PathParam ("id") Integer id){
        Curso curso = Curso.findById(id);
        if (curso !=null){
            curso.delete();
        }
    }
}
