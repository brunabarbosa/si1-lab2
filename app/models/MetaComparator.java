package models;

import java.util.Comparator;

public class MetaComparator implements Comparator<Meta>{

	@Override
	public int compare(Meta meta, Meta outraMeta) {
		// TODO Auto-generated method stub
		return meta.getsemana() - outraMeta.getsemana();
	}

}
