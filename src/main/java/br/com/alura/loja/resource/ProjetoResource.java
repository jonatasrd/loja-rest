package br.com.alura.loja.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

@Path(value = "/projetos")
public class ProjetoResource {
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca(@PathParam("id") long id){
		Projeto projeto = new ProjetoDAO().busca(1l);
		return projeto.toXML();
	}
	
	@POST
    @Produces(MediaType.APPLICATION_XML)
	public String adiciona(String conteudo){
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		new ProjetoDAO().adiciona(projeto);;
		return "<status>sucesso</status>";
	}
	
	@Path("{id}")
    @DELETE
    public Response removeProjeto(@PathParam("id") long id) {
        new ProjetoDAO().remove(id);
        return Response.ok().build();
    }
}
