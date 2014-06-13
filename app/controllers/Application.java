package controllers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import models.Meta;
import models.MetaComparator;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.formularioNovaMeta;
import views.html.index;

public class Application extends Controller {
	static Form<Meta> metaForm = Form.form(Meta.class);
	private static GenericDAO dao = new GenericDAOImpl();
	
	@Transactional 
    public static Result index() {
    	List<Meta> result = getDao().findAllByClassName("Meta");
    	Collections.sort(result, new MetaComparator());
    
    	return ok(index.render(result));
    }
    
    public static Result formularioNovaMeta(){
    	Form<Meta> form = Form.form(Meta.class);
    	return ok(formularioNovaMeta.render(form));
    }
    
    @Transactional 
    public static Result cadastraMeta(){
    	//todas as metas do bd
    	Form<Meta> form = Form.form(Meta.class).bindFromRequest();
    	if(form.hasErrors()){
    		return badRequest(formularioNovaMeta.render(form));
		}
		// Persiste o Livro criado
		getDao().persist(form.get());
		// Espelha no Banco de Dados
		getDao().flush();

		return redirect(routes.Application.index());
    }
    
	@Transactional
	public static Result deleteMeta(Long id) {
		// Remove o Livro pelo Id
		getDao().removeById(Meta.class, id);
		// Espelha no banco de dados
		getDao().flush();
		return redirect(routes.Application.index());
	}
    
	public static GenericDAO getDao() {
		return dao;
	}

	public static void setDao(GenericDAO dao) {
		Application.dao = dao;
	}


}
