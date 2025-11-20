package recursos;

import java.util.List;

import Entidades.Planner;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("planners")

public class PlannerRecurso {
    @GET
    public List<Planner> listar() {
        return Planner.listAll(Sort.ascending("prioridades"));
    }

    @POST
    @Transactional
    public void salvar(Planner planner) {
        planner.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir(@PathParam("id") Integer id) {
        Planner planner = Planner.findById(id);
        if (planner != null) {
            planner.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{id}")
    public void editar(@PathParam("id") Integer id, Planner planner) {
        Planner plannerExistente = Planner.findById(id);
        if (plannerExistente != null) {
            plannerExistente.agenda = planner.agenda;
            plannerExistente.aluno = planner.aluno;
            plannerExistente.prioridades = planner.prioridades;
            plannerExistente.tarefas = planner.tarefas;
        }
    }
}