package recursos;

import java.util.List;

import Entidades.VideoAulas;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("videoAulas")

public class VideoAulasRecurso {
    @GET 
    public List <VideoAulas> listar(){
        return VideoAulas.listAll(Sort.ascending("titulo"));
    }
    

    @POST
    @Transactional
    public void salvar (VideoAulas videoAulas){
        videoAulas.persist();
    }

    @DELETE 
    @Path("{id}")
    @Transactional 
    public void excluir(@PathParam ("id") Integer id){
        VideoAulas videoAulas = VideoAulas.findById(id);
        if (videoAulas !=null){
            videoAulas.delete();
        }
    }
}
