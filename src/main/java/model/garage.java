/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 27, 2023
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "GARAGES")
public class garage {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "GARAGE_NAME")
	private String garageName;
	@ManyToOne(cascade = CascadeType.MERGE)
	private owner garageOwner;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval=true)
	private List<car> cars;
	
	public garage() {}
	
	public garage(int id, String garageName, owner garageOwner, List<car> cars) {
		this.id = id;
		this.garageName = garageName;
		this.garageOwner = garageOwner;
		this.cars = cars;
	}
	
	public garage(String garageName, owner garageOwner, List<car> cars) {
		this.garageName = garageName;
		this.garageOwner = garageOwner;
		this.cars = cars;
	}
	
	public garage(String garageName, owner garageOwner) {
		this.garageName = garageName;
		this.garageOwner = garageOwner;
	}

	public int getId() {
		return id;
	}

	public String getGarageName() {
		return garageName;
	}

	public owner getGarageOwner() {
		return garageOwner;
	}

	public List<car> getCars() {
		return cars;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}

	public void setGarageOwner(owner garageOwner) {
		this.garageOwner = garageOwner;
	}

	public void setCars(List<car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "garage [id=" + id + ", garageName=" + garageName + ", garageOwner=" + garageOwner + ", cars=" + cars
				+ "]";
	}
}
