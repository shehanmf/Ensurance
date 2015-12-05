package devday.ensuarance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_types")
public class InsuaranceType {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static InsuaranceType createInstance(String name)
	{
		InsuaranceType type = new InsuaranceType();
		type.setName(name);
		
		return type;
	}

}
