/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.panel;

/**
 *
 * @author datba
 */
public class CapNhapPhong extends javax.swing.JPanel {

    /**
     * Creates new form CapNhapPhong
     */
    public CapNhapPhong() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbTenPhong = new javax.swing.JLabel();
        tfTenPhong = new javax.swing.JTextField();
        lbSoGhe = new javax.swing.JLabel();
        tfSoGhe = new javax.swing.JTextField();
        lbMaPhong = new javax.swing.JLabel();
        tfMaPhong = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXoaTrang = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(650, 700));
        setLayout(new java.awt.BorderLayout());

        lbTitle.setText("Quản lý phòng - Cập nhập phòng");

        lbTenPhong.setText("Tên phòng:");

        lbSoGhe.setText("Số ghế:");

        lbMaPhong.setText("Mã phòng:");

        tfMaPhong.setEnabled(false);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");

        btnXoa.setText("Xóa");

        btnXoaTrang.setText("Xóa trắng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTenPhong)
                            .addComponent(lbSoGhe)
                            .addComponent(lbMaPhong))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbTitle)
                                .addGap(0, 107, Short.MAX_VALUE))
                            .addComponent(tfMaPhong)
                            .addComponent(tfTenPhong)
                            .addComponent(tfSoGhe)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(54, 54, 54)
                        .addComponent(btnSua)
                        .addGap(55, 55, 55)
                        .addComponent(btnXoa)))
                .addGap(38, 38, 38)
                .addComponent(btnXoaTrang)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbTitle)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaPhong)
                    .addComponent(tfMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenPhong)
                    .addComponent(tfTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoGhe)
                    .addComponent(tfSoGhe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnXoaTrang))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.NORTH);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phòng", "Tên phòng", "Số ghế"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaTrang;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbMaPhong;
    private javax.swing.JLabel lbSoGhe;
    private javax.swing.JLabel lbTenPhong;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTextField tfMaPhong;
    private javax.swing.JTextField tfSoGhe;
    private javax.swing.JTextField tfTenPhong;
    // End of variables declaration//GEN-END:variables
}
