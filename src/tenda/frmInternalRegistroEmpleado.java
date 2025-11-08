/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tenda;
import javax.swing.ButtonGroup;
import java.text.SimpleDateFormat;
/**
 *
 * @author kevin
 */
public class frmInternalRegistroEmpleado extends javax.swing.JInternalFrame {
    private javax.swing.ButtonGroup buttonGroupSexo;
    private static int nextIdEmpleado = 1;
    private java.util.Random random = new java.util.Random();
    
    /**
     * Creates new form frmInternalRegistroEmpleado
     */
    public frmInternalRegistroEmpleado() {
        initComponents();
        buttonGroupSexo = new javax.swing.ButtonGroup();
        buttonGroupSexo.add(RButtonMasculino);
        buttonGroupSexo.add(RButtonFemenino);
        
        TxtIdEmpleado.setText(String.valueOf(nextIdEmpleado));
        nextIdEmpleado++; 
        
        // 2. Generar y asignar la Clave aleatoria
        TxtClave.setText(generarClaveAleatoria());
        
        // 3. Deshabilitar edición para ID y Clave
        TxtIdEmpleado.setEditable(false);
        TxtClave.setEditable(false);
        
        
        JTabRegistro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                // El índice 3 corresponde a la pestaña "Validar Datos" (es la cuarta pestaña, 0, 1, 2, 3)
                if (JTabRegistro.getSelectedIndex() == 3) {
                    cargarDatosValidacion();
                }
            }
        });
    }
    private boolean validarCampos() {
        // Validación de campos de la pestaña "Datos Básicos"
        if (TxtClave.getText().trim().isEmpty() ||
            TxtIdEmpleado.getText().trim().isEmpty() ||
            TxtNombre.getText().trim().isEmpty() ||
            TxtApellidoPaterno.getText().trim().isEmpty() ||
            TxtApellidoMaterno.getText().trim().isEmpty() ||
            TxtRFC.getText().trim().isEmpty() ||
            TxtCURP.getText().trim().isEmpty() || // Asumiendo que has renombrado jTextField1 a TxtCURP
            JDateChooserFechaNacimiento.getDate() == null) 
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe completar todos los campos de 'Datos Básicos'.", "Campos Incompletos", javax.swing.JOptionPane.WARNING_MESSAGE);
            JTabRegistro.setSelectedIndex(0); // Mover a la pestaña de Datos Básicos
            return false;
        }
        
        // Validación de Radio Buttons (Sexo)
        if (!RButtonMasculino.isSelected() && !RButtonFemenino.isSelected()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar el Sexo.", "Campo Incompleto", javax.swing.JOptionPane.WARNING_MESSAGE);
            JTabRegistro.setSelectedIndex(0); // Mover a la pestaña de Datos Básicos
            return false;
        }

        // Validación de campos de la pestaña "Datos Adicionales"
        if (TxtCalle.getText().trim().isEmpty() ||
            TxtNExterior.getText().trim().isEmpty() ||
            TxtCodigoPostal.getText().trim().isEmpty() ||
            TxtColonia.getText().trim().isEmpty() ||
            TxtLocalidad.getText().trim().isEmpty() ||
            TxtEstado.getText().trim().isEmpty() ||
            TxtPais.getText().trim().isEmpty()) 
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe completar todos los campos de 'Datos Adicionales'.", "Campos Incompletos", javax.swing.JOptionPane.WARNING_MESSAGE);
            JTabRegistro.setSelectedIndex(1); // Mover a la pestaña de Datos Adicionales
            return false;
        }
        
        // Validación de campos de la pestaña "Nómina"
        if (TxtSalarioBase.getText().trim().isEmpty() ||
            TxtDiasLaborar.getText().trim().isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe completar todos los campos de 'Nómina'.", "Campos Incompletos", javax.swing.JOptionPane.WARNING_MESSAGE);
            JTabRegistro.setSelectedIndex(2); // Mover a la pestaña de Nómina
            return false;
        }
        
        // Aquí podrías agregar más validaciones específicas (ej: que Salario Base sea un número)
        try {
            Double.parseDouble(TxtSalarioBase.getText().trim());
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "El 'Salario Base' debe ser un valor numérico.", "Error de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);
            JTabRegistro.setSelectedIndex(2);
            TxtSalarioBase.requestFocus();
            return false;
        }

        return true; // Todos los campos requeridos han sido llenados
    }
    
    
    private String generarClaveAleatoria() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder clave = new StringBuilder();
        
        for (int i = 0; i < 8; i++) {
            int indice = random.nextInt(caracteres.length());
            clave.append(caracteres.charAt(indice));
        }
        return clave.toString();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTabRegistro = new javax.swing.JTabbedPane();
        PanelDatosBasicos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtClave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtIdEmpleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtApellidoPaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtApellidoMaterno = new javax.swing.JTextField();
        JDateChooserFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        RButtonMasculino = new javax.swing.JRadioButton();
        RButtonFemenino = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtRFC = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtCURP = new javax.swing.JTextField();
        PanelDatosAdicionales = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TxtCalle = new javax.swing.JTextField();
        TxtNExterior = new javax.swing.JTextField();
        TxtNInterior = new javax.swing.JTextField();
        TxtCodigoPostal = new javax.swing.JTextField();
        TxtColonia = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        TxtLocalidad = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        TxtEstado = new javax.swing.JTextField();
        TxtPais = new javax.swing.JTextField();
        PanelNomina = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        TxtSalarioBase = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        TxtDiasLaborar = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        BtnCalculoNomina = new javax.swing.JButton();
        PanelValidarDato = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        BtnRegistrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/3534124(1).jpg"))); // NOI18N

        jLabel1.setText("Clave:");

        jLabel2.setText("IdEmpleado:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido Paterno:");

        jLabel5.setText("Apellido Materno:");

        jLabel6.setText("Fecha de Nacimiento:");

        jLabel7.setText("Edad:");

        RButtonMasculino.setText("Masculino");
        RButtonMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RButtonMasculinoActionPerformed(evt);
            }
        });

        RButtonFemenino.setText("Femenino");

        jLabel8.setText("Sexo:");

        jLabel9.setText("RFC:");

        jLabel11.setText("CURP:");

        javax.swing.GroupLayout PanelDatosBasicosLayout = new javax.swing.GroupLayout(PanelDatosBasicos);
        PanelDatosBasicos.setLayout(PanelDatosBasicosLayout);
        PanelDatosBasicosLayout.setHorizontalGroup(
            PanelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosBasicosLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(PanelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelDatosBasicosLayout.createSequentialGroup()
                        .addComponent(RButtonMasculino)
                        .addGap(48, 48, 48)
                        .addComponent(RButtonFemenino))
                    .addGroup(PanelDatosBasicosLayout.createSequentialGroup()
                        .addComponent(TxtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(TxtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TxtNombre)
                    .addComponent(TxtApellidoPaterno)
                    .addComponent(TxtApellidoMaterno)
                    .addGroup(PanelDatosBasicosLayout.createSequentialGroup()
                        .addComponent(JDateChooserFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174)
                        .addComponent(jLabel7))
                    .addComponent(TxtRFC)
                    .addComponent(TxtCURP))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        PanelDatosBasicosLayout.setVerticalGroup(
            PanelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosBasicosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(PanelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(TxtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(TxtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDateChooserFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RButtonFemenino)
                    .addComponent(RButtonMasculino)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TxtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(TxtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        JTabRegistro.addTab("Datos Básicos", PanelDatosBasicos);

        jLabel12.setText("Calle:");

        jLabel13.setText("N.Exterior:");

        jLabel14.setText("N.Interior:");

        jLabel15.setText("Código Postal:");

        jLabel16.setText("Colonia:");

        jLabel17.setText("Localidad:");

        jLabel18.setText("Estado:");

        jLabel19.setText("País:");

        javax.swing.GroupLayout PanelDatosAdicionalesLayout = new javax.swing.GroupLayout(PanelDatosAdicionales);
        PanelDatosAdicionales.setLayout(PanelDatosAdicionalesLayout);
        PanelDatosAdicionalesLayout.setHorizontalGroup(
            PanelDatosAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosAdicionalesLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(PanelDatosAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addGroup(PanelDatosAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17)
                        .addComponent(jLabel16))
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelDatosAdicionalesLayout.createSequentialGroup()
                        .addComponent(TxtNExterior, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtNInterior, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TxtCalle)
                    .addComponent(TxtCodigoPostal)
                    .addComponent(TxtColonia)
                    .addComponent(TxtLocalidad)
                    .addComponent(TxtEstado)
                    .addComponent(TxtPais))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        PanelDatosAdicionalesLayout.setVerticalGroup(
            PanelDatosAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosAdicionalesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(PanelDatosAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TxtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(TxtNExterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(TxtNInterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(TxtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(TxtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(TxtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(TxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(TxtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        JTabRegistro.addTab("Datos Adicionales", PanelDatosAdicionales);

        jLabel10.setText("Salario Base:");

        jLabel20.setText("Días a Laborar:");

        jLabel21.setText("ISR:");

        jLabel22.setText("IMSS:");

        jLabel23.setText("Salario Neto:");

        BtnCalculoNomina.setText("Calcular Nómina");
        BtnCalculoNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCalculoNominaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelNominaLayout = new javax.swing.GroupLayout(PanelNomina);
        PanelNomina.setLayout(PanelNominaLayout);
        PanelNominaLayout.setHorizontalGroup(
            PanelNominaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNominaLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(PanelNominaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel10))
                .addGap(33, 33, 33)
                .addGroup(PanelNominaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnCalculoNomina)
                    .addGroup(PanelNominaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TxtSalarioBase)
                        .addComponent(TxtDiasLaborar, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        PanelNominaLayout.setVerticalGroup(
            PanelNominaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNominaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(PanelNominaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TxtSalarioBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(PanelNominaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(TxtDiasLaborar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel21)
                .addGap(50, 50, 50)
                .addComponent(jLabel22)
                .addGap(49, 49, 49)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(BtnCalculoNomina)
                .addGap(61, 61, 61))
        );

        JTabRegistro.addTab("Nómina", PanelNomina);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Datos Básicos");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Nómina");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Datos Adicionales");

        jLabel27.setText("Nombre Completo:");

        jLabel28.setText("Clave:");

        jLabel29.setText("Fecha de Nacimiento:");

        jLabel30.setText("Sexo:");

        jLabel31.setText("RFC:");

        jLabel32.setText("CURP:");

        jLabel33.setText("Calle:");

        jLabel34.setText("Código Postal:");

        jLabel35.setText("Colonia:");

        jLabel36.setText("Localidad:");

        jLabel37.setText("Estado:");

        jLabel38.setText("País:");

        jLabel39.setText("Salario Base:");

        jLabel40.setText("ISR:");

        jLabel41.setText("IMSS:");

        jLabel42.setText("Salario Neto:");

        BtnRegistrar.setText("Registrar");
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelValidarDatoLayout = new javax.swing.GroupLayout(PanelValidarDato);
        PanelValidarDato.setLayout(PanelValidarDatoLayout);
        PanelValidarDatoLayout.setHorizontalGroup(
            PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelValidarDatoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27))
                .addGap(116, 116, 116)
                .addGroup(PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(165, 165, 165))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelValidarDatoLayout.createSequentialGroup()
                .addGroup(PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelValidarDatoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnRegistrar))
                    .addGroup(PanelValidarDatoLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addComponent(jLabel26)
                        .addGap(134, 134, 134)
                        .addComponent(jLabel25)))
                .addGap(95, 95, 95))
        );
        PanelValidarDatoLayout.setVerticalGroup(
            PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelValidarDatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel33)
                    .addComponent(jLabel39))
                .addGap(37, 37, 37)
                .addGroup(PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel34)
                    .addComponent(jLabel40))
                .addGap(38, 38, 38)
                .addGroup(PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel35)
                    .addComponent(jLabel41))
                .addGap(47, 47, 47)
                .addGroup(PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel36)
                    .addComponent(jLabel42))
                .addGap(44, 44, 44)
                .addGroup(PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel37))
                .addGap(43, 43, 43)
                .addGroup(PanelValidarDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(BtnRegistrar)
                .addGap(45, 45, 45))
        );

        JTabRegistro.addTab("Validar Datos", PanelValidarDato);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JTabRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTabRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RButtonMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RButtonMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RButtonMasculinoActionPerformed
    /**
     * Carga los datos capturados de todas las pestañas 
     * en los JLabels de la pestaña "Validar Datos" (jPanel2).
     */
    private void cargarDatosValidacion() {
        // --- 1. Datos Básicos ---
        String nombreCompleto = TxtNombre.getText().trim() + " " 
                                + TxtApellidoPaterno.getText().trim() + " " 
                                + TxtApellidoMaterno.getText().trim();
        jLabel27.setText("Nombre Completo: " + nombreCompleto);
        
        jLabel28.setText("Clave: " + TxtClave.getText().trim());
        
        // Formato de Fecha (Requiere java.text.SimpleDateFormat)
        if (JDateChooserFechaNacimiento.getDate() != null) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            String fechaNacimientoStr = sdf.format(JDateChooserFechaNacimiento.getDate());
            jLabel29.setText("Fecha de Nacimiento: " + fechaNacimientoStr);
        } else {
            jLabel29.setText("Fecha de Nacimiento: (No Capturada)");
        }
        
        // Sexo
        String sexo = "";
        if (RButtonMasculino.isSelected()) {
            sexo = "Masculino";
        } else if (RButtonFemenino.isSelected()) {
            sexo = "Femenino";
        }
        jLabel30.setText("Sexo: " + sexo);
        
        jLabel31.setText("RFC: " + TxtRFC.getText().trim());
        // Asumiendo que has renombrado jTextField1 a TxtCURP
        jLabel32.setText("CURP: " + TxtCURP.getText().trim()); 
        
        // --- 2. Datos Adicionales ---
        String numExterior = TxtNExterior.getText().trim();
        String numInterior = TxtNInterior.getText().trim();
        jLabel33.setText("Calle y Números: " + TxtCalle.getText().trim() + " #" + numExterior + " Int:" + numInterior);

        jLabel34.setText("Código Postal: " + TxtCodigoPostal.getText().trim());
        jLabel35.setText("Colonia: " + TxtColonia.getText().trim());
        jLabel36.setText("Localidad: " + TxtLocalidad.getText().trim());
        jLabel37.setText("Estado: " + TxtEstado.getText().trim());
        jLabel38.setText("País: " + TxtPais.getText().trim());
        
        // --- 3. Nómina (Asegúrate de que los cálculos se hayan ejecutado) ---
        // Llama a calcularNomina() antes de mostrar los resultados finales
        calcularNomina(); 
        
        // Reutilizamos los valores que ya calculaste y se muestran en la pestaña "Nómina"
        jLabel39.setText("Salario Base: " + TxtSalarioBase.getText().trim());
        jLabel40.setText(jLabel21.getText()); // ISR
        jLabel41.setText(jLabel22.getText()); // IMSS
        jLabel42.setText(jLabel23.getText()); // Salario Neto
    }
    
    private void calcularNomina() {
        // Aseguramos que los campos de salario tengan valores numéricos
        try {
            double salarioBaseMensual = Double.parseDouble(TxtSalarioBase.getText().trim());
            int diasLaborar = Integer.parseInt(TxtDiasLaborar.getText().trim());

            // 1. Calcular Salario Diario (Asumiendo 30.4 días por mes para fines de cálculo)
            double salarioDiario = salarioBaseMensual / 30.4;
            double salarioBasePeriodo = salarioDiario * diasLaborar;

            // --- CÁLCULO SIMPLIFICADO DE RETENCIONES (solo para fines de ejemplo) ---
            
            // 2. Retención de ISR (Impuesto Sobre la Renta)
            // Se aplica una retención de ejemplo del 10% sobre el Salario Base del periodo
            double isr = salarioBasePeriodo * 0.10; 
            
            // 3. Retención de IMSS (Seguro Social)
            // Se aplica una retención de ejemplo del 3% sobre el Salario Base del periodo
            double imss = salarioBasePeriodo * 0.03; 
            
            // 4. Salario Neto
            double salarioNeto = salarioBasePeriodo - isr - imss;
            
            // 5. Mostrar los resultados en los Labels (jLabel) de la pestaña "Nómina"
            // Utilizaremos String.format para mostrar dos decimales para el formato de moneda.
            
            jLabel21.setText("ISR: $" + String.format("%.2f", isr));
            jLabel22.setText("IMSS: $" + String.format("%.2f", imss));
            jLabel23.setText("Salario Neto: $" + String.format("%.2f", salarioNeto));

        } catch (NumberFormatException e) {
            // Manejo de error si el usuario no ingresó números válidos
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Por favor, ingrese valores numéricos válidos en Salario Base y Días a Laborar.", 
                    "Error de Cálculo", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            
            // Limpiar los resultados en caso de error
            jLabel21.setText("ISR:");
            jLabel22.setText("IMSS:");
            jLabel23.setText("Salario Neto:");
        }
    }
    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        if (validarCampos()) {
            // Si la validación es exitosa, se puede proceder a guardar la información.
            // **Aquí es donde iría la lógica de guardar en la base de datos o en un archivo.**
            calcularNomina();
            javax.swing.JOptionPane.showMessageDialog(this, "Datos validados. Procediendo a guardar...", "Registro Exitoso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si la validación falla, el método validarCampos() ya mostró el mensaje de error.
        }
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void BtnCalculoNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCalculoNominaActionPerformed
        calcularNomina();
    }//GEN-LAST:event_BtnCalculoNominaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCalculoNomina;
    private javax.swing.JButton BtnRegistrar;
    private com.toedter.calendar.JDateChooser JDateChooserFechaNacimiento;
    private javax.swing.JTabbedPane JTabRegistro;
    private javax.swing.JPanel PanelDatosAdicionales;
    private javax.swing.JPanel PanelDatosBasicos;
    private javax.swing.JPanel PanelNomina;
    private javax.swing.JPanel PanelValidarDato;
    private javax.swing.JRadioButton RButtonFemenino;
    private javax.swing.JRadioButton RButtonMasculino;
    private javax.swing.JTextField TxtApellidoMaterno;
    private javax.swing.JTextField TxtApellidoPaterno;
    private javax.swing.JTextField TxtCURP;
    private javax.swing.JTextField TxtCalle;
    private javax.swing.JTextField TxtClave;
    private javax.swing.JTextField TxtCodigoPostal;
    private javax.swing.JTextField TxtColonia;
    private javax.swing.JTextField TxtDiasLaborar;
    private javax.swing.JTextField TxtEstado;
    private javax.swing.JTextField TxtIdEmpleado;
    private javax.swing.JTextField TxtLocalidad;
    private javax.swing.JTextField TxtNExterior;
    private javax.swing.JTextField TxtNInterior;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtPais;
    private javax.swing.JTextField TxtRFC;
    private javax.swing.JTextField TxtSalarioBase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
