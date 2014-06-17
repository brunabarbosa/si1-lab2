package controllers;

import java.util.Collections;
import java.util.List;

import models.Meta;
import models.Prioridade;
import models.PrioridadeComparator;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.formularioNovaMeta;
import views.html.index;
import views.html.tabela;

public class Application extends Controller {
	static Form<Meta> metaForm = Form.form(Meta.class);
	private static GenericDAO dao = new GenericDAOImpl();
	
	@Transactional 
    public static Result index() {
		List<Meta> result = getDao().findAllByClassName("Meta");
    	inicializaDezMetas(result);
		
    	return ok(index.render("Index page"));
    }

	private static void inicializaDezMetas(List<Meta> result) {
		if(result.size() == 0){
    		dao.merge(new Meta("meta01", "desc", 1, Prioridade.Media, false));
    		dao.merge(new Meta("meta02", "desc", 1, Prioridade.Alta, false));
    		dao.merge(new Meta("meta03", "desc", 1, Prioridade.Alta, false));
    		dao.merge(new Meta("meta04", "desc", 1, Prioridade.Baixa, false));
    		dao.merge(new Meta("meta05", "desc", 2, Prioridade.Alta, false));
    		dao.merge(new Meta("meta06", "desc", 2, Prioridade.Media, false));
    		dao.merge(new Meta("meta07", "desc", 2, Prioridade.Alta, false));
    		dao.merge(new Meta("meta08", "desc", 3, Prioridade.Baixa, false));
    		dao.merge(new Meta("meta09", "desc", 3, Prioridade.Alta, false));
    		dao.merge(new Meta("meta10", "desc", 3, Prioridade.Media, false));
    		getDao().flush();
    	}
	}
	
	@Transactional 
	public static Result tabela(String nsemana){
		List<Meta> result = getDao().findByAttributeName("Meta", "nsemana", nsemana);
		Collections.sort(result, new PrioridadeComparator());
		return ok(tabela.render(result, result.size()));
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
