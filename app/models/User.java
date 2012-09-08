package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

/**
 * Company entity managed by Ebean
 */
@Entity 
public class User extends Model {

    @Id
    public Long id;
    
    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public String address;
    
    /**
     * Generic query helper for entity Company with id Long
     */
    public static Model.Finder<Long,User> find = new Model.Finder<Long,User>(Long.class, User.class);

    public static List<Map<String,String>> all() {
        
        List<Map<String, String>> all = new ArrayList<Map<String, String>>();
        for(User c: User.find.orderBy("name").findList()) {
        	LinkedHashMap<String,String> m = new LinkedHashMap<String,String>();
        	m.put("name", c.name);
        	m.put("address", c.address);
        	m.put("id",  c.id.toString());
            all.add(m);    
        }
        return all;
    }
}

