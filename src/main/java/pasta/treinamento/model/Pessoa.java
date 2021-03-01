package pasta.treinamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sobrenome")
	private String sobrenome;
	
	//foreign key
	
	@ManyToOne
	@JoinColumn(name = "sala1_id")
	private Sala sala1;
	
	@ManyToOne
	@JoinColumn(name = "sala2_id")
	private Sala sala2;
	
	@ManyToOne
	@JoinColumn(name = "cafe1_id")
	private Cafe cafe1;

	@ManyToOne
	@JoinColumn(name = "cafe2_id")
	private Cafe cafe2;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	// foreign key

	public Sala getSala1() {
		return sala1;
	}

	public void setSala1(Sala sala1) {
		this.sala1 = sala1;
	}

	public Sala getSala2() {
		return sala2;
	}

	public void setSala2(Sala sala2) {
		this.sala2 = sala2;
	}

	public Cafe getCafe1() {
		return cafe1;
	}

	public void setCafe1(Cafe cafe1) {
		this.cafe1 = cafe1;
	}

	public Cafe getCafe2() {
		return cafe2;
	}

	public void setCafe2(Cafe cafe2) {
		this.cafe2 = cafe2;
	}

}
