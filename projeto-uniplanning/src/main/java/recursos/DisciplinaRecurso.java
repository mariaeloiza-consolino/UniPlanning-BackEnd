package recursos;

import java.util.List;

import Entidades.Disciplina;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("disciplinas")

public class DisciplinaRecurso {
    @GET 
    public List <Disciplina> listar(){
        return Disciplina.listAll(Sort.ascending("nome"));
    }
    

    @POST
    @Transactional
    public void salvar (Disciplina disciplina){
        disciplina.persist();
    }
    
   @DELETE 
   @Path("{id}")
   @Transactional 
    public void excluir(@PathParam ("id") Integer id){
        Disciplina disciplina = Disciplina.findById(id);
        if (disciplina !=null){
            disciplina.delete();
        }
    }
}
