package br.com.desktop.elderbr.view;

import br.com.desktop.elderbr.model.Item;
import br.com.desktop.elderbr.utils.Caminho;
import br.com.desktop.elderbr.utils.Langs;
import br.com.desktop.elderbr.utils.Version;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.Material;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author User
 */
public class HomeView extends javax.swing.JFrame {

    private File fileVersionPath;
    private File fileVersion;
    private File fileLang;

    private String pastaLang = null;
    private SortedMap<String, String> map;
    private File fileSkins;
    private List<String> listSkins;

    private Item item;
    private List<String> listMaterial;
    private int progInt;

    private final String ROOT = Caminho.getPathRoot();

    private double version;
    private String lang;

    public HomeView() {
        initComponents();

        try {// Adicionando o icone            
            Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("br/com/desktop/elderbr/img/icon_smarthopper.png").toString());
            this.setIconImage(icon);
        } catch (Exception e) {
            System.err.println("Erro ao carregar o icon!");
        }

        // PEGANDO O DIRETÓRIO PADRÃO DO SISTEMA
        fileVersionPath = new File(ROOT.concat("AppData\\Roaming\\.minecraft\\assets\\indexes\\"));

        progresso.setVisible(false);

        cboxLang.setModel(new Langs());
        cboxLang.setSelectedItem("pt_br");

        // VERSÕES
        cboxVersion.setModel(new Version());
        cboxVersion.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcons = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cboxLang = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboxVersion = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        tfArquivo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        panelCarregamento = new javax.swing.JPanel();
        progresso = new javax.swing.JProgressBar();
        lbProgresso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Extrair Tradução");
        setBackground(new java.awt.Color(102, 102, 102));

        lbIcons.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Extrair Tradução");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        cboxLang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxLang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxLangActionPerformed(evt);
            }
        });

        jLabel1.setText("Linguagem");

        jLabel2.setText("Versão");

        cboxVersion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxVersionActionPerformed(evt);
            }
        });

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Escolha onde deseja salvar:");

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(cboxLang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(cboxVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfArquivo))
                        .addGap(18, 18, 18)
                        .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxLang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrir))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCarregamento.setBackground(new java.awt.Color(51, 51, 51));

        lbProgresso.setForeground(new java.awt.Color(255, 255, 255));
        lbProgresso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProgresso.setText("Item");

        javax.swing.GroupLayout panelCarregamentoLayout = new javax.swing.GroupLayout(panelCarregamento);
        panelCarregamento.setLayout(panelCarregamentoLayout);
        panelCarregamentoLayout.setHorizontalGroup(
            panelCarregamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarregamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCarregamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelCarregamentoLayout.setVerticalGroup(
            panelCarregamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarregamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progresso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbProgresso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcons, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(panelCarregamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIcons, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCarregamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cboxLangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxLangActionPerformed
        if (evt.getModifiers() < 1) {
            return;
        }
        arquivo();
    }//GEN-LAST:event_cboxLangActionPerformed

    private void cboxVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxVersionActionPerformed
        if (evt.getModifiers() < 1) {
            return;
        }
        arquivo();
    }//GEN-LAST:event_cboxVersionActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        fileLang = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.getCurrentDirectory();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setVisible(true);
        int response = fileChooser.showOpenDialog(rootPane);
        if (response == JFileChooser.APPROVE_OPTION) {
            fileLang = fileChooser.getSelectedFile();
            tfArquivo.setText(fileLang.getAbsolutePath());
            btnSalvar.setEnabled(true);
            arquivo();
        } else {
            btnSalvar.setEnabled(false);
            tfArquivo.setText("");
            fileLang = null;
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // PAINEL DE CARREGAMENTO VISIVEL
        progresso.setVisible(true);

        // Caminho do arquivo
        fileSkins = new File(ROOT.concat("AppData\\Roaming\\.minecraft\\assets\\objects") + File.separator + pastaLang.substring(0, 2) + File.separator + pastaLang);

        // PROGRESSO DO SALVAMENTO DO ARQUIVO
        progresso.setValue(0);
        progresso.setMaximum(Material.values().length);
        progInt = 1;

        btnSalvar.setEnabled(false);
        tfArquivo.setText("");
        cboxLang.requestFocus();

        new Thread() {
            @Override
            public void run() {

                // Lista de texto do skins                
                listSkins = new ArrayList<>();
                String txt = null;
                try (BufferedReader ler = Files.newBufferedReader(fileSkins.toPath(), StandardCharsets.UTF_8)) {
                    while ((txt = ler.readLine()) != null) {
                        listSkins.add(txt.trim());

                        // ADICIONANDO PROGRESSO
                        lbProgresso.setText("Arquivo padrão do lang " + txt);
                        progresso.setValue(progInt);
                        progInt++;
                    }
                } catch (IOException e) {
                    System.err.println("Erro ao ler o arquivo >> erro: " + e.getMessage());
                }

                // LISTA DE MATERIAIS
                listMaterial = new ArrayList<>();
                try {
                    for (Material material : Material.values()) {
                        if (material.isItem() && !material.isAir()) {
                            listMaterial.add(material.getKey().getKey());
                            // ADICIONANDO PROGRESSO
                            lbProgresso.setText("Arquivo materias " + Item.ToString(material));
                            progresso.setValue(progInt);
                            progInt++;
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Erro ao percorrer os materiais!\n" + e);
                }
                progresso.setValue(6001);

                // PESQUISANDO NO ARQUIVO SKINS SE TEM O MATERIAL
                progInt = 0;
                progresso.setValue(0);
                progresso.setMaximum((listSkins.size() + listMaterial.size()));
                map = new TreeMap<>();
                String item;
                String key, value;
                for (String skins : listSkins) {
                    for (String materils : listMaterial) {
                        if (skins.contains("item.minecraft." + materils) || skins.contains("block.minecraft." + materils)) {

                            item = skins.replaceAll("item.minecraft.", "")
                                    .replaceAll("block.minecraft.", "").trim();

                            // PEGANDO A CHAVE PRINCIPAL
                            key = item.substring(0, item.indexOf(":"))
                                    .replaceAll(".effect.", " ")
                                    .replaceAll("\"", "")
                                    .replaceAll("[._]", " ")
                                    .replaceAll(" potion ", " ");
                            // PEGANDO A TRADUÇÃO
                            value = StringEscapeUtils.unescapeJava(item.substring(item.indexOf(": ") + 1, item.length())).replaceAll(",", "").trim();

                            // SALVANDO NO MAPS
                            map.put(key, value);

                            // ADICIONANDO PROGRESSO
                            lbProgresso.setText("Comparando arquivos " + key);
                            progresso.setValue(progInt);
                            progInt++;
                        }
                    }
                }
                progresso.setValue((listSkins.size() + listMaterial.size()));

                // SALVO O ARQUIVO
                progInt = 0;
                progresso.setValue(0);
                progresso.setMaximum(map.size());
                try (BufferedWriter w = Files.newBufferedWriter(new File(fileLang.getAbsolutePath(), cboxLang.getSelectedItem().toString() + "_" + cboxVersion.getSelectedItem() + ".yml").toPath(), StandardCharsets.UTF_8)) {
                    for (Map.Entry<String, String> maps : map.entrySet()) {
                        w.write(maps.getKey().trim() + ": " + maps.getValue().trim());
                        // COMPARA SE É A ÚLTIMA LINHA
                        if ((progInt + 1) < map.size()) {
                            w.newLine();
                        }
                        w.flush();

                        // ADICIONANDO PROGRESSO
                        lbProgresso.setText("Salvando o arquivo " + maps.getKey());
                        progresso.setValue(progInt);
                        progInt++;

                    }
                    lbProgresso.setText("Arquivos Salvos");
                    progresso.setValue(map.size() + 1);
                } catch (IOException ex) {
                    Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
                }

                // CRIANDO UMA PAUSA
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {

                }
                progresso.setVisible(false);
            }
        }.start();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cboxLang;
    private javax.swing.JComboBox<String> cboxVersion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbIcons;
    private javax.swing.JLabel lbProgresso;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel panelCarregamento;
    private javax.swing.JProgressBar progresso;
    private javax.swing.JTextField tfArquivo;
    // End of variables declaration//GEN-END:variables

    private void arquivo() {

        pastaLang = null;

        try {

            // PEGANDO A VERSÃO ESCOLHIDA
            version = Caminho.Version(cboxVersion.getSelectedItem().toString());

            fileVersion = new File(fileVersionPath.getAbsolutePath(), cboxVersion.getSelectedItem().toString().concat(".json"));
            JSONParser parser = new JSONParser();
            JSONObject jsonPric = (JSONObject) parser.parse(new FileReader(fileVersion));
            JSONObject jsonLang = (JSONObject) parser.parse(jsonPric.get("objects").toString());
            // VERIFICA O TIPO DA VERSÃO MAIOR QUE 14 TEM EXTENSÃO JSON
            if (version > 13) {
                lang = "minecraft/lang/".concat(cboxLang.getSelectedItem().toString().concat(".json"));
            } else {
                String[] langA = cboxLang.getSelectedItem().toString().split("_");
                if (version == 12) {
                    lang = "minecraft/lang/".concat(langA[0] + "_" + langA[1]).concat(".lang");
                } else {
                    lang = "minecraft/lang/".concat(langA[0] + "_" + langA[1].toUpperCase()).concat(".lang");
                }
            }
            JSONObject jsonhash = (JSONObject) parser.parse(jsonLang.get(lang).toString());
            pastaLang = jsonhash.get("hash").toString();
            System.out.println("hash >> " + pastaLang);
        } catch (FileNotFoundException ex) {
            btnSalvar.setEnabled(false);
            lbProgresso.setText("");
            fileLang = null;
            JOptionPane.showMessageDialog(rootPane, "Essa versão não foi aberta, você precisa abrir nessa versão para poder pegar as informações!!!");
        } catch (IOException | NullPointerException ex) {
            System.err.println("Arquivo não encontrado: " + ex.getMessage());
            Logger.getLogger(Version.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Version.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
