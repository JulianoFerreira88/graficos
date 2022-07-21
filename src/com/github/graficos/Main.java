package com.github.graficos;

import com.github.graficos.views.MainView;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.UIManager;

public class Main {

    public static Properties p = new Properties();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            p.load(new FileInputStream(new File("C:/db.properties")));

            Connection con = DriverManager.getConnection(
                    p.getProperty("url"),
                    p.getProperty("user"),
                    p.getProperty("pass"));
            File f = new File("C:/sql");
            File[] files = f.listFiles();
            MainView view = new MainView(con, files);
            Image image = Toolkit.getDefaultToolkit().getImage("img/pig48.png");

            view.setIconImage(image);
            view.setVisible(true);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
