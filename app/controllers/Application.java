package controllers;

import java.util.List;

import models.User;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    return ok("It's works");
  }
  
  public static Result insert1() {
	  User c = new User();
	  c.name = "xxxx";
	  c.address = "xxxx@foo.org";
	  c.save();
	  return ok("insert 1");
  }
  
  public static Result insert2() {
	  User c = new User();
	  c.name = "yyyy";
	  c.address = "yyyy@foo.org";
	  c.save();
	  return ok("insert 2");
  }
  
  public static Result findall() {
	  
	  return ok(User.all().toString());
  }
  
  public static Result deleteall() {
	  List<User> users = User.find.all();
	  for (User user : users) {
		  user.delete();
	  }
	  return ok("fini.");
  }
}