package recursos;

import java.util.List;

import entidades.VideoAulas;
import io.quarkus.panache.common.Sort;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("videoAulas")

public class VideoAulasRecurso {
    @GET 
    public List <VideoAulas> listar(){
        return VideoAulas.listAll(Sort.ascending("titulo"));
    }
}
