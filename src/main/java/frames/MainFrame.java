package frames;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import lombok.AccessLevel;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class MainFrame extends javax.swing.JFrame {

    private static MainFrame instance;
    
    @Getter(AccessLevel.PRIVATE)
    private List<String> latitudeResultList;

    @Getter(AccessLevel.PRIVATE)
    private List<String> longitudeResultList;

    @Getter(AccessLevel.PRIVATE)
    private final JFileChooser fileChooser;

    private MainFrame() {
        initComponents();

        this.setTitle("Coordinates convertor - GPI");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.latitudeResultList = new ArrayList<>();
        this.longitudeResultList = new ArrayList<>();

        this.fileChooser = new JFileChooser();
        this.fileChooser.setFileFilter(new FileNameExtensionFilter("Text file", "txt", "YAML file", "yml"));
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }

        return instance;
    }

    private int findIndex(char array[], char element) {
        if (array == null) {
            return -1;
        }
        int len = array.length;
        int i = 0;
        while (i < len) {
            if (array[i] == element) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }
    
    private String convertToDecimal(String value, String coord) {
        String toReturn = "";
        value = value.trim();
        
        if (value.contains("\"") && value.contains("\'") && value.contains("°")) {
            int minute_index = this.findIndex(value.toCharArray(), '\'');
            int seconds_index = this.findIndex(value.toCharArray(), '\"');

            int grades_index = this.findIndex(value.toCharArray(), '°');
            float grades = Float.parseFloat(value.substring(0, grades_index));
            float minutes = Float.parseFloat(value.substring(grades_index + 1, minute_index));

            float seconds = Float.parseFloat(value.substring(minute_index + 1, seconds_index));

            float result1 = ((seconds / 12) + minutes);
            float result2 = result1 / 60;
            float result3 = result2 + grades;
            switch (coord) {
                default:
                case "latitude":
                    return toReturn = String.valueOf(result3);
                case "longitude":
                    float result4 = result3 * -1;
                    return toReturn = String.valueOf(result4);
            }
        }
        return toReturn;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JPanel();
        originalValuesPane = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaLatitudeValues = new javax.swing.JTextArea();
        convertLatitudeButton = new javax.swing.JButton();
        uploadLatitudeButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAreaLongitudeValues = new javax.swing.JTextArea();
        convertLongitudeButton = new javax.swing.JButton();
        uploadLongitudeButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaConvertedLongitudeValues = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaConvertedLatitudeValues = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPane.setBackground(new java.awt.Color(255, 255, 255));

        originalValuesPane.setBackground(new java.awt.Color(153, 153, 153));
        originalValuesPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Original values"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Latitude"));

        txtAreaLatitudeValues.setColumns(20);
        txtAreaLatitudeValues.setRows(5);
        txtAreaLatitudeValues.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Values", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N
        jScrollPane2.setViewportView(txtAreaLatitudeValues);

        convertLatitudeButton.setText("Convert");
        convertLatitudeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertLatitudeButtonActionPerformed(evt);
            }
        });

        uploadLatitudeButton.setText("Upload file");
        uploadLatitudeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadLatitudeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(convertLatitudeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uploadLatitudeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(convertLatitudeButton)
                    .addComponent(uploadLatitudeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Longitude"));

        txtAreaLongitudeValues.setColumns(20);
        txtAreaLongitudeValues.setRows(5);
        txtAreaLongitudeValues.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Values", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N
        jScrollPane5.setViewportView(txtAreaLongitudeValues);

        convertLongitudeButton.setText("Convert");
        convertLongitudeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertLongitudeButtonActionPerformed(evt);
            }
        });

        uploadLongitudeButton.setText("Upload file");
        uploadLongitudeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadLongitudeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(convertLongitudeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uploadLongitudeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(convertLongitudeButton)
                    .addComponent(uploadLongitudeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout originalValuesPaneLayout = new javax.swing.GroupLayout(originalValuesPane);
        originalValuesPane.setLayout(originalValuesPaneLayout);
        originalValuesPaneLayout.setHorizontalGroup(
            originalValuesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(originalValuesPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        originalValuesPaneLayout.setVerticalGroup(
            originalValuesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(originalValuesPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(originalValuesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(369, 369, 369))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Converted values"));

        txtAreaConvertedLongitudeValues.setEditable(false);
        txtAreaConvertedLongitudeValues.setColumns(20);
        txtAreaConvertedLongitudeValues.setRows(5);
        txtAreaConvertedLongitudeValues.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Longitude values", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N
        jScrollPane3.setViewportView(txtAreaConvertedLongitudeValues);

        txtAreaConvertedLatitudeValues.setEditable(false);
        txtAreaConvertedLatitudeValues.setColumns(20);
        txtAreaConvertedLatitudeValues.setRows(5);
        txtAreaConvertedLatitudeValues.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Latitude values", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N
        jScrollPane4.setViewportView(txtAreaConvertedLatitudeValues);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveButton.setText("Save results");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
        mainPane.setLayout(mainPaneLayout);
        mainPaneLayout.setHorizontalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveButton)
                    .addGroup(mainPaneLayout.createSequentialGroup()
                        .addComponent(originalValuesPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPaneLayout.setVerticalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(originalValuesPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(saveButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadLatitudeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadLatitudeButtonActionPerformed
        int returnValue = fileChooser.showOpenDialog(this.mainPane);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                String file_path = fileChooser.getSelectedFile().getAbsolutePath();
                String content = new String(Files.readAllBytes(Paths.get(file_path)));
                content = content.replace("Â", "");
                this.txtAreaLatitudeValues.setText(content);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_uploadLatitudeButtonActionPerformed

    private void convertLatitudeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertLatitudeButtonActionPerformed
        String str = this.txtAreaLatitudeValues.getText();
        if (!str.isEmpty() && !str.equals("")) {
            if (str.contains(",")) {
                String main_split[] = str.split("\\,");
                
                if (main_split.length > 1) {
                    List<String> values = Arrays.stream(main_split).toList();
                    List<String> resultList = new ArrayList<>(values.size());
                    
                    for (int i = 0; i < values.size(); i++) {
                        String checkingValue = values.get(i);
                        if (checkingValue.endsWith("°")) {
                            checkingValue = checkingValue.substring(0, this.findIndex(checkingValue.toCharArray(), '°'));
                        }
                        if (checkingValue.equals("null") || (checkingValue.contains("\"") && checkingValue.contains("\'"))) {
                            String toSave = this.convertToDecimal(checkingValue, "latitude");
                            resultList.add(toSave);
                        } else {
                            resultList.add(checkingValue);
                        }
                    }
                    for (int i = 0; i < resultList.size(); i++) {
                        if (resultList.get(i).isEmpty() || resultList.get(i).isBlank()) {
                            resultList.remove(i);
                        }
                    }
                    resultList.forEach(v -> {
                        this.txtAreaConvertedLatitudeValues.setText(this.txtAreaConvertedLatitudeValues.getText().trim() + "\n" + v.trim());
                    });
                    this.latitudeResultList = resultList;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No values to convert were detected in the latitude text area.", "No values", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_convertLatitudeButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (!this.txtAreaConvertedLatitudeValues.getText().isEmpty() ||
                !this.txtAreaConvertedLongitudeValues.getText().isEmpty()) {
            SXSSFWorkbook wb = new SXSSFWorkbook(1);
            if (!this.getLatitudeResultList().isEmpty()) {
                SXSSFSheet sheet = wb.createSheet("Latitude Values");
                for (int i = 0; i < this.getLatitudeResultList().size(); i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) {
                        row = sheet.createRow(i);
                    }
                    Cell cell = row.createCell(0);
                    cell.setCellValue(this.getLatitudeResultList().get(i));
                }
            }
            if (!this.getLongitudeResultList().isEmpty()) {
                SXSSFSheet sheet2 = wb.createSheet("Longitude Values");
                for (int i = 0; i < this.getLongitudeResultList().size(); i++) {
                    Row row = sheet2.getRow(i);
                    if (row == null) {
                        row = sheet2.createRow(i);
                    }
                    Cell cell = row.createCell(0);
                    cell.setCellValue(this.getLongitudeResultList().get(i));
                }
            }            

            try {
                FileSystemView view = FileSystemView.getFileSystemView();
                File desktop = view.getHomeDirectory();
                String desktopPath = desktop.getAbsolutePath();
                
                File file = new File(desktopPath + "\\converted-values.xlsx");
                FileOutputStream out = new FileOutputStream(file);
                wb.write(out);
                
                JOptionPane.showMessageDialog(null, "The converted values were saved at " + file.getAbsolutePath());
                
                out.flush();
                out.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    wb.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No values to save were found in the convert areas.", "No values", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void convertLongitudeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertLongitudeButtonActionPerformed
        String str = this.txtAreaLongitudeValues.getText();
        if (!str.isEmpty() && !str.equals("")) {
            if (str.contains(",")) {
                String main_split[] = str.split("\\,");
                
                if (main_split.length > 1) {
                    List<String> values = Arrays.stream(main_split).toList();
                    List<String> resultList = new ArrayList<>(values.size());
                    
                    for (int i = 0; i < values.size(); i++) {
                        String checkingValue = values.get(i);
                        if (checkingValue.endsWith("°")) {
                            checkingValue = checkingValue.substring(0, this.findIndex(checkingValue.toCharArray(), '°'));
                        }
                        if (checkingValue.equals("null") || (checkingValue.contains("\"") && checkingValue.contains("\'"))) {
                            String toSave = this.convertToDecimal(checkingValue, "longitude");
                            resultList.add(toSave);
                        } else {
                            resultList.add(checkingValue);
                        }
                    }
                    for (int i = 0; i < resultList.size(); i++) {
                        if (resultList.get(i).isEmpty() || resultList.get(i).isBlank()) {
                            resultList.remove(i);
                        }
                    }
                    resultList.forEach(v -> {
                        this.txtAreaConvertedLongitudeValues.setText(this.txtAreaConvertedLongitudeValues.getText().trim() + "\n" + v.trim());
                    });
                    this.longitudeResultList = resultList;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No values to convert were detected in the longitude text area.", "No values", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_convertLongitudeButtonActionPerformed

    private void uploadLongitudeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadLongitudeButtonActionPerformed
        int returnValue = fileChooser.showOpenDialog(this.mainPane);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                String file_path = fileChooser.getSelectedFile().getAbsolutePath();
                String content = new String(Files.readAllBytes(Paths.get(file_path)));
                content = content.replace("Â", "");
                this.txtAreaLongitudeValues.setText(content);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_uploadLongitudeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton convertLatitudeButton;
    private javax.swing.JButton convertLongitudeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel mainPane;
    private javax.swing.JPanel originalValuesPane;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextArea txtAreaConvertedLatitudeValues;
    private javax.swing.JTextArea txtAreaConvertedLongitudeValues;
    private javax.swing.JTextArea txtAreaLatitudeValues;
    private javax.swing.JTextArea txtAreaLongitudeValues;
    private javax.swing.JButton uploadLatitudeButton;
    private javax.swing.JButton uploadLongitudeButton;
    // End of variables declaration//GEN-END:variables
}
