package employees.b2w.digital.util;

import java.util.Date;
import employees.b2w.digital.domain.entity.Cargo;
import employees.b2w.digital.domain.entity.Trilha;

/**
 * @author Davi
 * @apiNote  implements object cargo do employees
 */
public class CargoCreator {
	public static Cargo createCargoToBeSaved() {
		Cargo cargo = new Cargo();
		cargo.setCargo_nome("ANALISTA CLOUD");
		cargo.setCargo_missao("ANALISTA DE IMPLEMENTACAO AUTOMACAO");
		cargo.setTrilha(new Trilha(1));
		cargo.setData_atualizacao(new Date());
		return cargo;
	}
	
	public static Cargo createValidCargo() {
		Cargo cargo = new Cargo();
		cargo.setId(1);
		cargo.setCargo_nome("ANALISTA CLOUD");
		cargo.setCargo_missao("ANALISTA DE IMPLEMENTACAO AUTOMACAO");
		cargo.setTrilha(new Trilha(1));
		cargo.setData_atualizacao(new Date());
		return cargo;
	}
	
	public static Cargo createValidUpdateCargo() {
		Cargo cargo = new Cargo();
		cargo.setId(1);
		cargo.setCargo_nome("ANALISTA CLOUD ATUALIZADO");
		cargo.setCargo_missao("ANALISTA DE IMPLEMENTACAO AUTOMACAO ATUALIZADO");
		cargo.setTrilha(new Trilha(1));
		cargo.setData_atualizacao(new Date());
		return cargo;
	}
}
