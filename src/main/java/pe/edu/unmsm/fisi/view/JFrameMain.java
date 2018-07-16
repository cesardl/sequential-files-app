package pe.edu.unmsm.fisi.view;

import pe.edu.unmsm.fisi.model.Employee;
import pe.edu.unmsm.fisi.controller.EmployeeController;

/**
 * @author Cesardl
 */
public class JFrameMain extends javax.swing.JFrame {

    private static final long serialVersionUID = -7889697995515764467L;

    private final EmployeeController controller;
    private Employee employee;

    public JFrameMain() {
        initComponents();
        controller = EmployeeController.getInstance();
        loadData();
    }

    private void loadData() {
        try (java.io.FileReader fr = new java.io.FileReader("employees.txt");
                java.io.BufferedReader br = new java.io.BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                java.util.StringTokenizer st = new java.util.StringTokenizer(linea, ",");
                employee = new Employee();
                employee.setCode(Integer.parseInt(st.nextToken()));
                employee.setName(st.nextToken());
                employee.setSalary(Double.parseDouble(st.nextToken()));
                controller.addEmployee(employee);
            }
        } catch (java.io.IOException | NumberFormatException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
    }

    private void persistData() {
        try (java.io.FileWriter fw = new java.io.FileWriter("employees.txt");
                java.io.BufferedWriter bw = new java.io.BufferedWriter(fw)) {
            for (int i = 0; i < controller.totalOfEmployees(); i++) {
                employee = controller.getEmployee(i);
                System.out.println(i);
                bw.write(String.valueOf(employee.getCode() + ","
                        + employee.getName() + ","
                        + String.valueOf(employee.getSalary()) + ","
                        + employee.descuentos() + "," + employee.neto()) + "\n");
            }
        } catch (java.io.IOException ioe) {
            javax.swing.JOptionPane.showMessageDialog(this,"Error en grabacion del archivo: " + ioe.getMessage());
        }
    }

    private int leerCodigo() {
        try {
            return Integer.parseInt(textFieldCode.getText());
        } catch (NumberFormatException nfe) {
            return -666;
        }
    }

    private String leerNombre() {
        try {
            String nombre = textFieldName.getText();
            if (nombre.charAt(0) == ' ') {
                return nombre.trim();
            }
            return nombre;
        } catch (Exception e) {
            return null;
        }
    }

    private double leerSueldo() {
        try {
            return Double.parseDouble(textFieldSalary.getText());
        } catch (NumberFormatException nfe) {
            return -666;
        }
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
        javax.swing.JButton buttonDelete = new javax.swing.JButton();
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

        buttonDelete.setText("Borrar");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
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
                    .addComponent(buttonSave, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(buttonList, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(buttonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(buttonRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(buttonModify, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
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
                    .addComponent(buttonDelete)
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
        if (leerCodigo() == -666) {
            javax.swing.JOptionPane.showMessageDialog(this,"Ingrese codigo entrero");
        } else if (leerNombre() == null) {
            javax.swing.JOptionPane.showMessageDialog(this,"Ingrese nombre del empleado");
        } else if (leerSueldo() == -666) {
            javax.swing.JOptionPane.showMessageDialog(this,"Ingrese sueldo numerico");
        } else {
            employee = new Employee(leerCodigo(), leerNombre(), leerSueldo());
            if (controller.findEmployee(employee.getCode()) != -1) {
                javax.swing.JOptionPane.showMessageDialog(this,"Codigo Repetido");
            } else {
                controller.addEmployee(employee);
            }
            buttonDeleteActionPerformed(evt);
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetailActionPerformed
        int code = leerCodigo();
        if (code == -666) {
            javax.swing.JOptionPane.showMessageDialog(this,"Ingrese codigo entero");
        } else {
            int p = controller.findEmployee(code);
            if (p == -1) {
                javax.swing.JOptionPane.showMessageDialog(this,"Codigo NO EXISTE");
            } else {
                employee = controller.getEmployee(p);
                textFieldName.setText(employee.getName());
                textFieldSalary.setText(String.valueOf(employee.getSalary()));
                textAreaOutput.append(String.format("%-20s%-10d\n", "Codigo: ", employee.getCode()));
                textAreaOutput.append(String.format("%-20s%-30s\n", "Nombre: ", employee.getName()));
                textAreaOutput.append(String.format("%-20s%10.1f\n", "Sueldo: ", employee.getSalary()));
                textAreaOutput.append(String.format("%-20s%10.1f\n", "Descuento: ", employee.descuentos()));
                textAreaOutput.append(String.format("%-20s%10.1f\n", "Neto: ", employee.neto()));
            }
        }
    }//GEN-LAST:event_buttonDetailActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        textFieldCode.setText("");
        textFieldName.setText("");
        textFieldSalary.setText("");
        textAreaOutput.setText("");
        textFieldCode.requestFocus();
        repaint();
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifyActionPerformed
        if (leerCodigo() == -666) {
            javax.swing.JOptionPane.showMessageDialog(this,"Ingrese codigo entero");
            textFieldCode.requestFocus();
        } else if (leerNombre() == null) {
            javax.swing.JOptionPane.showMessageDialog(this,"Ingrese nombre del empleado");
            textFieldName.requestFocus();
        } else if (leerSueldo() == -666) {
            javax.swing.JOptionPane.showMessageDialog(this,"Ingrese sueldo numerico");
            textFieldSalary.requestFocus();
        } else {
            int p = controller.findEmployee(leerCodigo());
            employee = new Employee(leerCodigo(), leerNombre(), leerSueldo());
            if (p == -1) {
                controller.addEmployee(employee);
            } else {
                controller.setEmployee(p, employee);
            }
            buttonDeleteActionPerformed(evt);
        }
    }//GEN-LAST:event_buttonModifyActionPerformed

    private void buttonListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListActionPerformed
        if (controller.totalOfEmployees() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this,"Archivo vacio");
        } else {
            textAreaOutput.setText(String.format("%-8s%-30s%10s%10s%10s\n",
                    "Codigo", "Nombre", "Sueldo", "Dsctos", "Neto"));
            for (int i = 0; i < controller.totalOfEmployees(); i++) {
                employee = controller.getEmployee(i);
                textAreaOutput.append(String.format("%-8d", employee.getCode()));
                textAreaOutput.append(String.format("%-30s", employee.getName()));
                textAreaOutput.append(String.format("%-10.1f", employee.getSalary()));
                textAreaOutput.append(String.format("%-10.1f", employee.descuentos()));
                textAreaOutput.append(String.format("%-10.1f\n", employee.neto()));
            }
        }
    }//GEN-LAST:event_buttonListActionPerformed

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
        int code = leerCodigo();
        if (code == -666) {
            javax.swing.JOptionPane.showMessageDialog(this,"Ingrese codigo entero");
        } else {
            int p = controller.findEmployee(code);
            if (p == -1) {
                javax.swing.JOptionPane.showMessageDialog(this,"Codigo NO EXISTE");
            } else {
                employee = controller.getEmployee(p);
                textFieldName.setText(employee.getName());
                textFieldSalary.setText(String.valueOf(employee.getSalary()));
                textAreaOutput.setText(String.format("%-20s%-10d\n", "Codigo: ", employee.getCode()));
                textAreaOutput.append(String.format("%-20s%-30s\n", "Nombre: ", employee.getName()));
                textAreaOutput.append(String.format("%-20s%10.1f\n", "Sueldo: ", employee.getSalary()));
                textAreaOutput.append(String.format("%-20s%10.1f\n", "Descuento: ", employee.descuentos()));
                textAreaOutput.append(String.format("%-20s%10.1f\n", "Neto: ", employee.neto()));
            }
            int option = javax.swing.JOptionPane.showConfirmDialog(this,
                    "Esta seguro de Eliminar a este empleado", "Responder", 0);
            if (option == 0) {
                controller.removeEmployee(p);
            }
        }
        buttonDeleteActionPerformed(evt);
    }//GEN-LAST:event_buttonRemoveActionPerformed

    private void buttonExitAndPersistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitAndPersistActionPerformed
        persistData();
        System.exit(0);
    }//GEN-LAST:event_buttonExitAndPersistActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea textAreaOutput;
    private javax.swing.JTextField textFieldCode;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldSalary;
    // End of variables declaration//GEN-END:variables
}
