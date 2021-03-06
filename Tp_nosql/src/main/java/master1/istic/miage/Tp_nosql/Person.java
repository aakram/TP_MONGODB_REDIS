package master1.istic.miage.Tp_nosql;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity
public class Person {
	@Id
	private ObjectId id ;
	private String name;

	@Reference
	private List<Address> address;

	public Person() {
		address = new ArrayList<Address>();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address=address;
	}
	public void addAddress(Address address) {
		this.address.add(address);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}

}
