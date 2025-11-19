package recursos;

import java.util.List;

import Entidades.Aluno;
import io.quarkus.panache.common.Sort;
import jakarta.persistence.PostUpdate;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("alunos")

public class AlunoRecurso {
    @GET 
    public List <Aluno> listar(){
        return Aluno.listAll(Sort.ascending("nome"));
    }


    @POST
    @Transactional
    public void salvar (Aluno aluno){
        aluno.persist();
    }

   @DELETE 
   @Path("{id}")
   @Transactional 
    public void excluir(@PathParam ("id") Integer id){
        Aluno aluno = Aluno.findById(id);
        if (aluno !=null){
            aluno.delete();
        }
    }

    @PUT 
    @Transactional
    @Path ({"id"})
    public void editar (@PathParam("id") Integer id, Aluno aluno){
        Aluno alunoExistente = Aluno.findById(id);
        if(alunoExistente != null){
            alunoExistente.cpf = aluno.cpf;
            alunoExistente.curso = aluno.curso;
            alunoExistente.email = aluno.email;
            alunoExistente.nome = aluno.nome;
            alunoExistente.senha = aluno.senha;
            alunoExistente.turma = aluno.turma;

            alunoExistente.persist();
        }
    }
}