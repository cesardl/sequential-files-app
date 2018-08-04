package pe.edu.unmsm.fisi;

import pe.edu.unmsm.fisi.dao.EmployeeDAO;
import pe.edu.unmsm.fisi.view.JFrameMain;

/**
 * Hello world!
 *
 * @author Cesardl
 */
public class App {

    public static void main(String[] args) {
        if (EmployeeDAO.getInstance().loadData()) {
            javax.swing.SwingUtilities.invokeLater(
                    () -> new JFrameMain().setVisible(true));
        } else {
            System.exit(1);
        }
    }
}
