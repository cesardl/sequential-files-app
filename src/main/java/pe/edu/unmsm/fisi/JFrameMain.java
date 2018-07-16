package pe.edu.unmsm.fisi;

public class JFrameMain extends javax.swing.JFrame {

    public Employee empleado;
    public ArregloEmpleados alEmpleados;

    public JFrameMain() {
        initComponents();
        alEmpleados = new ArregloEmpleados();
        cargarData();
    }

    private void cargarData() {
        try (java.io.FileReader fr = new java.io.FileReader("empleados.txt");
                java.io.BufferedReader br = new java.io.BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                java.util.StringTokenizer st
                        = new java.util.StringTokenizer(linea, ",");
                empleado = new Employee();
                empleado.setCodigo(Integer.parseInt(st.nextToken()));
                empleado.setNombre(st.nextToken());
                empleado.setSueldo(Double.parseDouble(st.nextToken()));
                alEmpleados.addEmpleado(empleado);
            }
        } catch (java.io.IOException | NumberFormatException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
    }

    private void grabarData() {
        try (java.io.FileWriter fw = new java.io.FileWriter("empleados.txt");
                java.io.BufferedWriter bw = new java.io.BufferedWriter(fw)) {
            for (int i = 0; i < alEmpleados.numeroEmpleados(); i++) {
                empleado = alEmpleados.getEmpleado(i);
                System.out.println(i);
                bw.write(String.valueOf(empleado.getCodigo() + ","
                        + empleado.getNombre() + ","
                        + String.valueOf(empleado.getSueldo()) + ","
                        + empleado.descuentos() + "," + empleado.neto()) + "\n");
            }
        } catch (java.io.IOException ioe) {
            mensaje("Error en grabacion del archivo: " + ioe.getMessage());
        }
    }

    public void mensaje(String s) {
        javax.swing.JOptionPane.showMessageDialog(this, s);
    }

    private int leerCodigo() {
        try {
            return Integer.parseInt(jTextFieldCodigo.getText());
        } catch (NumberFormatException nfe) {
            return -666;
        }
    }

    private String leerNombre() {
        try {
            String nombre = jTextFieldNombre.getText();
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
            return Double.parseDouble(jTextFieldSueldo.getText());
        } catch (NumberFormatException nfe) {
            return -666;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanelGnral = new javax.swing.JPanel();
        javax.swing.JPanel jPanelIngreso = new javax.swing.JPanel();
        javax.swing.JLabel jLabelCodigo = new javax.swing.JLabel();
        javax.swing.JLabel jLabelNombre = new javax.swing.JLabel();
        javax.swing.JLabel jLabelSueldo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldSueldo = new javax.swing.JTextField();
        javax.swing.JButton jButtonIngresar = new javax.swing.JButton();
        javax.swing.JButton jButtonBorrar = new javax.swing.JButton();
        javax.swing.JButton jButtonListar = new javax.swing.JButton();
        javax.swing.JButton jButtonConsultar = new javax.swing.JButton();
        javax.swing.JButton jButtonModificar = new javax.swing.JButton();
        javax.swing.JButton jButtonEliminar = new javax.swing.JButton();
        javax.swing.JPanel jPanelSalida = new javax.swing.JPanel();
        javax.swing.JScrollPane jScrollPaneSalida = new javax.swing.JScrollPane();
        jTextAreaSalida = new javax.swing.JTextArea();
        javax.swing.JButton jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Archivos Secuenciales");

        jPanelIngreso.setBorder(javax.swing.BorderFactory.createTitledBorder("Archivos de Texto"));

        jLabelCodigo.setText("Codigo:");

        jLabelNombre.setText("Nombre:");

        jLabelSueldo.setText("Sueldo:");

        jButtonIngresar.setText("Ingresar");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButtonListar.setText("Listar");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelIngresoLayout = new javax.swing.GroupLayout(jPanelIngreso);
        jPanelIngreso.setLayout(jPanelIngresoLayout);
        jPanelIngresoLayout.setHorizontalGroup(
            jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jLabelSueldo, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldSueldo, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jButtonListar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jButtonBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jButtonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelIngresoLayout.setVerticalGroup(
            jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIngresoLayout.createSequentialGroup()
                        .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addComponent(jButtonIngresar)
                    .addComponent(jButtonConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrar)
                    .addComponent(jButtonModificar)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonListar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jTextFieldSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelSalida.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextAreaSalida.setColumns(20);
        jTextAreaSalida.setEditable(false);
        jTextAreaSalida.setRows(5);
        jScrollPaneSalida.setViewportView(jTextAreaSalida);

        jButtonSalir.setText("Salir Grabando");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSalidaLayout = new javax.swing.GroupLayout(jPanelSalida);
        jPanelSalida.setLayout(jPanelSalidaLayout);
        jPanelSalidaLayout.setHorizontalGroup(
            jPanelSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalidaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelSalidaLayout.setVerticalGroup(
            jPanelSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelGnralLayout = new javax.swing.GroupLayout(jPanelGnral);
        jPanelGnral.setLayout(jPanelGnralLayout);
        jPanelGnralLayout.setHorizontalGroup(
            jPanelGnralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGnralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGnralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelSalida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelIngreso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelGnralLayout.setVerticalGroup(
            jPanelGnralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGnralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGnral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGnral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        if (leerCodigo() == -666) {
            mensaje("Ingrese codigo entrero");
        } else if (leerNombre() == null) {
            mensaje("Ingrese nombre del empleado");
        } else if (leerSueldo() == -666) {
            mensaje("Ingrese sueldo numerico");
        } else {
            empleado = new Employee(leerCodigo(), leerNombre(), leerSueldo());
            if (alEmpleados.buscaEmpleado(empleado.getCodigo()) != -1) {
                mensaje("Codigo Repetido");
            } else {
                alEmpleados.addEmpleado(empleado);
            }
            jButtonBorrarActionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonIngresarActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        int codigo = leerCodigo();
        if (codigo == -666) {
            mensaje("Ingrese codigo entero");
        } else {
            int p = alEmpleados.buscaEmpleado(codigo);
            if (p == -1) {
                mensaje("Codigo NO EXISTE");
            } else {
                empleado = alEmpleados.getEmpleado(p);
                jTextFieldNombre.setText(empleado.getNombre());
                jTextFieldSueldo.setText(String.valueOf(empleado.getSueldo()));
                jTextAreaSalida.append(String.format(
                        "%-20s%-10d\n", "Codigo: ", empleado.getCodigo()));
                jTextAreaSalida.append(String.format(
                        "%-20s%-30s\n", "Nombre: ", empleado.getNombre()));
                jTextAreaSalida.append(String.format(
                        "%-20s%10.1f\n", "Sueldo: ", empleado.getSueldo()));
                jTextAreaSalida.append(String.format(
                        "%-20s%10.1f\n", "Descuento: ", empleado.descuentos()));
                jTextAreaSalida.append(String.format(
                        "%-20s%10.1f\n", "Neto: ", empleado.neto()));
            }
        }
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        jTextFieldCodigo.setText("");
        jTextFieldNombre.setText("");
        jTextFieldSueldo.setText("");
        jTextAreaSalida.setText("");
        jTextFieldCodigo.requestFocus();
        repaint();
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (leerCodigo() == -666) {
            mensaje("Ingrese codigo entero");
            jTextFieldCodigo.requestFocus();
        } else if (leerNombre() == null) {
            mensaje("Ingrese nombre del empleado");
            jTextFieldNombre.requestFocus();
        } else if (leerSueldo() == -666) {
            mensaje("Ingrese sueldo numerico");
            jTextFieldSueldo.requestFocus();
        } else {
            mensaje("Ingrese los datos a modificar");
            int p = alEmpleados.buscaEmpleado(leerCodigo());
            empleado = new Employee(leerCodigo(), leerNombre(), leerSueldo());
            if (p == -1) {
                alEmpleados.addEmpleado(empleado);
            } else {
                alEmpleados.setEmpleado(p, empleado);
            }
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
        if (alEmpleados.numeroEmpleados() == 0) {
            mensaje("Archivo vacio");
        } else {
            jTextAreaSalida.setText(String.format("%-8s%-30s%10s%10s%10s\n",
                    "Codigo", "Nombre", "Sueldo", "Dsctos", "Neto"));
            for (int i = 0; i < alEmpleados.numeroEmpleados(); i++) {
                empleado = alEmpleados.getEmpleado(i);
                jTextAreaSalida.append(String.format("%-8d", empleado.getCodigo()));
                jTextAreaSalida.append(String.format("%-30s", empleado.getNombre()));
                jTextAreaSalida.append(String.format("%-10.1f", empleado.getSueldo()));
                jTextAreaSalida.append(String.format("%-10.1f", empleado.descuentos()));
                jTextAreaSalida.append(String.format("%-10.1f\n", empleado.neto()));
            }
        }
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int codigo = leerCodigo();
        if (codigo == -666) {
            mensaje("Ingrese codigo entero");
        } else {
            int p = alEmpleados.buscaEmpleado(codigo);
            if (p == -1) {
                mensaje("Codigo NO EXISTE");
            } else {
                empleado = alEmpleados.getEmpleado(p);
                jTextFieldNombre.setText(empleado.getNombre());
                jTextFieldSueldo.setText(String.valueOf(empleado.getSueldo()));
                jTextAreaSalida.setText(String.format("%-20s%-10d\n", "Codigo: ", empleado.getCodigo()));
                jTextAreaSalida.append(String.format("%-20s%-30s\n", "Nombre: ", empleado.getNombre()));
                jTextAreaSalida.append(String.format("%-20s%10.1f\n", "Sueldo: ", empleado.getSueldo()));
                jTextAreaSalida.append(String.format("%-20s%10.1f\n", "Descuento: ", empleado.descuentos()));
                jTextAreaSalida.append(String.format("%-20s%10.1f\n", "Neto: ", empleado.neto()));
            }
            int option = javax.swing.JOptionPane.showConfirmDialog(this,
                    "Esta seguro de Eliminar a este empleado", "Responder", 0);
            if (option == 0) {
                alEmpleados.sacaEmpleado(p);
            }
        }
        jButtonBorrarActionPerformed(evt);
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        grabarData();
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea jTextAreaSalida;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldSueldo;
    // End of variables declaration//GEN-END:variables
}
