package pe.edu.unmsm.fisi;

import pe.edu.unmsm.fisi.controller.EmployeeController;
import pe.edu.unmsm.fisi.view.JFrameMain;

/**
 * Hello world!
 *
 * @author Cesardl
 */
public class App {

    public static void main(String[] args) {
        boolean hasBeenLoaded = EmployeeController.getInstance().loadData();
        if (hasBeenLoaded) {
            javax.swing.SwingUtilities.invokeLater(
                    () -> new JFrameMain().setVisible(true));
        } else {
            System.exit(1);
        }
    }
}
