/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.MenuView;

/**
 *
 * @author 84392
 */
public class test {

    public static void main(String[] args) {
        try {
            URL urlIconNotepad = test.class.getResource("education.png"); // create image
            Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            MenuView MVview = new MenuView();
            MVview.setIconImage(img);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | HeadlessException ex) {
            ex.printStackTrace();
        }

    }

}
