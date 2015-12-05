package devday.ensuarance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_categories")
public class VehicleCategory {
	
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
	
	public static VehicleCategory createInstance(String name)
	{
		VehicleCategory obj = new VehicleCategory();
		obj.setName(name);
		
		return obj;
	}

}
