package employees.b2w.digital.domain.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class TrilhaModel {

	private Integer id;
	private String trilha_nome;
	private String diretoria;
	private String missao_formal;
	private String missao_alternativa;	
	
	@Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date data_atualizacao;
}
