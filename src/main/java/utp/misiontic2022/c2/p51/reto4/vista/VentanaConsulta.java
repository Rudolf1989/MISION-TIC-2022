package utp.misiontic2022.c2.p51.reto4.vista;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import utp.misiontic2022.c2.p51.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_3;

public class VentanaConsulta extends JFrame {

    private ControladorRequerimientos controlador;
    private JTable tabla1;
    private JTable tabla2;
    private JTable tabla3;


    public VentanaConsulta(){
        controlador = new ControladorRequerimientos();

        initUI();
        setLocationRelativeTo(null);
    }

    

    private void initUI(){

        setTitle("INTERFAZ RETO 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,600);

        var tbd = new JTabbedPane();
        

        getContentPane().add(tbd, BorderLayout.CENTER);
        
        // PANEL NUMERO 1
        var panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        tbd.addTab("CONSULTA DE REQUERIMIENTO 1", panel1);

        // PANEL NUMERO 2
        var panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        tbd.addTab("CONSULTA DE REQUERIMIENTO 2", panel2);

        // PANEL NUMERO 3
        var panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        tbd.addTab("CONSULTA DE REQUERIMIENTO 3", panel3);

        // PANEL DE ENTRADA 1

        var panelEntrada1 = new JPanel();
        panelEntrada1.add(new JLabel("Requerimiento 1 Label"));
        var btnConsulta1 = new JButton("Consultar!");
        btnConsulta1.addActionListener(e -> cargarTablaConsulta1());
        panelEntrada1.add(btnConsulta1);
        panel1.add(panelEntrada1, BorderLayout.PAGE_START);

        // PANEL DE ENTRADA 2

        var panelEntrada2 = new JPanel();
        panelEntrada2.add(new JLabel("Requerimiento 2 Label"));
        var btnConsulta2 = new JButton("Consultar!");
        btnConsulta2.addActionListener(e -> cargarTablaConsulta2());
        panelEntrada2.add(btnConsulta2);
        panel2.add(panelEntrada2, BorderLayout.PAGE_START);

        // PANEL DE ENTRADA 3

        var panelEntrada3 = new JPanel();
        panelEntrada3.add(new JLabel("Requerimiento 3 Label"));
        var btnConsulta3 = new JButton("Consultar!");
        btnConsulta3.addActionListener(e -> cargarTablaConsulta3());
        panelEntrada3.add(btnConsulta3);
        panel3.add(panelEntrada3, BorderLayout.PAGE_START);


        tabla1 = new JTable();
        panel1.add(new JScrollPane(tabla1), BorderLayout.CENTER);

        tabla2 = new JTable();
        panel2.add(new JScrollPane(tabla2), BorderLayout.CENTER);

        tabla3 = new JTable();
        panel3.add(new JScrollPane(tabla3), BorderLayout.CENTER);

    
    }

    private void cargarTablaConsulta1() {
        
        try {
            var lista = controlador.consultarRequerimiento1();
            var tableModel1 = new Requerimiento1TableModel();
            
            tableModel1.setData(lista);

            tabla1.setModel(tableModel1);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    
        private class Requerimiento1TableModel extends AbstractTableModel{
            private ArrayList<Requerimiento_1> data;

            public void setData(ArrayList<Requerimiento_1> data) {
                this.data = data;
            }

            @Override
            public String getColumnName(int column) {
                switch(column){
                    case 0:
                        return "NOMBRE MATERIAL";
                    case 1:
                        return "PRECIO UNIDAD";
                }
                return super.getColumnName(column);
            }

            @Override
            public int getRowCount() {
            
                return data.size();
            }

            @Override
            public int getColumnCount() {
                
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                var registro = data.get(rowIndex);

                switch(columnIndex){
                    case 0:
                        return registro.getNombreMaterial();
                    case 1:
                        return registro.getPrecioUnidad();
                }

                return null;
            }
            
        }

    private void cargarTablaConsulta2() {
        
        try {
            var lista2 = controlador.consultarRequerimiento2();
            var tableModel2 = new Requerimiento2TableModel();
                
            tableModel2.setData(lista2);
    
            tabla2.setModel(tableModel2);
    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
        
        private class Requerimiento2TableModel extends AbstractTableModel{
            private ArrayList<Requerimiento_2> data;
    
            public void setData(ArrayList<Requerimiento_2> data) {
                this.data = data;
            }
    
            @Override
            public String getColumnName(int column) {
                switch(column){
                    case 0:
                        return "CONSTRUCTORA";
                    case 1:
                        return "CIUDAD";
                }
                return super.getColumnName(column);
            }
    
            @Override
            public int getRowCount() {
                
                return data.size();
            }
    
            @Override
            public int getColumnCount() {
                    
                return 2;
            }
    
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                var registro2 = data.get(rowIndex);
    
                switch(columnIndex){
                    case 0:
                        return registro2.getConstructora();
                    case 1:
                        return registro2.getCiudad();
                }
    
                return null;
            }
                
        }
        
    private void cargarTablaConsulta3() {
        
        try {
            var lista3 = controlador.consultarRequerimiento3();
            var tableModel3 = new Requerimiento3TableModel();
                    
            tableModel3.setData(lista3);
        
            tabla3.setModel(tableModel3);
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
        
            
        private class Requerimiento3TableModel extends AbstractTableModel{
            private ArrayList<Requerimiento_3> data;
        
            public void setData(ArrayList<Requerimiento_3> data) {
                this.data = data;
            }
        
            @Override
            public String getColumnName(int column) {
                switch(column){
                    case 0:
                        return "PROVEEDOR";
                    case 1:
                        return "NOMBRE MATERIAL";
                    case 2:
                        return "IMPORTADO";
                    case 3:
                        return "PRECIO UNIDAD";
                    case 4:
                        return "CANTIDAD";
                }
                return super.getColumnName(column);
            }
        
            @Override
            public int getRowCount() {
                    
                return data.size();
            }
        
            @Override
            public int getColumnCount() {
                        
                return 5;
            }
        
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                var registro3 = data.get(rowIndex);
        
                switch(columnIndex){
                    case 0:
                        return registro3.getProveedor();
                    case 1:
                        return registro3.getNombreMaterial();
                    case 2:
                        return registro3.getImportado();
                    case 3:
                        return registro3.getPrecioUnidad();
                    case 4:
                        return registro3.getCantidad();
                }
        
                return null;
            }
                    
        }
    
}
