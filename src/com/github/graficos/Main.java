package com.github.graficos;

import com.github.graficos.views.MainView1;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Properties p = new Properties();
            p.load(new FileInputStream(new File("C:/db.properties")));
            Connection con = DriverManager.getConnection(
                    p.getProperty("url"),
                    p.getProperty("user"),
                    p.getProperty("pass"));
            File f = new File("C:/sql");
            File[] files = f.listFiles();
            MainView1 view = new MainView1(con, files);
            
            view.setVisible(true);
           

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
