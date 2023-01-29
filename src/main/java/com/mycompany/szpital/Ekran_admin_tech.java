/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.szpital;

import javax.swing.JTable;

/**
 *
 * @author Lenovo
 */
public class Ekran_admin_tech extends javax.swing.JFrame {

    private EkranStartowy mainGui;
    private DodawanieSprzetu addEqGui;
    private ZarzadzanieStatusemSprzetu changEqStatus;
    private Uzytkownik admin;
    private RepoSprzet repoEquip;
    
    public Ekran_admin_tech(EkranStartowy gui, Uzytkownik user, RepoSprzet repo) {
        mainGui = gui;
        admin = user;
        repoEquip = repo;
        addEqGui = new DodawanieSprzetu(this, repoEquip);
        changEqStatus = new ZarzadzanieStatusemSprzetu(this);
        initComponents();
        this.openScreen();
    }
    
    //Funkcja odpowiadająca za odświeżenie ekranu(listy) i jego włączenie
    public void openScreen(){
        
        this.update();
        this.setVisible(true);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelScreenName = new javax.swing.JLabel();
        jButtonAddEq = new javax.swing.JButton();
        jButtonDeleteEq = new javax.swing.JButton();
        jButtonChangeEqStatus = new javax.swing.JButton();
        jButtonLogOut = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelScreenName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelScreenName.setText("Zalogowano jako administrator techniczny"
            + admin.getName() + " " + admin.getSurname());

        jButtonAddEq.setText("Dodawanie sprzętu");
        jButtonAddEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEqActionPerformed(evt);
            }
        });

        jButtonDeleteEq.setText("Usuwanie sprzętu");
        jButtonDeleteEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteEqActionPerformed(evt);
            }
        });

        jButtonChangeEqStatus.setText("Zarządzanie statusem sprzętu");
        jButtonChangeEqStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeEqStatusActionPerformed(evt);
            }
        });

        jButtonLogOut.setText("Wyloguj");
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });

        jTable.setModel(new SprzetTableModel(repoEquip.getEquipment()));
        jScrollPane3.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabelScreenName))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonChangeEqStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonDeleteEq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAddEq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelScreenName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLogOut)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButtonAddEq)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDeleteEq)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonChangeEqStatus)
                        .addContainerGap(188, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddEqActionPerformed
        this.setVisible(false);
        addEqGui.openScreen();
        
    }//GEN-LAST:event_jButtonAddEqActionPerformed

    private void jButtonDeleteEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteEqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteEqActionPerformed

    private void jButtonChangeEqStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeEqStatusActionPerformed
        this.setVisible(false);
        changEqStatus.openScreen();
    }//GEN-LAST:event_jButtonChangeEqStatusActionPerformed

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        this.setVisible(false);
        mainGui.logOut();
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void update(){
        
        SprzetTableModel model = (SprzetTableModel) jTable.getModel();
        model.update();
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddEq;
    private javax.swing.JButton jButtonChangeEqStatus;
    private javax.swing.JButton jButtonDeleteEq;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JLabel jLabelScreenName;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
