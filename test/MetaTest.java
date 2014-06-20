import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Meta;
import models.Prioridade;
import models.PrioridadeComparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MetaTest {

	private List<Meta> metas;

	@Before
	public void setUp() {
		metas = new ArrayList<Meta>();
		metas.add(new Meta("meta01", "desc", 1, Prioridade.Media, false));
		metas.add(new Meta("meta02", "desc", 1, Prioridade.Baixa, false));
		metas.add(new Meta("meta03", "desc", 1, Prioridade.Alta, false));

	}

	@Test
	public void deveOrdenarPorPrioridade() {
		Collections.sort(metas, new PrioridadeComparator());
		Assert.assertEquals(Prioridade.Baixa, metas.get(0).getPrioridade());
	}
}
