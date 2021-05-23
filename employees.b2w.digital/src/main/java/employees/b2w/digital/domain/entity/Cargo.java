package employees.b2w.digital.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Davi
 * @apiNote table implements cargo do employees
 */
@Entity
@Table(name = "cargo", indexes = {
		@Index(name = "trilha_id", columnList = "trilha_id")})
public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(required = false)
	private Integer id;

	@NotNull
	@Size(max = 53)
	private String cargo_nome;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "trilha_id")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty(value = "trilha_id")
	@Schema(required = false)
	private Trilha trilha;

	@NotNull
	@Size(max = 492)
	private String cargo_missao;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date data_atualizacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCargo_nome() {
		return cargo_nome;
	}

	public void setCargo_nome(String cargo_nome) {
		this.cargo_nome = cargo_nome;
	}

	public Trilha getTrilha() {
		return trilha;
	}

	public void setTrilha(Trilha trilha) {
		this.trilha = trilha;
	}

	public String getCargo_missao() {
		return cargo_missao;
	}

	public void setCargo_missao(String cargo_missao) {
		this.cargo_missao = cargo_missao;
	}

	public Date getData_atualizacao() {
		return data_atualizacao;
	}

	public void setData_atualizacao(Date data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	}

	/**
	 * @author Davi
	 * @param trilhaId
	 * 
	 *            Method include Id by cargo saved public Cargo
	 *            setTrilhaId(Integer trilhaId)
	 * @return now object with value updated
	 */
	public Cargo setTrilhaId(Integer trilhaId) {
		this.setTrilha(new Trilha(trilhaId));
		return this;
	}

}