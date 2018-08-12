package pe.edu.unmsm.fisi.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.edu.unmsm.fisi.controller.EmployeeController;
import pe.edu.unmsm.fisi.dao.impl.EmployeeDAOImpl;
import pe.edu.unmsm.fisi.exceptions.EmployeeAlreadyExistsException;
import pe.edu.unmsm.fisi.exceptions.EmployeeNotFoundException;
import pe.edu.unmsm.fisi.exceptions.NoDataException;
import pe.edu.unmsm.fisi.exceptions.WrongEmployeeFieldException;
import pe.edu.unmsm.fisi.model.Employee;

/**
 * @author Cesardl
 */
public class JFrameMain extends javax.swing.JFrame {

    private static final long serialVersionUID = -7889697995515764467L;

    private static final Logger LOG = LoggerFactory.getLogger(JFrameMain.class);

    private final EmployeeController controller;

    public JFrameMain() {
        initComponents();
        controller = new EmployeeController(EmployeeDAOImpl.getInstance());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel panelGeneral = new javax.swing.JPanel();
        javax.swing.JPanel panelInput = new javax.swing.JPanel();
        javax.swing.JLabel labelCode = new javax.swing.JLabel();
        javax.swing.JLabel labelName = new javax.swing.JLabel();
        javax.swing.JLabel labelSalary = new javax.swing.JLabel();
        textFieldCode = new javax.swing.JTextField();
        textFieldName = new javax.swing.JTextField();
        textFieldSalary = new javax.swing.JTextField();
        javax.swing.JButton buttonSave = new javax.swing.JButton();
        javax.swing.JButton buttonClear = new javax.swing.JButton();
        javax.swing.JButton buttonList = new javax.swing.JButton();
        javax.swing.JButton buttonDetail = new javax.swing.JButton();
        javax.swing.JButton buttonModify = new javax.swing.JButton();
        javax.swing.JButton buttonRemove = new javax.swing.JButton();
        javax.swing.JPanel panelOutput = new javax.swing.JPanel();
        javax.swing.JScrollPane scrollPaneOutput = new javax.swing.JScrollPane();
        textAreaOutput = new javax.swing.JTextArea();
        javax.swing.JButton buttonExitAndPersist = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Archivos Secuenciales");

        panelInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Archivos de Texto"));

        labelCode.setText("Codigo:");

        labelName.setText("Nombre:");

        labelSalary.setText("Sueldo:");

        buttonSave.setText("Ingresar");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonClear.setText("Limpiar");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        buttonList.setText("Listar");
        buttonList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListActionPerformed(evt);
            }
        });

        buttonDetail.setText("Consultar");
        buttonDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetailActionPerformed(evt);
            }
        });

        buttonModify.setText("Modificar");
        buttonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifyActionPerformed(evt);
            }
        });

        buttonRemove.setText("Eliminar");
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInputLayout = new javax.swing.GroupLayout(panelInput);
        panelInput.setLayout(panelInputLayout);
        panelInputLayout.setHorizontalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelCode, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(labelSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(textFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(textFieldCode, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonList, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonModify, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelInputLayout.setVerticalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelCode, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonSave)
                    .addComponent(buttonDetail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonClear)
                    .addComponent(buttonModify)
                    .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonList)
                    .addComponent(buttonRemove)
                    .addComponent(textFieldSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        textAreaOutput.setEditable(false);
        textAreaOutput.setColumns(20);
        textAreaOutput.setRows(5);
        scrollPaneOutput.setViewportView(textAreaOutput);

        buttonExitAndPersist.setText("Salir Grabando");
        buttonExitAndPersist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitAndPersistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOutputLayout = new javax.swing.GroupLayout(panelOutput);
        panelOutput.setLayout(panelOutputLayout);
        panelOutputLayout.setHorizontalGroup(
            panelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOutputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(buttonExitAndPersist, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelOutputLayout.setVerticalGroup(
            panelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOutputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonExitAndPersist)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelOutput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        LOG.trace(evt.paramString());
        try {
            controller.save(textFieldCode.getText(), textFieldName.getText(), textFieldSalary.getText());

            javax.swing.JOptionPane.showMessageDialog(this, "Datos del empleado fueron guardados correctamente", getTitle(), javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (WrongEmployeeFieldException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());

            processWrongExceptionOnField(ex.getErrorLocation());
        } catch (EmployeeAlreadyExistsException ex) {
            LOG.error(ex.getMessage(), ex);
            javax.swing.JOptionPane.showMessageDialog(this, "Código de empleado ya existe");
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetailActionPerformed
        LOG.trace(evt.paramString());
        try {
            Employee employee = controller.find(textFieldCode.getText());

            textFieldName.setText(employee.getName());
            textFieldSalary.setText(String.valueOf(employee.getSalary()));

            textAreaOutput.setText(String.format("%-20s%-10d%n", "Codigo: ", employee.getCode()));
            textAreaOutput.append(String.format("%-20s%-30s%n", "Nombre: ", employee.getName()));
            textAreaOutput.append(String.format("%-20s%10.1f%n", "Sueldo: ", employee.getSalary()));
            textAreaOutput.append(String.format("%-20s%10.1f%n", "Descuento: ", employee.descuentos()));
            textAreaOutput.append(String.format("%-20s%10.1f%n", "Neto: ", employee.neto()));

        } catch (WrongEmployeeFieldException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
            textFieldCode.requestFocus();
            textFieldCode.selectAll();

        } catch (EmployeeNotFoundException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Código de empleado no registrado");
        }
    }//GEN-LAST:event_buttonDetailActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        LOG.trace(evt.paramString());
        textFieldCode.setText("");
        textFieldName.setText("");
        textFieldSalary.setText("");
        textAreaOutput.setText("");
        textFieldCode.requestFocus();
        repaint();
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifyActionPerformed
        LOG.trace(evt.paramString());
        try {
            controller.modify(textFieldCode.getText(), textFieldName.getText(), textFieldSalary.getText());

            javax.swing.JOptionPane.showMessageDialog(this, "Datos del empleado fueron modificados correctamente", getTitle(), javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (WrongEmployeeFieldException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());

            processWrongExceptionOnField(ex.getErrorLocation());
        } catch (EmployeeNotFoundException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Código de empleado no registrado");
        }
    }//GEN-LAST:event_buttonModifyActionPerformed

    private void buttonListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListActionPerformed
        LOG.trace(evt.paramString());
        try {
            textAreaOutput.setText(String.format("%-8s%-30s%10s%10s%10s%n",
                    "Codigo", "Nombre", "Sueldo", "Dsctos", "Neto"));
            textAreaOutput.append(controller.list());
        } catch (NoDataException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_buttonListActionPerformed

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
        LOG.trace(evt.paramString());
        try {
            boolean result = controller.delete(textFieldCode.getText());

            if (result) {
                buttonClearActionPerformed(evt);

            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Código de empleado no registrado");
            }

        } catch (WrongEmployeeFieldException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
            textFieldCode.requestFocus();
            textFieldCode.selectAll();

        }
    }//GEN-LAST:event_buttonRemoveActionPerformed

    private void buttonExitAndPersistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitAndPersistActionPerformed
        LOG.trace(evt.paramString());
        controller.persist();
        System.exit(0);
    }//GEN-LAST:event_buttonExitAndPersistActionPerformed

    private void processWrongExceptionOnField(WrongEmployeeFieldException.ErrorLocation errorLocation) {
        switch (errorLocation) {
            case CODE:
                textFieldCode.requestFocus();
                break;

            case NAME:
                textFieldName.requestFocus();
                break;

            case SALARY:
                textFieldSalary.requestFocus();
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea textAreaOutput;
    private javax.swing.JTextField textFieldCode;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldSalary;
    // End of variables declaration//GEN-END:variables
}
