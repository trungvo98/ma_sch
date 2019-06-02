/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DangKyHocDAO;
import DAO.DiemDAO;
import DAO.LopDAO;
import DAO.LopHocPhanDAO;
import DAO.MonHocDAO;
import DAO.SinhVienDAO;
import Entities.DangKyHoc;
import Entities.Diem;
import Entities.Lop;
import Entities.LopHocPhan;
import Entities.MonHoc;
import Entities.SinhVien;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author trung98
 */
public class QLDiemQTV extends javax.swing.JFrame {

    /**
     * Creates new form QLDiemQTV
     */
    private DefaultTableModel model;
    private ArrayList<SinhVien> listSV;
    private ArrayList<Lop> listLop;
    private DefaultComboBoxModel dcbmLop;

    public QLDiemQTV() {
        initComponents();
        model = (DefaultTableModel) bangkqht.getModel();
        dcbmLop = new DefaultComboBoxModel();
        listLop = new LopDAO().getAll();
        for (Lop lop : listLop) {
            dcbmLop.addElement(lop.getTenlop());
        }
        cbl.setModel(dcbmLop);
    }

    public void loadDangkyhocphan() {
        model.setRowCount(0);
        listSV = new SinhVienDAO().findByDKH(cbl.getSelectedItem().toString(), cbhocky.getSelectedItem().toString(), cbnamhoc.getSelectedItem().toString());
        int i = 1;
        for (SinhVien sv : listSV) {
            model.addRow(toObjectsData(sv, i));
            i++;
        }
        bangkqht.setModel(model);

    }

    public Object[] toObjectsData(SinhVien sv, int i) {

        float diemTB = new DiemDAO().calDiemTB(sv.getMaSV(), cbhocky.getSelectedItem().toString(), cbnamhoc.getSelectedItem().toString());
        String xeploai;
        if (diemTB >= 9) {
            xeploai = "Xuất sắc";
        } else if (8 <= diemTB && diemTB < 9) {
            xeploai = "Giỏi";
        } else if (7 <= diemTB && diemTB < 8) {
            xeploai = "Khá";
        } else if (6 <= diemTB && diemTB < 7) {
            xeploai = "Trung bình khá";
        } else if (5 <= diemTB && diemTB < 6) {
            xeploai = "Trung bình";
        } else if (3 <= diemTB && diemTB < 5) {
            xeploai = "Yếu";
        } else {
            xeploai = "Kém";
        }
        Object[] objectsData = {i, sv.getMaSV(), sv.getHoTen(), diemTB, xeploai};
        return objectsData;
    }

    private static XSSFCellStyle createStyleForTitle(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);

        XSSFCellStyle style = workbook.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFont(font);
        return style;
    }

    private static XSSFCellStyle createStyleForBold(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        font.setBold(true);

        XSSFCellStyle style = workbook.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setFont(font);
        return style;
    }

    private static XSSFCellStyle createStyleForData(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setFont(font);
        return style;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbhocky = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbnamhoc = new javax.swing.JComboBox<>();
        cbl = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangkqht = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtmh1 = new javax.swing.JLabel();
        txtdmh1 = new javax.swing.JLabel();
        txtmh2 = new javax.swing.JLabel();
        txtdmh2 = new javax.swing.JLabel();
        txtmh3 = new javax.swing.JLabel();
        txtdmh3 = new javax.swing.JLabel();
        txtmh4 = new javax.swing.JLabel();
        txtdmh4 = new javax.swing.JLabel();
        txtmh5 = new javax.swing.JLabel();
        txtdmh5 = new javax.swing.JLabel();
        txtmh6 = new javax.swing.JLabel();
        txtdmh6 = new javax.swing.JLabel();
        txtmh7 = new javax.swing.JLabel();
        txtdmh7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaghichu = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tra cứu điểm");

        jPanel2.setBackground(java.awt.SystemColor.textHighlight);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Học kỳ ");

        cbhocky.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Học kỳ 1", "Học kỳ 2", "Học kỳ 3" }));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Năm học");

        cbnamhoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018-2019" }));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Lớp ");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ssss.png"))); // NOI18N
        jButton1.setText("Tra cứu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ba.png"))); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnExport.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbhocky, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbnamhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(cbl, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(11, 11, 11)
                .addComponent(btnExport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbhocky, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(cbnamhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        bangkqht.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bangkqht.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "MASV", "Họ và Tên", "Điểm TB", "Xếp loại"
            }
        ));
        bangkqht.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangkqhtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bangkqht);
        bangkqht.getColumnModel().getColumn(0).setPreferredWidth(50);
        bangkqht.getColumnModel().getColumn(1).setPreferredWidth(100);
        bangkqht.getColumnModel().getColumn(2).setPreferredWidth(150);
        bangkqht.getColumnModel().getColumn(3).setPreferredWidth(100);
        bangkqht.getColumnModel().getColumn(4).setPreferredWidth(100);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("DANH SÁCH KẾT QUẢ HỌC TẬP");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("*Chi tiết điểm ");

        txtdmh1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtdmh2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtdmh3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtdmh4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtdmh5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtdmh6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtdmh7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtaghichu.setColumns(20);
        txtaghichu.setRows(5);
        jScrollPane2.setViewportView(txtaghichu);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Ghi chú");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmh2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmh3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmh4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmh5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmh6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmh7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdmh7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtdmh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtdmh2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtdmh3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtdmh4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtdmh5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtdmh6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmh1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdmh1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmh2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdmh2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmh3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdmh3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmh4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdmh4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmh5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdmh5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmh6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdmh6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmh7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdmh7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loadDangkyhocphan();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bangkqhtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangkqhtMouseClicked

        if (bangkqht.isEnabled()) {
            txtmh1.setText("");
            txtdmh1.setText("");
            txtmh2.setText("");
            txtdmh2.setText("");
            txtmh3.setText("");
            txtdmh3.setText("");
            txtmh4.setText("");
            txtdmh4.setText("");
            txtmh5.setText("");
            txtdmh5.setText("");
            txtmh6.setText("");
            txtdmh6.setText("");
            txtmh7.setText("");
            txtdmh7.setText("");
        }
        String masv = (String) bangkqht.getValueAt(bangkqht.getSelectedRow(), 1);
        ArrayList<DangKyHoc> listDKH = new DangKyHocDAO().findByMaSV(masv, cbhocky.getSelectedItem().toString(), cbnamhoc.getSelectedItem().toString());
        String[] tenmh = new String[listDKH.size()];
        int j = 0;
        for (int i = 0; i < listDKH.size(); i++) {

            LopHocPhan lhp = new LopHocPhanDAO().findByMaLHP(listDKH.get(i).getMaLHP(), listDKH.get(i).getHocKy(), listDKH.get(i).getNamHoc());
            Diem diem = new DiemDAO().findDiemSV_LHP(masv, lhp.getMaLHP(), lhp.getHocky(), lhp.getNamhoc());
            txtaghichu.setText(diem.getGhichu());
            MonHoc mh = new MonHocDAO().findByMaMH(lhp.getMaMH());
            if (j == 0) {
                txtmh1.setText(mh.getTenMH());
                txtdmh1.setText(Float.toString(diem.getDiemTB()));
                j++;
            } else if (j == 1) {
                txtmh2.setText(mh.getTenMH());
                txtdmh2.setText(Float.toString(diem.getDiemTB()));
                j++;
            } else if (j == 2) {
                txtmh3.setText(mh.getTenMH());
                txtdmh3.setText(Float.toString(diem.getDiemTB()));
                j++;
            } else if (j == 3) {
                txtmh4.setText(mh.getTenMH());
                txtdmh4.setText(Float.toString(diem.getDiemTB()));
                j++;
            } else if (j == 4) {
                txtmh5.setText(mh.getTenMH());
                txtdmh5.setText(Float.toString(diem.getDiemTB()));
                j++;
            } else if (j == 5) {
                txtmh6.setText(mh.getTenMH());
                txtdmh6.setText(Float.toString(diem.getDiemTB()));
                j++;
            } else if (j == 6) {
                txtmh7.setText(mh.getTenMH());
                txtdmh7.setText(Float.toString(diem.getDiemTB()));
                j++;
            }
        }


    }//GEN-LAST:event_bangkqhtMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Result");
        sheet.setColumnWidth(0, 4000);
        sheet.setColumnWidth(1, 10000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 6000);
        sheet.setColumnWidth(4, 6000);
        sheet.setColumnWidth(5, 6000);

        int rownum = 2;
        Row row;
        Cell cell;
        XSSFCellStyle style = createStyleForTitle(wb);
        XSSFCellStyle styleBold = createStyleForBold(wb);
        XSSFCellStyle styleData = createStyleForData(wb);
        row = sheet.createRow(rownum);

        XSSFRow title = sheet.createRow(0);
        Cell titleCell = title.createCell(2);
        String hocky = cbhocky.getSelectedItem().toString().toUpperCase();

        titleCell.setCellValue("KẾT QUẢ HỌC TẬP " + hocky + " NĂM HỌC " + cbnamhoc.getSelectedItem() + " LỚP " + cbl.getSelectedItem());
        titleCell.setCellStyle(style);

        // Số TT
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Số TT");
        cell.setCellStyle(styleBold);
        // Mã số sinh viên
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Mã số sinh viên");
        cell.setCellStyle(styleBold);
        // Họ và tên
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Họ và tên");
        cell.setCellStyle(styleBold);
        // Điểm trung bình
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Điểm trung bình");
        cell.setCellStyle(styleBold);
        // Xếp loại
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Xếp loại");
        cell.setCellStyle(styleBold);

        for (int i = 0; i < bangkqht.getRowCount(); i++) {
            rownum++;
            row = sheet.createRow(rownum);
            // Số TT
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(i + 1);
            cell.setCellStyle(styleData);

            // MaSV 
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue((String) bangkqht.getValueAt(i, 1));
            cell.setCellStyle(styleData);

            // Họ và tên 
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue((String) (bangkqht.getValueAt(i, 2)));
            cell.setCellStyle(styleData);
            // Điểm trung bình 
            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue(String.valueOf(bangkqht.getValueAt(i, 3)));
            cell.setCellStyle(styleData);

            // Xếp loại
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue((String) (bangkqht.getValueAt(i, 4)));
            cell.setCellStyle(styleData);

        }
        int j = rownum + 3;
        XSSFRow sum = sheet.createRow(j-1);
        cell = sum.createCell(0, CellType.STRING);
        cell.setCellValue("Tổng cộng:");
        cell.setCellStyle(styleBold);

        int xs, g, kh, tbk, tb, y, k;
        xs = g = kh = tbk = tb = y = k = 0;

        String[] xl = new String[]{"Xuất sắc: ", "Giỏi: ", "Khá: ", "Trung bình khá: ", "Trung bình: ", "Yếu: ", "Kém: "};
        for (int i = 0; i < bangkqht.getRowCount(); i++) {

            if (bangkqht.getValueAt(i, 4).equals("Xuất sắc")) {
                xs++;
            } else if (bangkqht.getValueAt(i, 4).equals("Giỏi")) {
                g++;
            } else if (bangkqht.getValueAt(i, 4).equals("Khá")) {
                kh++;
            } else if (bangkqht.getValueAt(i, 4).equals("Trung bình khá")) {
                tbk++;
            } else if (bangkqht.getValueAt(i, 4).equals("Trung bình")) {
                tb++;
            } else if (bangkqht.getValueAt(i, 4).equals("Yếu")) {
                y++;
            } else if (bangkqht.getValueAt(i, 4).equals("Kém")) {
                k++;
            }
        }
        xl[0] += xs;
        xl[1] += g;
        xl[2] += kh;
        xl[3] += tbk;
        xl[4] += tb;
        xl[5] += y;
        xl[6] += k;
        for (int i = 0; i < xl.length; i++) {
            sum = sheet.createRow(j);
            cell = sum.createCell(1, CellType.STRING);
            cell.setCellValue(xl[i]);
            cell.setCellStyle(styleBold);
            j++;
        }

        File file = new File("E:/Learn Java/Slide UIT/" + cbl.getSelectedItem() + ".xlsx");
        file.getParentFile().mkdirs();

        try {
            FileOutputStream outFile = new FileOutputStream(file);
            wb.write(outFile);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KetQuaHocTap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KetQuaHocTap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLDiemQTV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLDiemQTV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLDiemQTV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLDiemQTV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLDiemQTV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangkqht;
    private javax.swing.JButton btnExport;
    private javax.swing.JComboBox<String> cbhocky;
    private javax.swing.JComboBox<String> cbl;
    private javax.swing.JComboBox<String> cbnamhoc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtaghichu;
    private javax.swing.JLabel txtdmh1;
    private javax.swing.JLabel txtdmh2;
    private javax.swing.JLabel txtdmh3;
    private javax.swing.JLabel txtdmh4;
    private javax.swing.JLabel txtdmh5;
    private javax.swing.JLabel txtdmh6;
    private javax.swing.JLabel txtdmh7;
    private javax.swing.JLabel txtmh1;
    private javax.swing.JLabel txtmh2;
    private javax.swing.JLabel txtmh3;
    private javax.swing.JLabel txtmh4;
    private javax.swing.JLabel txtmh5;
    private javax.swing.JLabel txtmh6;
    private javax.swing.JLabel txtmh7;
    // End of variables declaration//GEN-END:variables
}