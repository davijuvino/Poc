package employees.b2w.digital.util;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import employees.b2w.digital.domain.entity.Trilha;

/**
 * @author Davi
 * @apiNote  implements object trilha do employees
 */
public class TrilhaCreator {
	public static Trilha createTrilhaToBeSaved() {	
		Trilha trilha = new Trilha();
		Map<String, String> mapper = new HashMap<String, String>();
		/* Collection<Cargo> collections = new ArrayList<>(); */
		
		trilha.setTrilha_nome("CLOUD AZURE");
		trilha.setDiretoria("TI");
		trilha.setMissao_formal("DEPARTAMENTO CLOUD");
		trilha.setMissao_alternativa("DEPARTAMENTO CLOUD");
		mapper.put("cargo_nome", "ANALISTA CLOUD");
		mapper.put("cargo_missao", "AUTOMACAO");
		mapper.put("data_atualizacao", "2021-05-01 20:35:02");
		/*
		 * collections.add((Cargo) mapper.values());
		 * trilha.setCargos(collections);
		 */
		trilha.setData_atualizacao(new Date());
		return trilha;
		
	}
}
