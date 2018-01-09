package com.iesemilidarder.fordummies.web;

import com.iesemilidarder.fordummies.core.DBObject;
import com.iesemilidarder.fordummies.core.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * dummies
 * com.iesemilidarder.fordummies.web
 * Created by alber in 14/12/2017.
 * Description:
 *
 *  User[] a;
 *
 *  a(10)
 */
public class Launcher {
    private static List<User> lUser = new ArrayList<User>();
    private static final Logger log = LoggerFactory.getLogger(Launcher.class);

    private static void init() {
        for (int i=0;i<10;i++){
            User user = new User();
            user.setId(i);
            user.setName("a"+i);
            user.save();
            lUser.add(user);
        }
        DBObject dbo = lUser.get(0);
        log.info("Loading finished");
    }

    public static void main(String... args) {
        init();
        port(8080);
        /*
        if (localhost) {
            String projectDir = System.getProperty("user.dir");
            String staticDir = "/src/main/resources/public";
            staticFiles.externalLocation(projectDir + staticDir);
        } else {
            staticFiles.location("/public");
        }*/
        get("/hello", (req, res) -> "Hello World");
    }

}
