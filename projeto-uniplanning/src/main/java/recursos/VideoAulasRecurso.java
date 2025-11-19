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
    public List<VideoAulas> listar() {
        return VideoAulas.listAll(Sort.ascending("titulo"));
    }

    @POST
    @Transactional
    public void salvar(VideoAulas videoAulas) {
        videoAulas.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir(@PathParam("id") Integer id) {
        VideoAulas videoAulas = VideoAulas.findById(id);
        if (videoAulas != null) {
            videoAulas.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{id}")
    public void editar(@PathParam("id") Integer id, VideoAulas videoAulas) {
        VideoAulas videoAulasExistente = VideoAulas.findById(id);
        if (videoAulasExistente != null) {
            videoAulasExistente.curso = videoAulas.curso;
            videoAulasExistente.professor = videoAulas.professor;
            videoAulasExistente.titulo = videoAulas.titulo;
            videoAulasExistente.turma = videoAulas.turma;
        }
    }
}