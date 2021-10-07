/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Aplikasi.java
 *
 * Created on Dec 25, 2010, 6:32:07 AM
 */

package backpropagation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import model.Bobot;
import model.HiddenNode;
import model.InputNode;
import model.OutputNode;

/**
 *
 * @author fendi
 */
public class Aplikasi extends javax.swing.JFrame {
    private List<InputNode> input;
    private List<HiddenNode> hidden;
    private List<OutputNode> output;
    private List<Bobot> bobotHide;
    private List<Bobot> bobotOut;
    /** Creates new form Aplikasi */
    public Aplikasi() {
        initComponents();
        setLocationRelativeTo(this);
        initAwal();
    }
    
    private void initAwal(){
        double bobotHideArray[][]=new double[15][3];
        //inisialisasi array dari pelatihan
        double bobotOutArray[][]=new double[3][5];
        //inisialisasi array dari pelatihan
        
        bobotHideArray[0] [0]=1.8403184130973975;
        bobotHideArray[0] [1]=-1.7292734702056447;
        bobotHideArray[0] [2]=-3.3926052444320147;
        bobotHideArray[1] [0]=-1.4390569256670585;
        bobotHideArray[1] [1]=7.133670534636676;
        bobotHideArray[1] [2]=-4.770451181559628;
        bobotHideArray[2] [0]=1.3160246549499461;
        bobotHideArray[2] [1]=1.1545085445624925;
        bobotHideArray[2] [2]=-1.8979632532707518;
        bobotHideArray[3] [0]=-0.384873091644448;
        bobotHideArray[3] [1]=1.3157912935056653;
        bobotHideArray[3] [2]=0.818144129064854;
        bobotHideArray[4] [0]=-1.445147903869768;
        bobotHideArray[4] [1]=-1.0912489017906388;
        bobotHideArray[4] [2]=6.904409022082976;
        bobotHideArray[5] [0]=4.755756155593341;
        bobotHideArray[5] [1]=-0.322169474263925;
        bobotHideArray[5] [2]=-2.039456571387217;
        bobotHideArray[6] [0]=-0.8032732067250268;
        bobotHideArray[6] [1]=1.9004169270581184;
        bobotHideArray[6] [2]=1.7085297963563166;
        bobotHideArray[7] [0]=-0.3667131175990126;
        bobotHideArray[7] [1]=-1.9104448269967504;
        bobotHideArray[7] [2]=0.41923086198279924;
        bobotHideArray[8] [0]=-4.100765034838762;
        bobotHideArray[8] [1]=0.17260328918698795;
        bobotHideArray[8] [2]=2.9682529267816884;
        bobotHideArray[9] [0]=-1.5211169530668014;
        bobotHideArray[9] [1]=-2.155588413632532;
        bobotHideArray[9] [2]=6.397061563922806;
        bobotHideArray[10] [0]=3.20338724762299;
        bobotHideArray[10] [1]=-1.3404271557063945;
        bobotHideArray[10] [2]=-1.1769201107371017;
        bobotHideArray[11] [0]=2.520405684286623;
        bobotHideArray[11] [1]=1.2424443720097762;
        bobotHideArray[11] [2]=-0.7800051015061829;
        bobotHideArray[12] [0]=0.9639517060926444;
        bobotHideArray[12] [1]=-0.6901018174193134;
        bobotHideArray[12] [2]=-1.5234100834689666;
        bobotHideArray[13] [0]=0.4909108070272004;
        bobotHideArray[13] [1]=-1.9459860994975224;
        bobotHideArray[13] [2]=3.038207200291977;
        bobotHideArray[14] [0]=-0.4230045602075288;
        bobotHideArray[14] [1]=-1.4869194771512189;
        bobotHideArray[14] [2]=-0.7386086628097351;
        bobotOutArray[0] [0]=2.5872303282024594;
        bobotOutArray[0] [1]=4.958454630713291;
        bobotOutArray[0] [2]=-10.135280305426942;
        bobotOutArray[0] [3]=5.845803077734453;
        bobotOutArray[0] [4]=-11.95605679315237;
        bobotOutArray[1] [0]=1.661237499940012;
        bobotOutArray[1] [1]=-11.554509223214746;
        bobotOutArray[1] [2]=-5.971741764279146;
        bobotOutArray[1] [3]=4.246858704686644;
        bobotOutArray[1] [4]=8.169090549985281;
        bobotOutArray[2] [0]=-14.446677011056293;
        bobotOutArray[2] [1]=7.360876629431419;
        bobotOutArray[2] [2]=8.005887390096776;
        bobotOutArray[2] [3]=-10.526739158823997;
        bobotOutArray[2] [4]=3.8402123441361695;
        
        input=new ArrayList<InputNode>();
        for(int i=0;i<15;i++){
            input.add(new InputNode(0));
        }
        hidden=new ArrayList<HiddenNode>();
        for(int i=0;i<3;i++){
            hidden.add(new HiddenNode(0,"Hidden "+i));
        }
        output=new ArrayList<OutputNode>();
        for(int i=0;i<5;i++){
            output.add(new OutputNode(0,"Output "+i));
        }
        //inisialisasi bobot to hidden
        int bobotCount=0;
        bobotHide=new ArrayList<Bobot>();
        for(int i=0;i<input.size();i++){
            for(int j=0;j<hidden.size();j++){
                bobotHide.add(new Bobot(bobotHideArray[i][j], "bobotIn["+i+"]["+j+"]"));
                bobotHide.get(bobotCount).setNodeInput(input.get(i));
                bobotHide.get(bobotCount).setNodeTarget(hidden.get(j));
                hidden.get(j).addBobotIn(bobotHide.get(bobotCount));
                bobotCount++;
            }
        }
        
        //inisialisasi bobot to out
        bobotCount=0;
        bobotOut=new ArrayList<Bobot>();
        for(int j=0;j<hidden.size();j++){
            for(int k=0;k<output.size();k++){
                bobotOut.add(new Bobot(bobotOutArray[j][k], "bobotIn["+j+"]["+k+"]"));
                bobotOut.get(bobotCount).setNodeInput(hidden.get(j));
                bobotOut.get(bobotCount).setNodeTarget(output.get(k));
                hidden.get(j).addBobotOut(bobotOut.get(bobotCount));
                output.get(k).addBobotIn(bobotOut.get(bobotCount));
                bobotCount++;
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button1 = new backpropagation.Button();
        button2 = new backpropagation.Button();
        button3 = new backpropagation.Button();
        button4 = new backpropagation.Button();
        button5 = new backpropagation.Button();
        button6 = new backpropagation.Button();
        button7 = new backpropagation.Button();
        button8 = new backpropagation.Button();
        button9 = new backpropagation.Button();
        button10 = new backpropagation.Button();
        button11 = new backpropagation.Button();
        button12 = new backpropagation.Button();
        button13 = new backpropagation.Button();
        button14 = new backpropagation.Button();
        button15 = new backpropagation.Button();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        outputLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pengenalan Huruf-Backpropagation");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));

        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button10ActionPerformed(evt);
            }
        });

        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button12ActionPerformed(evt);
            }
        });

        button13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button13ActionPerformed(evt);
            }
        });

        button14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button14ActionPerformed(evt);
            }
        });

        button15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jButton1.setText("Read");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        outputLabel.setFont(new java.awt.Font("Tahoma", 0, 72)); // NOI18N
        outputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(outputLabel, java.awt.BorderLayout.CENTER);

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 226, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        button1.tekanButton();
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        button2.tekanButton();
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        button3.tekanButton();
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        button4.tekanButton();
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        button5.tekanButton();
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        button6.tekanButton();
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        button7.tekanButton();
    }//GEN-LAST:event_button7ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        button8.tekanButton();
    }//GEN-LAST:event_button8ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        button9.tekanButton();
    }//GEN-LAST:event_button9ActionPerformed

    private void button10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button10ActionPerformed
        button10.tekanButton();
    }//GEN-LAST:event_button10ActionPerformed

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        button11.tekanButton();
    }//GEN-LAST:event_button11ActionPerformed

    private void button12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button12ActionPerformed
        button12.tekanButton();
    }//GEN-LAST:event_button12ActionPerformed

    private void button13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button13ActionPerformed
        button13.tekanButton();
    }//GEN-LAST:event_button13ActionPerformed

    private void button14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button14ActionPerformed
        button14.tekanButton();
    }//GEN-LAST:event_button14ActionPerformed

    private void button15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button15ActionPerformed
        button15.tekanButton();
    }//GEN-LAST:event_button15ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        input.get(0).setNilai(button1.getNilai());
        input.get(1).setNilai(button2.getNilai());
        input.get(2).setNilai(button3.getNilai());
        
        input.get(3).setNilai(button4.getNilai());
        input.get(4).setNilai(button5.getNilai());
        input.get(5).setNilai(button6.getNilai());
       
        input.get(6).setNilai(button7.getNilai());
        input.get(7).setNilai(button8.getNilai());
        input.get(8).setNilai(button9.getNilai());
        
        input.get(9).setNilai(button10.getNilai());
        input.get(10).setNilai(button11.getNilai());
        input.get(11).setNilai(button12.getNilai());
        
        input.get(12).setNilai(button13.getNilai());
        input.get(13).setNilai(button14.getNilai());
        input.get(14).setNilai(button15.getNilai());
        
        for(int i=0;i<hidden.size();i++){
            hidden.get(i).aktivasi();
        }
        int hasil=0;
        int init=4;
        for(int i=0;i<output.size();i++){
            output.get(i).aktivasi();
            hasil+=Math.pow(2,init--)*output.get(i).getNilaiBulat();
            System.out.print("["+output.get(i).getNilaiBulat()+"]");
        }
        System.out.println();
        char value= (char) (64+hasil);
        outputLabel.setText(String.valueOf(value));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        button1.reset();
        button2.reset();
        button3.reset();
        button4.reset();
        button5.reset();
        button6.reset();
        button7.reset();
        button8.reset();
        button9.reset();
        button10.reset();
        button11.reset();
        button12.reset();
        button13.reset();
        button14.reset();
        button15.reset();
        outputLabel.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplikasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private backpropagation.Button button1;
    private backpropagation.Button button10;
    private backpropagation.Button button11;
    private backpropagation.Button button12;
    private backpropagation.Button button13;
    private backpropagation.Button button14;
    private backpropagation.Button button15;
    private backpropagation.Button button2;
    private backpropagation.Button button3;
    private backpropagation.Button button4;
    private backpropagation.Button button5;
    private backpropagation.Button button6;
    private backpropagation.Button button7;
    private backpropagation.Button button8;
    private backpropagation.Button button9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel outputLabel;
    // End of variables declaration//GEN-END:variables

}
