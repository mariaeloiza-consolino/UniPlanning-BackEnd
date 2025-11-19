package recursos;

import java.util.List;


import Entidades.Professor;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("professores")

public class ProfessorRecurso {
    @GET 
    public List <Professor> listar(){
        return Professor.listAll(Sort.ascending("nome"));
    }
    

    @POST
    @Transactional
    public void salvar (Professor professor){
        professor.persist();
    }
    
   @DELETE 
   @Path("{id}")
   @Transactional 
    public void excluir(@PathParam ("id") Integer id){
        Professor professor = Professor.findById(id);
        if (professor !=null){
            professor.delete();
        }
    }

    @PUT 
    @Transactional
    @Path ({"id"})
    public void editar (@PathParam("id") Integer id, Professor professor){
        Professor professorExistente = Professor.findById(id);
        if(professorExistente != null){
            professorExistente.cpf = professor.cpf;
            professorExistente.email = professor.email;
            professorExistente.nome = professor.nome;
            professorExistente.senha = professor.senha;
}
    }
}
