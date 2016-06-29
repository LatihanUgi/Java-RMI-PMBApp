/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionclient;

import javax.swing.*;

public class AdmissionClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater (new Runnable()
        {
            @Override
            public void run()
            {
                LoginForm log = new LoginForm();
                log.setVisible(true);
            }
        });
    }
    
}
