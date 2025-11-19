package recursos;

import java.util.List;


import Entidades.Resumos;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("resumos")

public class ResumosRecurso {
    @GET 
    public List <Resumos> listar(){
        return Resumos.listAll(Sort.ascending("nome"));
    }
    

    @POST
    @Transactional
    public void salvar (Resumos resumos){
        resumos.persist();
    }

    @DELETE 
   @Path("{id}")
   @Transactional 
    public void excluir(@PathParam ("id") Integer id){
        Resumos resumos = Resumos.findById(id);
        if (resumos !=null){
            resumos.delete();
        }
    }
}
