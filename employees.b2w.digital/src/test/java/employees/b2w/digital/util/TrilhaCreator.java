package employees.b2w.digital.util;
import java.util.Date;

import employees.b2w.digital.domain.entity.Trilha;
import employees.b2w.digital.domain.mapper.TrilhaMapper;

/**
 * @author Davi
 * @apiNote  implements object trilha do employees
 */
public class TrilhaCreator {
	public static Trilha createTrilhaToBeSaved() {	
		Trilha trilha = new Trilha();
		
		trilha.setTrilha_nome("CLOUD AMAZON");
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
	
	public static Trilha createValidUpdateTrilha() {
		Trilha trilha = new Trilha();
		trilha.setId(1);
		trilha.setTrilha_nome("ATUALIZACAO");
		trilha.setDiretoria("TI ATUALIZACAO");
		trilha.setMissao_formal("DEPARTAMENTO CLOUD ATUALIZACAO");
		trilha.setMissao_alternativa("DEPARTAMENTO CLOUD ATUALIZACAO");
		trilha.setData_atualizacao(new Date());
		
		return trilha;
	}
	
	public static TrilhaMapper createValidTrilhaMapper() {
		TrilhaMapper trilhaMapper = new TrilhaMapper();
		trilhaMapper.setId(1);
		trilhaMapper.setTrilha_nome("CLOUD AZURE");
		trilhaMapper.setDiretoria("TI");
		trilhaMapper.setMissao_formal("DEPARTAMENTO CLOUD");
		trilhaMapper.setMissao_alternativa("DEPARTAMENTO CLOUD");
		trilhaMapper.setData_atualizacao(new Date());
		
		return trilhaMapper;
	}
	
}
