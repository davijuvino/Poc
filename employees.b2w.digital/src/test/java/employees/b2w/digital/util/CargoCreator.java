package employees.b2w.digital.util;

import java.util.Date;
import employees.b2w.digital.domain.entity.Cargo;

/**
 * @author Davi
 * @apiNote  implements object cargo do employees
 */
public class CargoCreator {
	public static Cargo createCargoToBeSaved() {
		Cargo cargo = new Cargo();
		cargo.setCargo_nome("ANALISTA CLOUD");
		cargo.setCargo_missao("ANALISTA DE IMPLEMENTACAO AUTOMACAO");
		cargo.setData_atualizacao(new Date());
		return cargo;
	}
}
