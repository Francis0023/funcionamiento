import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class forma1 {
    private JLabel text_1;
    private JMenu menu2;
    private JMenu menu1;
    private JMenuItem sub_1;
    private JMenuItem sub_2;
    private JMenuItem sub3;
    JPanel menuprincipal;
    private JButton boton_subir;
    private JTable table1;
    private JTextField agregar_tarea;
    private JCheckBox checkBox1;
    private DefaultTableModel tableModel;

    public forma1() {
        // Inicializar el modelo de la tabla
        String[] columnNames = {"Contenido del Archivo"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table1.setModel(tableModel);

        // Configurar el ActionListener para el botón de subir
        boton_subir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(menuprincipal);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    mostrarContenidoEnTabla(selectedFile);
                    JOptionPane.showMessageDialog(menuprincipal, "Archivo seleccionado: " + selectedFile.getName());
                }
            }
        });
    }

    private void mostrarContenidoEnTabla(File file) {
        // Limpiar la tabla antes de mostrar un nuevo archivo
        tableModel.setRowCount(0);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Leer la primera línea para obtener las cabeceras o indices
            String headersLine = reader.readLine();
            if (headersLine != null) {
                String[] headers = headersLine.split(","); // Ajusta el delimitador según el establecido archivo
                tableModel.setColumnIdentifiers(headers);
            }
            // Leer el resto de las líneas y agregarlas a la tabla
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(","); // Ajusta el delimitador el archivo por las comas
                tableModel.addRow(rowData);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(menuprincipal, "Error al leer el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
