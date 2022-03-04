/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import Configuracoes.ConfigBase;
import Configuracoes.ConfigOrdens;
import Excel.AcoesExcel;
import Excel.ExcelAbreBancoDeDados;
import Excel.ExcelHandler;
import javax.swing.JButton;
import Resumos.Relatorios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Felipe Mattos
 */
public class IG extends javax.swing.JFrame {
    
    private static String nomeSimulacao = "Nome Simulação";
    private static String versao = "4.0.2";

    
    /**
     * Bloqueia ou Libera na IG Base a seleção de relatórios desejados 
     * @param b 
     */
    public static void setPodeSelecionarRelatorios(boolean b) {
        jTemRelCandles.setEnabled(b);
        jTemRelDiario.setEnabled(b);
        jTemRelMensal.setEnabled(b);
        jTemRelAnual.setEnabled(b);
        jTemRelOrdens.setEnabled(b);
        jTemRelResumo.setEnabled(b);
    }

    public static void setSimulacaoCompleta() {
        setPodeSelecionarRelatorios(false);
        
        jTemRelCandles.setSelected(false);
        jTemRelDiario.setSelected(false);
        jTemRelMensal.setSelected(false);
        jTemRelAnual.setEnabled(false);
        jTemRelOrdens.setSelected(false);
        jTemRelResumo.setSelected(true);
        
        jTemRelCompletoDiario.setEnabled(true);
    }

    public static boolean isTemRelCompletoDiario() {
        return jTemRelCompletoDiario.isSelected();
    }

    static void setTemRelCompletoDiario(boolean temCompleto) {
        if(temCompleto){
            setSimulacaoCompleta();
        } else{
            setPodeSelecionarRelatorios(true);
            jTemRelCompletoDiario.setSelected(false);
        }
    }

    public static boolean isTemRelAnual() {
        return jTemRelAnual.isSelected();
    }
    /**
     * Creates new form IG_Simulador
     */
    public IG() {
        initComponents();
    }

    Relatorios relatorio;
    float maxContador = 1;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jAtivo = new javax.swing.JComboBox<>();
        jProgressoCompleto = new javax.swing.JProgressBar();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jSimulacoes = new javax.swing.JComboBox<>();
        jSimulacoesMontaPos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDiario = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jDiaIni = new javax.swing.JComboBox<>();
        jMesIni = new javax.swing.JComboBox<>();
        jAnoIni = new javax.swing.JComboBox<>();
        jTemDataIni = new javax.swing.JCheckBox();
        jTemDataFin = new javax.swing.JCheckBox();
        jAnoFin = new javax.swing.JComboBox<>();
        jMesFin = new javax.swing.JComboBox<>();
        jDiaFin = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jHoraFin = new javax.swing.JComboBox<>();
        jMinFin = new javax.swing.JComboBox<>();
        jTemHorarioFin = new javax.swing.JCheckBox();
        jTemHorarioIni = new javax.swing.JCheckBox();
        jHoraIni = new javax.swing.JComboBox<>();
        jMinIni = new javax.swing.JComboBox<>();
        jTemHorarioLimEntrada = new javax.swing.JCheckBox();
        jHoraLimEntrada = new javax.swing.JComboBox<>();
        jMinLimEntrada = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jProgressoSimulação = new javax.swing.JProgressBar();
        jPanel6 = new javax.swing.JPanel();
        jTemRelCandles = new javax.swing.JCheckBox();
        jTemRelDiario = new javax.swing.JCheckBox();
        jTemRelMensal = new javax.swing.JCheckBox();
        jTemRelOrdens = new javax.swing.JCheckBox();
        jTemRelResumo = new javax.swing.JCheckBox();
        jTemRelCompletoDiario = new javax.swing.JCheckBox();
        jTemRelAnual = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelSimAtual = new javax.swing.JLabel();
        jLabelSimTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelTempoEstimado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador ver. " + versao);
        setResizable(false);
        setSize(new java.awt.Dimension(10, 10));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jAtivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jAtivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DOL", "IND", "AÇÃO" }));
        jAtivo.setPreferredSize(new java.awt.Dimension(67, 21));
        getContentPane().add(jAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 30));

        jProgressoCompleto.setStringPainted(true);
        getContentPane().add(jProgressoCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 460, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Importar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 30));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Simulações", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSimulacoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jSimulacoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abertura Completo", "Abertura Lista", "Abertura Merc Fut", "Auto GerRisco Inverte Reentrada", "Delta Local", "Extremos Candle Anterior", "Extremos Dia Anterior", "Inverte Extremos Locais", "Inverte Stop OCO", "Inverte Stop 1", "Inverte Stop 2", "Primeiro Offset Com Inversao", "Reentradas Delta", "Suporte E Resistencia TrStop" }));
        jSimulacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSimulacoesActionPerformed(evt);
            }
        });
        jPanel4.add(jSimulacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 270, -1));

        jSimulacoesMontaPos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jSimulacoesMontaPos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day Trade 1", "Day Trade 2", "Extremos Candle Anterior 1", "Extremos Candle Anterior 2", "Mercado Futuro 1", "Mercado Futuro 2", "Mais Menos OCO Extremos", "Mais Menos OCO Precos" }));
        jSimulacoesMontaPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSimulacoesMontaPosActionPerformed(evt);
            }
        });
        jPanel4.add(jSimulacoesMontaPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 270, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Monta Pos:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Indicador:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jDiario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jDiario.setText("Diário");
        jDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDiarioActionPerformed(evt);
            }
        });
        jPanel4.add(jDiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 69, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Day Trade:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 570, 180));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Data:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDiaIni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jDiaIni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jDiaIni.setEnabled(false);
        jPanel3.add(jDiaIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jMesIni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMesIni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jMesIni.setEnabled(false);
        jPanel3.add(jMesIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jAnoIni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jAnoIni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", " " }));
        jAnoIni.setSelectedIndex(3);
        jAnoIni.setEnabled(false);
        jPanel3.add(jAnoIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 60, -1));

        jTemDataIni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTemDataIni.setText("Data Inicial");
        jTemDataIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTemDataIniActionPerformed(evt);
            }
        });
        jPanel3.add(jTemDataIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jTemDataFin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTemDataFin.setText("Data Final");
        jTemDataFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTemDataFinActionPerformed(evt);
            }
        });
        jPanel3.add(jTemDataFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 83, -1));

        jAnoFin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jAnoFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021" }));
        jAnoFin.setSelectedIndex(4);
        jAnoFin.setEnabled(false);
        jPanel3.add(jAnoFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 60, -1));

        jMesFin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMesFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jMesFin.setSelectedIndex(5);
        jMesFin.setEnabled(false);
        jPanel3.add(jMesFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        jDiaFin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jDiaFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jDiaFin.setSelectedIndex(16);
        jDiaFin.setEnabled(false);
        jPanel3.add(jDiaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 280, 110));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Horario:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jHoraFin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jHoraFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" }));
        jHoraFin.setSelectedIndex(4);
        jHoraFin.setEnabled(false);
        jPanel5.add(jHoraFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        jMinFin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMinFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " ", " ", " " }));
        jMinFin.setEnabled(false);
        jPanel5.add(jMinFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 40, -1));

        jTemHorarioFin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTemHorarioFin.setText("Fechamento:");
        jTemHorarioFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTemHorarioFinActionPerformed(evt);
            }
        });
        jPanel5.add(jTemHorarioFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jTemHorarioIni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTemHorarioIni.setText("Inicial:");
        jTemHorarioIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTemHorarioIniActionPerformed(evt);
            }
        });
        jPanel5.add(jTemHorarioIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jHoraIni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jHoraIni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" }));
        jHoraIni.setSelectedIndex(4);
        jHoraIni.setEnabled(false);
        jPanel5.add(jHoraIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jMinIni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMinIni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " ", " ", " " }));
        jMinIni.setEnabled(false);
        jPanel5.add(jMinIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jTemHorarioLimEntrada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTemHorarioLimEntrada.setText("Lim. Entrada:");
        jTemHorarioLimEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTemHorarioLimEntradaActionPerformed(evt);
            }
        });
        jPanel5.add(jTemHorarioLimEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jHoraLimEntrada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jHoraLimEntrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" }));
        jHoraLimEntrada.setSelectedIndex(4);
        jHoraLimEntrada.setEnabled(false);
        jPanel5.add(jHoraLimEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jMinLimEntrada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMinLimEntrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " ", " ", " " }));
        jMinLimEntrada.setEnabled(false);
        jPanel5.add(jMinLimEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 280, 110));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 730, 140));

        jProgressoSimulação.setStringPainted(true);
        getContentPane().add(jProgressoSimulação, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 460, 30));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Relatórios:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTemRelCandles.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTemRelCandles.setText("Candle 1 min");
        jPanel6.add(jTemRelCandles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jTemRelDiario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTemRelDiario.setSelected(true);
        jTemRelDiario.setText("Diário");
        jPanel6.add(jTemRelDiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jTemRelMensal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTemRelMensal.setText("Mensal");
        jPanel6.add(jTemRelMensal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jTemRelOrdens.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTemRelOrdens.setSelected(true);
        jTemRelOrdens.setText("Ordens Executadas");
        jPanel6.add(jTemRelOrdens, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jTemRelResumo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTemRelResumo.setText("Resumo Total");
        jPanel6.add(jTemRelResumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTemRelCompletoDiario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTemRelCompletoDiario.setText("Completo Diiário");
        jTemRelCompletoDiario.setEnabled(false);
        jPanel6.add(jTemRelCompletoDiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jTemRelAnual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTemRelAnual.setText("Anual");
        jPanel6.add(jTemRelAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 180));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Progresso:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Simulações:");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabelSimAtual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSimAtual.setText("_______");
        jPanel7.add(jLabelSimAtual, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabelSimTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSimTotal.setText("_______");
        jPanel7.add(jLabelSimTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("/");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Tempo Estimado:");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabelTempoEstimado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTempoEstimado.setText("_______");
        jPanel7.add(jLabelTempoEstimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 260, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTemDataIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTemDataIniActionPerformed
        if(jTemDataIni.isSelected()){
            jDiaIni.setEnabled(true);
            jMesIni.setEnabled(true);
            jAnoIni.setEnabled(true);
        }else{
            jDiaIni.setEnabled(false);
            jMesIni.setEnabled(false);
            jAnoIni.setEnabled(false);
        }
    }//GEN-LAST:event_jTemDataIniActionPerformed

    private void jTemDataFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTemDataFinActionPerformed
        if(jTemDataFin.isSelected()){
            jDiaFin.setEnabled(true);
            jMesFin.setEnabled(true);
            jAnoFin.setEnabled(true);
        }else{
            jDiaFin.setEnabled(false);
            jMesFin.setEnabled(false);
            jAnoFin.setEnabled(false);
        }
    }//GEN-LAST:event_jTemDataFinActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Thread(() -> {
            textoLimpa();
            List<AcoesExcel> lista = new ArrayList();
            lista.add(new ExcelAbreBancoDeDados());
            new ExcelHandler(lista);
        }).start();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTemHorarioFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTemHorarioFinActionPerformed
        atualizaInterface();
    }//GEN-LAST:event_jTemHorarioFinActionPerformed

    private void jTemHorarioIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTemHorarioIniActionPerformed
        jHoraIni.setEnabled(jTemHorarioIni.isSelected());
        jMinIni.setEnabled(jTemHorarioIni.isSelected());
    }//GEN-LAST:event_jTemHorarioIniActionPerformed

    private void jDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDiarioActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new IG_IndicadoresDiario().setVisible(true);
        });
    }//GEN-LAST:event_jDiarioActionPerformed

    private void jTemHorarioLimEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTemHorarioLimEntradaActionPerformed
        jHoraLimEntrada.setEnabled(jTemHorarioLimEntrada.isSelected());
        jMinLimEntrada.setEnabled(jTemHorarioLimEntrada.isSelected());
    }//GEN-LAST:event_jTemHorarioLimEntradaActionPerformed

    private void jSimulacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSimulacoesActionPerformed
       abreSimulacaoSelecionada(jSimulacoes, "IG_Sim_");
    }//GEN-LAST:event_jSimulacoesActionPerformed

    private void jSimulacoesMontaPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSimulacoesMontaPosActionPerformed
        abreSimulacaoSelecionada(jSimulacoesMontaPos, "IG_Sim_MontaPos_");
    }//GEN-LAST:event_jSimulacoesMontaPosActionPerformed

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
            java.util.logging.Logger.getLogger(IG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new IG().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.ButtonGroup buttonGroup1;
    static javax.swing.JComboBox<String> jAnoFin;
    static javax.swing.JComboBox<String> jAnoIni;
    static javax.swing.JComboBox<String> jAtivo;
    static javax.swing.JButton jButton2;
    static javax.swing.JComboBox<String> jDiaFin;
    static javax.swing.JComboBox<String> jDiaIni;
    private javax.swing.JButton jDiario;
    static javax.swing.JComboBox<String> jHoraFin;
    static javax.swing.JComboBox<String> jHoraIni;
    static javax.swing.JComboBox<String> jHoraLimEntrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private static javax.swing.JLabel jLabelSimAtual;
    private static javax.swing.JLabel jLabelSimTotal;
    private static javax.swing.JLabel jLabelTempoEstimado;
    static javax.swing.JComboBox<String> jMesFin;
    static javax.swing.JComboBox<String> jMesIni;
    static javax.swing.JComboBox<String> jMinFin;
    static javax.swing.JComboBox<String> jMinIni;
    static javax.swing.JComboBox<String> jMinLimEntrada;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    static javax.swing.JPanel jPanel6;
    static javax.swing.JPanel jPanel7;
    static javax.swing.JProgressBar jProgressoCompleto;
    static javax.swing.JProgressBar jProgressoSimulação;
    private javax.swing.JScrollPane jScrollPane1;
    static javax.swing.JComboBox<String> jSimulacoes;
    static javax.swing.JComboBox<String> jSimulacoesMontaPos;
    static javax.swing.JCheckBox jTemDataFin;
    static javax.swing.JCheckBox jTemDataIni;
    static javax.swing.JCheckBox jTemHorarioFin;
    static javax.swing.JCheckBox jTemHorarioIni;
    static javax.swing.JCheckBox jTemHorarioLimEntrada;
    static javax.swing.JCheckBox jTemRelAnual;
    static javax.swing.JCheckBox jTemRelCandles;
    static javax.swing.JCheckBox jTemRelCompletoDiario;
    static javax.swing.JCheckBox jTemRelDiario;
    static javax.swing.JCheckBox jTemRelMensal;
    static javax.swing.JCheckBox jTemRelOrdens;
    static javax.swing.JCheckBox jTemRelResumo;
    static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    
    public static void textoAdd(String texto){
        jTextArea1.append(texto);
    }
    
    public static void textoLimpa(){
        for(int i = 0; i<=jTextArea1.getRows(); i++){
            jTextArea1.setText(null);
        }
    }
    
    public static void progressoCompletoIndeterminado(boolean indet){
        jProgressoCompleto.setIndeterminate(indet);
        jProgressoCompleto.setStringPainted(!indet);
    }
    
    public static void progressoCompletoAtualiza(int max, int atual){
        progressoCompletoIndeterminado(false);
        jProgressoCompleto.setMaximum(max);
        jProgressoCompleto.setValue(atual);
    }
    
    public static void progressoCompletoAtualiza(int atual){
        jProgressoCompleto.setValue(atual);
    }
    
    public static void progressoCompletoReseta(){
        jProgressoCompleto.setValue(jProgressoCompleto.getMinimum());
    }
    
    public static void progressoSimulacaoIndeterminado(boolean indet){
        jProgressoSimulação.setIndeterminate(indet);
        jProgressoSimulação.setStringPainted(!indet);
    }
    
    public static void progressoSimulacaoAtualiza(int max, int atual){
        progressoCompletoIndeterminado(false);
        jProgressoSimulação.setMaximum(max);
        jProgressoSimulação.setValue(atual);
    }
    
    /**
     * Atualiza a barra de progresso da simulação detalhada e completo, adicionando "+ 1"  no valor atual.
     * Deve ser executado a cada minuto analizado (ex. no método CriaCandle)
     */
    public static void progressoAtualiza(){
        jProgressoSimulação.setValue(jProgressoSimulação.getValue() +1);
        jProgressoCompleto.setValue(jProgressoCompleto.getValue() +1);
    }
    
    public static void progressoSimulacaoReseta(){
        jProgressoSimulação.setValue(jProgressoSimulação.getMinimum());
    }
    
    private void atualizaInterface(){
        jHoraFin.setEnabled(jTemHorarioFin.isSelected());
        jMinFin.setEnabled(jTemHorarioFin.isSelected());
    }
    
    public static void configuraGerais() throws NumberFormatException{
        int
        passoMin = jAtivo.getSelectedIndex(),
        diaIni = Integer.parseInt(jDiaIni.getSelectedItem().toString()),
        mesIni = Integer.parseInt(jMesIni.getSelectedItem().toString()),
        anoIni = Integer.parseInt(jAnoIni.getSelectedItem().toString()),
        diaFin = Integer.parseInt(jDiaFin.getSelectedItem().toString()),
        mesFin = Integer.parseInt(jMesFin.getSelectedItem().toString()),
        anoFin = Integer.parseInt(jAnoFin.getSelectedItem().toString()),
        horaIni = Integer.parseInt(jHoraIni.getSelectedItem().toString()),
        horaLimEntrada = Integer.parseInt(jHoraLimEntrada.getSelectedItem().toString()),
        horaFin = Integer.parseInt(jHoraFin.getSelectedItem().toString()),
        minIni = Integer.parseInt(jMinIni.getSelectedItem().toString()),
        minLimEntrada = Integer.parseInt(jMinLimEntrada.getSelectedItem().toString()),
        minFin = Integer.parseInt(jMinFin.getSelectedItem().toString());
        
        boolean
        temDataIni = jTemDataIni.isSelected(),
        temDataFin = jTemDataFin.isSelected(),
        temHorarioIni = jTemHorarioIni.isSelected(),
        temHorarioLimEntrada = jTemHorarioLimEntrada.isSelected(),
        temHorarioFin = jTemHorarioFin.isSelected(),
        temRelatorioCandles = jTemRelCandles.isSelected();
        
        configuraEstrategia();
        
        ConfigBase.setPassoMin(passoMin);
        
        //ANALISE PERÍODOS E MONITORA SALDO
        ConfigBase.configuraHorarioInicial(temHorarioIni, horaIni, minIni);
        ConfigBase.configuraHorarioLimiteEntrada(temHorarioLimEntrada, horaLimEntrada, minLimEntrada);
        ConfigBase.configuraHorarioFinal(temHorarioFin, horaFin, minFin);
        ConfigBase.configuraPeriodoInicialBancoDeDados(temDataIni, diaIni, mesIni, anoIni);
        ConfigBase.configuraPeriodoFinalBancoDeDados(temDataFin, diaFin, mesFin, anoFin);
        
        ConfigBase.setTemRelatorioCandles(temRelatorioCandles);
        ConfigOrdens.apagaListaOrdensFixas();
    }

    private static void configuraEstrategia() throws NumberFormatException {
        int ativo = jAtivo.getSelectedIndex();
        ConfigOrdens.setAtivo(ativo);
    }

    /**
     * informa se a interface gráfica pode permitir abrir novas interfaces de 
     * simulações
     * @param selecao 
     */
    public static void setPodeAbrirSimulacao(boolean selecao){
        jSimulacoes.setEnabled(selecao);
        jSimulacoesMontaPos.setEnabled(selecao);
    }
    
    public static void setNomeSimulacao(String nome){
        nomeSimulacao = nome;
    }
    
    public static String getNomeSimulacao(){
        return nomeSimulacao;
    }
    
    public static void aborta(JButton botao, Thread threadSimulacao){
        if(threadSimulacao != null){
            threadSimulacao.stop();
            if(!Relatorios.isGravouRelatorios()){
                IG.textoAdd("\nOPERAÇÃO ABORTADA PELO USUÁRIO");
                if(!ConfigOrdens.isTemCompleto())
                    Relatorios.geraExcelDetalhado();
                else
                    Relatorios.geraExcelCompleto();
            }
        }
        setPodeSelecionarRelatorios(true);
    }
    
    public static String printVersao(){
        return "ver: " + versao;
    }
    
    public static void atualizaTotalSimulacoes(int total){
        jLabelSimTotal.setText(String.valueOf(total));
    }
    
    public static void atualizaSimulacaoAtual(long simAtual){
        jLabelSimAtual.setText(String.valueOf(simAtual));
    }

    public static boolean isTemRelCandles() {
        return jTemRelCandles.isSelected();
    }

    public static boolean isTemRelDiario() {
        return jTemRelDiario.isSelected();
    }

    public static boolean isTemRelMensal() {
        return jTemRelMensal.isSelected();
    }
    
    public static boolean isTemRelOrdens() {
        return jTemRelOrdens.isSelected();
    }

    public static boolean isTemRelResumo() {
        return jTemRelResumo.isSelected();
    }
    
    
    public static void atualizaTempoEstimado(long tempoEstimado){
        long segundos, minutos, hora, dia;
        int seg, min, h, d;
    	
    	segundos = (tempoEstimado/1000000000);
    	minutos = segundos/60;
    	hora = minutos / 60;
    	dia = hora / 24;
    	
    	seg = (int) segundos % 60;
    	min = (int) minutos % 60;
    	h = (int) hora % 24;
    	d = (int) dia;
    	
        jLabelTempoEstimado.setText(d + " dias, " + h + ":" + min + ":" + seg);
    }
    
    private static void abreSimulacaoSelecionada(JComboBox comboBox, String prefixoInterface){
        String pacote = "InterfaceGrafica.";
        String nomeSimulacao = comboBox.getSelectedItem().toString().replace(" ", "");
        String nomeClasse = pacote + prefixoInterface + nomeSimulacao;

        try {
            Class classe = Class.forName(nomeClasse);
            JFrame janela = (JFrame) classe.newInstance();
            janela.setVisible(true);
            
            
        } catch (InstantiationException ex ) {
            textoAdd("ERRO! " + ex + System.lineSeparator());
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            textoAdd("ERRO! " + ex + System.lineSeparator());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            textoAdd("ERRO! " + ex + System.lineSeparator());
            ex.printStackTrace();
        }
    }
    
    
}