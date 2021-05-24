package employees.b2w.digital.util;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import employees.b2w.digital.domain.entity.Trilha;
import employees.b2w.digital.domain.model.TrilhaModel;

/**
 * @author Davi
 * @apiNote  implements object trilha do employees
 */
public class TrilhaCreator {
	public static Trilha createTrilhaToBeSaved() {	
		Trilha trilha = new Trilha();
		
		trilha.setTrilha_nome("CLOUD AZURE");
		trilha.setDiretoria("TI");
		trilha.setMissao_formal("DEPARTAMENTO CLOUD");
		trilha.setMissao_alternativa("DEPARTAMENTO CLOUD");
		trilha.setData_atualizacao(new Date());
		return trilha;
		
	}
	
	public static Trilha createValidTrilha() {
		Trilha trilha = new Trilha();
		trilha.setId(1);
		trilha.setTrilha_nome("CLOUD AZURE");
		trilha.setDiretoria("TI");
		trilha.setMissao_formal("DEPARTAMENTO CLOUD");
		trilha.setMissao_alternativa("DEPARTAMENTO CLOUD");
		trilha.setData_atualizacao(new Date());
		
		return trilha;
	}
	
	public static TrilhaModel createValidTrilhaModel() {
		TrilhaModel trilhaModel = new TrilhaModel();
		trilhaModel.setId(1);
		trilhaModel.setTrilha_nome("CLOUD AZURE");
		trilhaModel.setDiretoria("TI");
		trilhaModel.setMissao_formal("DEPARTAMENTO CLOUD");
		trilhaModel.setMissao_alternativa("DEPARTAMENTO CLOUD");
		trilhaModel.setData_atualizacao(new Date());
		
		return trilhaModel;
	}
}
