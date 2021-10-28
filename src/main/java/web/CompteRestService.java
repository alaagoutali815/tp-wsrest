package web;


import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.CompteRepository;
import com.example.entities.Compte;

import javassist.tools.web.BadHttpRequest;

@Component
@Path("/Banque")
public class CompteRestService {
	@Autowired
	private CompteRepository compteRepository;
	
	@GET
	@Path("/Comptes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> getComptes(){
	return compteRepository.findAll();
	}
	@GET
	@Path("/Compte/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte getCompte(@PathParam (value="code") long code) {
		Optional<Compte> cpp = compteRepository.findById(code);
	    if (cpp.isPresent()) {
	        return cpp.get();
	    }
	    return null;	
	}
	
	@POST
	@Path("/Compte")
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(Compte compte) {
		 compteRepository.save(compte);
	   
	}

	@DELETE
	@Path("/Compte/{code}")
	public void delete(@PathParam (value="code") long code) {
		compteRepository.deleteById(code);
	}
	@PUT
	@Path("/Compte/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Compte update(@PathParam(value="code") long code,Compte compte)throws BadHttpRequest  {
        if (compteRepository.existsById(code)) {
        	compte.setCode(code);
            return compteRepository.save(compte);
        } else {
            throw new BadHttpRequest();
        }
    }


}
