package recursos;

import java.util.List;

import Entidades.Progresso;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("progressos")
public class ProgressoRecurso {
    @GET 
    public List <Progresso> listar(){
        return Progresso.listAll(Sort.ascending("disciplina"));
    }
    

    @POST
    @Transactional
    public void salvar (Progresso progresso){
        progresso.persist();
    }
    
   @DELETE 
   @Path("{id}")
   @Transactional 
    public void excluir(@PathParam ("id") Integer id){
        Progresso progresso = Progresso.findById(id);
        if (progresso !=null){
            progresso.delete();
        }
    }
    
    @PUT 
    @Transactional
    @Path ("{id}")
    public void editar (@PathParam("id") Integer id, Progresso progresso){
        Progresso progressoExistente = Progresso.findById(id);
        if(progressoExistente != null){
            progressoExistente.aluno = progresso.aluno;
            progressoExistente.disciplina = progresso.disciplina;
        }
    }
}