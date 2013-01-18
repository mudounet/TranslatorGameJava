/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mudounet.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mudounet
 */
public class GraphicalInterface extends javax.swing.JFrame {

    private JLabel jQuestion;
    private JFormattedTextField jProposal;
    private JButton jValidate;
    private JPanel jAnswerPanel;

    public GraphicalInterface() {
        initComponents(this.getContentPane());
    }

    private void initComponents(Container pane) {
        // <editor-fold defaultstate="collapsed" desc="Code to handle Graphical User Interface">
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        jQuestion = new javax.swing.JLabel();
        jProposal = new javax.swing.JFormattedTextField();
        jValidate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Translator Game");
        setAlwaysOnTop(true);

        jQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jQuestion.setText("Texte de la question");

        try {
            jProposal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### to #### nack ### do ###### bis  ######?")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jValidate.setText("Validate proposal");
        jValidate.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test(evt);
            }
        });


        jAnswerPanel = createAnswerPanel();



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProposal, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addComponent(jAnswerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jValidate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProposal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAnswerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jValidate, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap()));


        pack();
        // </editor-fold>
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphicalInterface().setVisible(true);
            }
        });
    }

    private void test(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        System.out.println("Ceci est mon test");
    }

    private JPanel createAnswerPanel() {
        javax.swing.JPanel panel = new javax.swing.JPanel(new FlowLayout());
        javax.swing.GroupLayout jAnswerPanelLayout = new javax.swing.GroupLayout(panel);
        ParallelGroup createParallelGroup = jAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
        SequentialGroup createSequentialGroup = jAnswerPanelLayout.createSequentialGroup().addContainerGap();

        panel.setLayout(jAnswerPanelLayout);



        for (int i = 0; i < 10; i++) {
            JLabel j = new JLabel();
            j.setOpaque(true);
            j.setText("Label #" + i);
            j.setBackground(new java.awt.Color(255, 153, 153));
            createParallelGroup.addComponent(j);
            createSequentialGroup.addComponent(j).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        }
        createSequentialGroup.addContainerGap();

        jAnswerPanelLayout.setHorizontalGroup(
                jAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(createSequentialGroup));

        jAnswerPanelLayout.setVerticalGroup(
                jAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jAnswerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createParallelGroup)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        return panel;
    }
}
