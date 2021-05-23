package employees.b2w.digital.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "trilha")
public class Trilha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Size(max = 35)
	private String trilha_nome;

	@NotNull
	@Size(max = 30)
	private String diretoria;

	@NotNull
	@Size(max = 270)
	private String missao_formal;

	@NotNull
	@Size(max = 126)
	private String missao_alternativa;

	@OneToMany(mappedBy = "trilha", cascade = CascadeType.ALL)
	private Collection<Cargo> cargos = new ArrayList<>();

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date data_atualizacao;

	public Trilha() {

	}

	public Trilha(Integer id) {
		this.id = id;
	}

	public Trilha(@NotNull @Size(max = 35) String trilha_nome,
			@NotNull @Size(max = 30) String diretoria,
			@NotNull @Size(max = 270) String missao_formal,
			@NotNull @Size(max = 126) String missao_alternativa,
			Collection<Cargo> cargos, Date data_atualizacao) {
		super();
		this.trilha_nome = trilha_nome;
		this.diretoria = diretoria;
		this.missao_formal = missao_formal;
		this.missao_alternativa = missao_alternativa;
		this.cargos = cargos;
		this.data_atualizacao = data_atualizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTrilha_nome() {
		return trilha_nome;
	}

	public String getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(String diretoria) {
		this.diretoria = diretoria;
	}

	public String getMissao_formal() {
		return missao_formal;
	}

	public void setMissao_formal(String missao_formal) {
		this.missao_formal = missao_formal;
	}

	public String getMissao_alternativa() {
		return missao_alternativa;
	}

	public void setMissao_alternativa(String missao_alternativa) {
		this.missao_alternativa = missao_alternativa;
	}

	public void setTrilha_nome(String trilha_nome) {
		this.trilha_nome = trilha_nome;
	}

	public Collection<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(Collection<Cargo> cargos) {
		this.cargos = cargos;
		for (Cargo c : cargos) {
			c.setTrilha(this);
		}
	}

	public Date getData_atualizacao() {
		return data_atualizacao;
	}

	public void setData_atualizacao(Date data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	}

}
