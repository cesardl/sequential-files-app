package pe.edu.unmsm.fisi;

import pe.edu.unmsm.fisi.dao.impl.EmployeeDAOImpl;
import pe.edu.unmsm.fisi.view.JFrameMain;

/**
 * Hello world!
 *
 * @author Cesardl
 */
public class App {

    public static void main(String[] args) {
        if (EmployeeDAOImpl.getInstance().loadData()) {
            javax.swing.SwingUtilities.invokeLater(
                    () -> new JFrameMain().setVisible(true));
        } else {
            System.exit(1);
        }
    }
}
