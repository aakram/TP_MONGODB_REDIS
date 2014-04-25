package master1.istic.miage.Tp_nosql;

import java.net.UnknownHostException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

public class MongoTest {
	
	public static void main( String[] args ) throws UnknownHostException

	{

		boolean val=false;
	    Morphia morphia = new Morphia();   

	    Mongo mongo = new Mongo();

	    morphia.map(Person.class);

	    Datastore ds = morphia.createDatastore(mongo, "my_database");


	    Person p = new Person();

	    p.setName("Tintin");

	    Address address = new Address();

	    address.setStreet("123 Some street");

	    address.setCity("Some city");

	    address.setPostCode("123 456");

	    address.setCountry("Some country");

	    //set address

	    p.addAddress(address);

	    // Save the POJO
	  
	    
	    ds.save(address);
	    for (Person e : ds.find(Person.class)){
    		if(e.getName().equals(p.getName())){
    			val = true;
    			System.out.println("Personne deja existante");
    			break;
    		}
	    
	    }
	    if(!val){
	    	ds.save(p);	
	    	System.out.println("Nouvelle Personne");
	    }
	    
	    for (Person e : ds.find(Person.class)){
	    	System.out.println("Liste des personnes");
	         System.err.println(e);
	    }
	}

}
