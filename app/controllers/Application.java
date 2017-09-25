package controllers;

import play.db.Database;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.dbtest;
import views.html.index;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Application extends Controller {

    private Database database;

    @Inject
    public Application(Database db){
        this.database = db;
    }

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    public Result dbTest() throws SQLException {

        /*
        Check to make sure that the page contains some text that we
        want it to contain
        */

        Connection conn = database.getConnection(); // TODO: fix breaking on too many reloads
        // Make sure that there is a tenth element in the table
        ResultSet a = conn.prepareStatement("select * from test where id = 10 and name = 'testing'").executeQuery();
        a.next();
        ArrayList<String> bro = new ArrayList<String>();
        bro.add(a.getString("name"));

        return ok(dbtest.render(bro));
    }

}
