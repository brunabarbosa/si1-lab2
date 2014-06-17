package models;

import java.util.Comparator;

public class PrioridadeComparator implements Comparator<Meta>{

	@Override
	public int compare(Meta meta, Meta outraMeta) {
		return meta.getPrioridade().getValor() - outraMeta.getPrioridade().getValor();
	}

}
