/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import java.awt.Dimension;

/**
 *
 * @author ALESON
 */
public class TextAdventureGUI extends javax.swing.JFrame {
    String gameMode = "story";
    Scene currenBatleScene;
    DefaultListModel model, playermodel, systemmodel, optionsmodel;
    DefaultListModel listmodel;
    Character player, system;
    private Map<String, Scene> scenesMap = new HashMap<String, Scene>();
    String weapon = "default";
    int weaponHealth = 100;
    String sweapon = "default";
    int shealth = 100;
    String current = "";
    int magicEffect = 0;

    /**
     * Creates new form TextAdventureGUI
     */
    public TextAdventureGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(12, 415, 118, 14);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(248, 415, 193, 14);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBounds(10, 13, 198, 14);
        optionslabel = new javax.swing.JLabel();
        optionslabel.setBounds(12, 245, 118, 14);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(10, 272, 668, 130);
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane2.setBounds(10, 40, 668, 192);
        jScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        confirmbutton = new javax.swing.JButton();
        confirmbutton.setBounds(690, 272, 80, 49);
        load = new javax.swing.JButton();
        load.setBounds(690, 41, 80, 49);
        save = new javax.swing.JButton();
        save.setBounds(690, 103, 80, 49);
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane3.setBounds(10, 442, 198, 198);
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane4.setBounds(245, 442, 196, 198);
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane5.setBounds(481, 442, 197, 198);
        label = new javax.swing.JLabel();
        label.setBounds(481, 415, 80, 14);
        usemagiclabel = new javax.swing.JLabel();
        usemagiclabel.setBounds(481, 415, 80, 14);
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane6.setBounds(482, 442, 196, 198);
        use = new javax.swing.JButton();
        use.setBounds(690, 442, 80, 49);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 700));
        // playerlist.setVisible(false);
        use.setVisible(false);
        // enemylist.setVisible(false);
        label.setVisible(false);

        model = new DefaultListModel();
        playermodel = new DefaultListModel();
        systemmodel = new DefaultListModel();
        optionsmodel = new DefaultListModel();
        listmodel = new DefaultListModel();

        jLabel1.setText("Player Progress");

        jLabel2.setText("Enemy Progress");

        jLabel3.setText("Overview");

        optionslabel.setText("Player Options");

        confirmbutton.setText("Confirm");

        confirmbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmbuttonActionPerformed(evt);
            }
        });

        load.setText("Load");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        label.setText("Use Item");

        usemagiclabel.setText("UseMagic");

        use.setText("Use");
        use.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useActionPerformed(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        getContentPane().add(jLabel2);
        getContentPane().add(confirmbutton);
        getContentPane().add(optionslabel);
        getContentPane().add(jScrollPane1);
        
                optionslist = new javax.swing.JList();
                jScrollPane1.setViewportView(optionslist);
                optionslist.setModel(optionsmodel);
        getContentPane().add(jScrollPane2);
        overViewTA = new JTextArea();
        overViewTA.setEditable(false);
        jScrollPane2.setViewportView(overViewTA);
        overViewTA.setWrapStyleWord(true);
        overViewTA.setLineWrap(true);
        javax.swing.text.DefaultCaret caret = (DefaultCaret) overViewTA.getCaret();
        caret.setUpdatePolicy(javax.swing.text.DefaultCaret.ALWAYS_UPDATE);
        getContentPane().add(usemagiclabel);
        getContentPane().add(label);
        getContentPane().add(jScrollPane5);
        list = new javax.swing.JList();
        jScrollPane5.setViewportView(list);
        list.setVisible(false);
        getContentPane().add(jScrollPane6);
        usemagiclist = new javax.swing.JList();
        jScrollPane6.setViewportView(usemagiclist);
        usemagiclist.setVisible(false);
        getContentPane().add(use);
        getContentPane().add(jScrollPane3);
        playerlist = new javax.swing.JList();
        jScrollPane3.setViewportView(playerlist);
        getContentPane().add(jScrollPane4);
        enemylist = new javax.swing.JList();
        jScrollPane4.setViewportView(enemylist);
        getContentPane().add(jLabel3);
        getContentPane().add(load);
        getContentPane().add(save);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmbuttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_confirmbuttonActionPerformed
        if (gameMode.equals("fight")) {
            int option = optionslist.getSelectedIndex();
            if (option == 0) {
                System.out.println("Attack");
                model.addElement("Player Chooses to attack");
                overViewTA.setText(overViewTA.getText() + "\n" + "Player Chooses to attack");
                overViewTA.repaint();
                Random n = new Random();
                int attack = n.nextInt(20);
                int intelligence = player.getIntl();
                int enemyDex = system.getDex();
                if ((attack + intelligence) > enemyDex) {
                    model.addElement("Attack successful");
                    overViewTA.setText(overViewTA.getText() + "\n" + "Attack successful");
                    overViewTA.repaint();
                    model.addElement("Player has damaged Enemy");
                    overViewTA.setText(overViewTA.getText() + "\n" + "Player has damaged Enemy");
                    overViewTA.repaint();
                    attack(weapon);
                }

                if (system.getCon() > 0) {
                    SystemTurn();
                } else {
                    model.addElement("Player Wins");
                    overViewTA.setText(overViewTA.getText() + "\n" + "Player Wins");
                    overViewTA.repaint();

                    playermodel.clear();
                    systemmodel.clear();
                    gameMode = "story";
                    initScene(scenesMap.get(currenBatleScene.getVictory()));

                }
            } else if (option == 1) {
                System.out.println("Use Magic");
                model.addElement("Player Chooses to Use Magic");
                overViewTA.setText(overViewTA.getText() + "\n" + "Player Chooses to Use Magic");
                overViewTA.repaint();

                useMagic();
            } else if (option == 2) {
                System.out.println("Use Item");
                model.addElement("Player Chooses to Use Item");
                overViewTA.setText(overViewTA.getText() + "\n" + "Player Chooses to Use Item");
                overViewTA.repaint();

                useItem();
            } else if (option == 3) {
                System.out.println("Flee");
                model.addElement("Player Chooses to Flee");
                overViewTA.setText(overViewTA.getText() + "\n" + "Player Chooses to Use Flee");
                overViewTA.repaint();

                Flee();
                System.out.println("Back in confirmbuttonActionPerformed");
            }
        } else {
            Choice choice = (Choice) optionslist.getSelectedValue();
            if (choice != null)
                currenBatleScene = scenesMap.get(choice.getOutSceneId());
            if (currenBatleScene != null) {
                initScene(currenBatleScene);
            }
        }
    }// GEN-LAST:event_confirmbuttonActionPerformed

    void attack(String weapon) {

        if (weapon.equals("default")) {
            player.setStr(player.getStr() + 5);
            player.setDex(player.getDex() + 5);
            player.setIntl(player.getIntl() + 5);
            player.setFth(player.getFth() + 5);
            player.setStr(player.getStr() - 4);

            weaponHealth -= 10;

            system.setDex(system.getDex() - 4);
            system.setCon(system.getCon() - 20);
        } else if (weapon.contains("Magic")) {
            system.setCon(system.getCon() - magicEffect);
        }
        setModels();

    }

    void useMagic() {
        listmodel.removeAllElements();
        current = "Item";
        use.setVisible(true);
        label.setVisible(false);
        list.setVisible(true);
        usemagiclabel.setVisible(true);
        current = "Magic";

        System.out.println(current);

        for (String s : player.magic.keySet()) {
            System.out.println(s);
            listmodel.addElement(s);
        }

    }

    void useItem() {
        listmodel.removeAllElements();
        current = "Item";
        use.setVisible(true);
        label.setVisible(true);
        list.setVisible(true);
        usemagiclabel.setVisible(false);

        for (String s : player.items.keySet()) {
            listmodel.addElement(s);
        }
    }

    void Flee() {
        FleeForm f = new FleeForm(this);
        f.setVisible(true);
        System.out.println("Just set Flee form visible");
    }

    void returnFromFlee() {
        gameMode = "story";
        initScene(scenesMap.get(currenBatleScene.getRunDefeat()));
    }

    public void initScene(Scene scene) {
        if (scene == null)
            System.out.println(currenBatleScene.getVictory());
        if (scene == null)
            System.out.println(scenesMap.get(currenBatleScene.getVictory()));
        if (scene.getType() != null && scene.getType().equals("combat")) {
            model.addElement(scene.getDescription());
            overViewTA.setText(scene.getDescription());
            overViewTA.repaint();
            javax.swing.text.DefaultCaret caret = (DefaultCaret) overViewTA.getCaret();
            caret.setUpdatePolicy(javax.swing.text.DefaultCaret.ALWAYS_UPDATE);
            System.out.println("Textarea reset");
            gameMode = "fight";
            optionsmodel.clear();
            // System.out.println(scene);
            currenBatleScene = scene;

            // fix to reset character stats
            scene.clearCharacters();
            Element sceneElement = scene.getElement();
            List<Element> sceneChildren = sceneElement.getChildren();
            for (Element element : sceneChildren) {
                if (element.getName().equals("Enemy")) {
                    scene.getCharacters().add(this.buildCharacter(element));
                }
            }

            formWindowOpened(scene);
        } else {
            model.addElement(scene.getDescription());
            overViewTA.setText(scene.getDescription());
            overViewTA.repaint();
            javax.swing.text.DefaultCaret caret = (DefaultCaret) overViewTA.getCaret();
            caret.setUpdatePolicy(javax.swing.text.DefaultCaret.NEVER_UPDATE);

            System.out.println("Textarea reset");
            // txtpn.setCaretPosition(0);
            optionsmodel.clear();
            for (Choice choice : scene.getChoices())
                optionsmodel.addElement(choice);

        }
    }

    private Scene buildScene(Element sceneElement) {
        Scene scene = null;
        String id = sceneElement.getAttributeValue("id");
        String type = sceneElement.getAttributeValue("type");
        if (id != null && (type == null || (type != null && !type.equals("combat")))) {
            String sceneDescription = sceneElement.getChild("SceneDescription").getText();
            scene = new Scene(id, sceneDescription, type, sceneElement);
            List<Element> sceneChildren = sceneElement.getChildren();
            for (Element element : sceneChildren) {
                if (element.getName().equals("choice")) {
                    scene.getChoices().add(this.buildChoice(element));
                }
            }
        } else {
            String sceneDescription = sceneElement.getChild("SceneDescription").getText();
            scene = new Scene(id, sceneDescription, type, sceneElement);
            String sceneVictory = sceneElement.getChild("Victory").getText().trim();
            String sceneRunVictory = sceneElement.getChild("RunVictory").getText().trim();
            String sceneDefeat = sceneElement.getChild("Defeat").getText().trim();
            String sceneRunDefeat = sceneElement.getChild("RunDefeat").getText().trim();

            scene.setVictory(sceneVictory);
            scene.setRunVictory(sceneRunVictory);
            scene.setDefeat(sceneDefeat);
            scene.setRunDefeat(sceneRunDefeat);

            List<Element> sceneChildren = sceneElement.getChildren();
            for (Element element : sceneChildren) {
                if (element.getName().equals("Enemy")) {
                    scene.getCharacters().add(this.buildCharacter(element));
                }
            }
        }

        return scene;
    }

    private Choice buildChoice(Element choiceElement) {
        Choice choice = null;
        String id = choiceElement.getAttributeValue("no");
        if (null != id) {
            choice = new Choice();
            choice.setId(id);
            choice.setDescription(choiceElement.getChildText("choiceDescription"));
            choice.setOutSceneId(choiceElement.getChildText("outcome"));
        }
        return choice;
    }

    private Character buildCharacter(Element charElement) {
        Character npc = null;
        String id = charElement.getAttributeValue("id");
        if (id != null) {
            npc = new Character();
            npc.setId(Integer.parseInt(id));
            List<Element> propList = charElement.getChildren();
            for (Element el : propList) {
                if (el.getName().equals("con"))
                    npc.setCon(Integer.parseInt(el.getText()));
                if (el.getName().equals("str"))
                    npc.setStr(Integer.parseInt(el.getText()));
                if (el.getName().equals("intl"))
                    npc.setIntl(Integer.parseInt(el.getText()));
                if (el.getName().equals("fth"))
                    npc.setFth(Integer.parseInt(el.getText()));
                if (el.getName().equals("chr"))
                    npc.setChr(Integer.parseInt(el.getText()));
                if (el.getName().equals("dex"))
                    npc.setDex(Integer.parseInt(el.getText()));
                if (el.getName().equals("magic"))
                    npc.magic.put(el.getText(), Integer.parseInt(el.getAttributeValue("Dmg")));

            }

        }
        return npc;
    }

    private void formWindowOpened(Scene scene) {// GEN-FIRST:event_formWindowOpened

        usemagiclabel.setVisible(false);
        label.setVisible(false);
        list.setVisible(false);
        usemagiclist.setVisible(true);
        // use.setVisible(false);

        player = new Character();
        system = scene.getCharacters().get(0);
        ;

        optionslabel.setVisible(false);
        optionslist.setVisible(false);
        confirmbutton.setVisible(false);

        playermodel = new DefaultListModel();
        systemmodel = new DefaultListModel();

        listmodel = new DefaultListModel();

        playerlist.setModel(playermodel);
        enemylist.setModel(systemmodel);
        // overviewlist.setModel(model);
        optionslist.setModel(optionsmodel);
        list.setModel(listmodel);

        optionsmodel.addElement("Attack");
        optionsmodel.addElement("Use Magic");
        optionsmodel.addElement("Use Item");
        optionsmodel.addElement("Flee");

        setInitials(player, system);

        int pseed = player.roll(100) + player.getDex();
        int sseed = system.roll(100) + system.getDex();
        System.out.println(pseed);
        model.addElement("Player Rolling");
        overViewTA.setText(overViewTA.getText() + "\n" + "Player Rolling");
        overViewTA.repaint();
        int p = 0;
        try {

            pause();

            model.addElement("Players number is " + String.valueOf(pseed));
            overViewTA.setText(overViewTA.getText() + "\n" + "Players number is " + String.valueOf(pseed));
            overViewTA.repaint();

            model.addElement("System Rolling");
            overViewTA.setText(overViewTA.getText() + "\n" + "System Rolling");
            overViewTA.repaint();

            model.addElement("System number is " + String.valueOf(sseed));
            overViewTA.setText(overViewTA.getText() + "\n" + "System number is " + String.valueOf(sseed));
            overViewTA.repaint();

            if (pseed > sseed) {
                model.addElement("Players turn first");
                overViewTA.setText(overViewTA.getText() + "\n" + "Players turn first");
                overViewTA.repaint();
                p++;
            } else {
                model.addElement("System turn first");
                overViewTA.setText(overViewTA.getText() + "\n" + "System turn first");
                overViewTA.repaint();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TextAdventureGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (p == 1) {
            optionslabel.setVisible(true);
            optionslist.setVisible(true);
            confirmbutton.setVisible(true);
        } else {
            SystemTurn();
        }

    }// GEN-LAST:event_formWindowOpened

    void SystemTurn() {
        optionslabel.setVisible(true);
        optionslist.setVisible(true);
        confirmbutton.setVisible(true);
        if (system.getCon() > 0) {
            int r = system.roll(100);
            double flee = player.getChr() / (system.getCon() * 2);
            if (r < flee) {
                model.addElement("Enemy is Desperate");
                overViewTA.setText(overViewTA.getText() + "\n" + "Enemy is Desperate");
                overViewTA.repaint();
                int c = system.roll(3);
                if (c == 1) {
                    model.addElement("Enemy Flees");
                    overViewTA.setText(overViewTA.getText() + "\n" + "Enemy Flees");
                    overViewTA.repaint();
                    gameMode = "story";
                    playermodel.clear();
                    systemmodel.clear();
                    initScene(scenesMap.get(currenBatleScene.getRunVictory()));
                    // System.exit(1);
                } else if (c == 2) {
                    int temp = 0;
                    String magic = "";
                    int magicPower = 0;
                    for (String s : system.magic.keySet()) {
                        temp += system.magic.get(s);
                        magic = s;
                        magicPower = system.magic.get(s);
                    }
                    if (r < temp) {
                        model.addElement("System used Spell " + magic);
                        overViewTA.setText(overViewTA.getText() + "\n" + "System used Spell " + magic);
                        overViewTA.repaint();
                        system.setCon(system.getCon() - magicPower);
                    }
                } else {
                    String w = "";
                    int wh = 0;
                    for (String s : system.items.keySet()) {
                        w = s;
                        wh = system.items.get(s);
                    }
                    model.addElement("System switching weapon " + w);
                    overViewTA.setText(overViewTA.getText() + "\n" + "System switching weapon " + w);
                    overViewTA.repaint();
                    system.items.put(sweapon, shealth);
                    sweapon = w;
                    shealth = system.items.get(w);
                    system.items.remove(w);
                }
            } else {
                model.addElement("Enemy Attacks");
                overViewTA.setText(overViewTA.getText() + "\n" + "Enemy Attacks");
                overViewTA.repaint();
                system.setStr(system.getStr() + 5);
                system.setDex(system.getDex() + 5);
                system.setIntl(system.getIntl() + 5);
                system.setFth(system.getFth() + 5);
                system.setStr(system.getStr() - 4);
                shealth -= 10;

                player.setDex(player.getDex() - 4);
                player.setCon(player.getCon() - 20);

                model.addElement("Enemy has damaged Player");
                overViewTA.setText(overViewTA.getText() + "\n" + "Enemy has damaged Player");
                overViewTA.repaint();
                setModels();
            }

            if (player.getCon() <= 0) {
                model.addElement("Enemy Wins.");
                overViewTA.setText(overViewTA.getText() + "\n" + "Enemy Wins.");
                overViewTA.repaint();

                optionslabel.setVisible(false);
                optionslist.setVisible(false);
                confirmbutton.setVisible(false);
                gameMode = "story";
                playermodel.clear();
                systemmodel.clear();
                initScene(scenesMap.get(currenBatleScene.getDefeat()));
            }
        } else {
            model.addElement("Player Wins.");
            overViewTA.setText(overViewTA.getText() + "\n" + "Player Wins.");
            overViewTA.repaint();
            gameMode = "story";
            playermodel.clear();
            systemmodel.clear();
            initScene(scenesMap.get(currenBatleScene.getVictory()));
        }
    }

    private void useActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_useActionPerformed

        if (current.equals("Magic")) {
            int index = list.getSelectedIndex();
            String magic = listmodel.get(index).toString();
            model.addElement("Player used magic " + magic);
            overViewTA.setText(overViewTA.getText() + "\n" + "Player used magic " + magic);
            overViewTA.repaint();
            magicEffect = player.magic.get(magic);
            player.magic.remove(magic);
            usemagiclabel.setVisible(false);
            attack("Magic=" + magic);
            SystemTurn();
        } else {
            int index = list.getSelectedIndex();
            String item = listmodel.get(index).toString();
            model.addElement("Player Switched weapon to " + item);
            overViewTA.setText(overViewTA.getText() + "\n" + "Player Switched weapon to " + item);
            overViewTA.repaint();

            player.items.put(weapon, weaponHealth);
            weapon = item;
            weaponHealth = player.items.get(item);
            player.items.remove(item);
            label.setVisible(false);
        }

        list.setVisible(false);
        use.setVisible(false);

    }// GEN-LAST:event_useActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveActionPerformed

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Playerfile.txt"));

            if (gameMode == "story") {

                bw.write(String.valueOf(currenBatleScene.getId()));
            } else if (gameMode == "fight") {
                bw.write(String.valueOf(currenBatleScene.getId()));
                bw.newLine();
                bw.write(weapon);
                bw.newLine();
                bw.write(String.valueOf(weaponHealth));
                bw.newLine();
                bw.write(String.valueOf(player.getChr()));
                bw.newLine();
                bw.write(String.valueOf(player.getCon()));
                bw.newLine();
                bw.write(String.valueOf(player.getDex()));
                bw.newLine();
                bw.write(String.valueOf(player.getFth()));
                bw.newLine();
                bw.write(String.valueOf(player.getId()));
                bw.newLine();
                bw.write(String.valueOf(player.getIntl()));
                bw.newLine();
                bw.write(String.valueOf(player.getStr()));
                bw.newLine();
                bw.write("Items");
                for (String s : player.items.keySet()) {
                    bw.write("," + s + " " + player.items.get(s));
                }

                bw.newLine();
                bw.write("Magic");
                for (String s : player.magic.keySet()) {
                    bw.write("," + s + " " + player.magic.get(s));
                }

                bw.close();

                bw = new BufferedWriter(new FileWriter("Systemfile.txt"));

                bw.write(sweapon);
                bw.newLine();
                bw.write(String.valueOf(shealth));
                bw.newLine();
                bw.write(String.valueOf(system.getChr()));
                bw.newLine();
                bw.write(String.valueOf(system.getCon()));
                bw.newLine();
                bw.write(String.valueOf(system.getDex()));
                bw.newLine();
                bw.write(String.valueOf(system.getFth()));
                bw.newLine();
                bw.write(String.valueOf(system.getId()));
                bw.newLine();
                bw.write(String.valueOf(system.getIntl()));
                bw.newLine();
                bw.write(String.valueOf(system.getStr()));

                for (String s : system.items.keySet()) {
                    bw.newLine();
                    bw.write(s + " " + system.items.get(s));
                }

                for (String s : system.magic.keySet()) {
                    bw.newLine();
                    bw.write(s + " " + system.magic.get(s));
                }
                bw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(TextAdventureGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// GEN-LAST:event_saveActionPerformed

    void removeAllpreviousElements() {
        player.clearMaps();
        system.clearMaps();
    }

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loadActionPerformed

        // removeAllpreviousElements();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Playerfile.txt"));

            if (gameMode == "story") {
                currenBatleScene.setId(br.readLine());
                initScene(currenBatleScene);
            } else if (gameMode == "fight") {
                currenBatleScene.setId(br.readLine());
                initScene(currenBatleScene);
                weapon = br.readLine();
                weaponHealth = Integer.parseInt(br.readLine());
                player.setChr(Integer.parseInt(br.readLine()));
                player.setCon(Integer.parseInt(br.readLine()));
                player.setDex(Integer.parseInt(br.readLine()));
                player.setFth(Integer.parseInt(br.readLine()));
                player.setId(Integer.parseInt(br.readLine()));
                player.setIntl(Integer.parseInt(br.readLine()));
                player.setStr(Integer.parseInt(br.readLine()));

                String item = br.readLine();
                String magic = br.readLine();

                String[] items = item.split(",");
                String[] magics = magic.split(",");

                for (int i = 1; i < items.length; i++) {
                    String[] values = items[i].split(" ");
                    player.items.put(values[0], Integer.parseInt(values[1]));
                }

                for (int i = 1; i < magics.length; i++) {
                    String[] values = magics[i].split(" ");
                    player.magic.put(values[0], Integer.parseInt(values[1]));
                }
                br.close();

                br = new BufferedReader(new FileReader("Systemfile.txt"));

                sweapon = br.readLine();
                shealth = Integer.parseInt(br.readLine());
                system.setChr(Integer.parseInt(br.readLine()));
                system.setCon(Integer.parseInt(br.readLine()));
                system.setDex(Integer.parseInt(br.readLine()));
                system.setFth(Integer.parseInt(br.readLine()));
                system.setId(Integer.parseInt(br.readLine()));
                system.setIntl(Integer.parseInt(br.readLine()));
                system.setStr(Integer.parseInt(br.readLine()));

                item = br.readLine();
                magic = br.readLine();

                String[] items1 = item.split(",");
                String[] magics1 = magic.split(",");

                for (int i = 1; i < items1.length; i++) {
                    String[] values = items1[i].split(" ");
                    system.items.put(values[0], Integer.parseInt(values[0]));
                }

                for (int i = 1; i < magics1.length; i++) {
                    String[] values = magics1[i].split(" ");
                    system.magic.put(values[0], Integer.parseInt(values[0]));
                }
                br.close();
            }

            setModels();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextAdventureGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TextAdventureGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// GEN-LAST:event_loadActionPerformed

    // Scenes

    public Map<String, Scene> getScenesMap() {
        return scenesMap;
    }

    private void pause() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

            }
        });
    }

    void setInitials(Character you, Character enemy) {
        player.setId(1);
        player.setCon(100);
        player.setChr(50);
        player.setStr(20);
        player.setDex(50);
        player.setIntl(50);
        player.setFth(50);
        player.items.put("Sword", 100);
        player.items.put("Mace", 150);
        player.magic.put("FireBall", 45);
        player.magic.put("lightningBolt", 40);

        system = enemy;

        system.items.put("Axe", 100);
        system.items.put("Hammer", 150);

        setModels();
    }

    void setModels() {

        playermodel.removeAllElements();
        systemmodel.removeAllElements();

        playermodel.addElement("Weapon : " + weapon + ": " + weaponHealth);
        playermodel.addElement("Id : " + player.getId());
        // playermodel.addElement("HP : " + player.getHP());
        playermodel.addElement("Con : " + player.getCon());
        playermodel.addElement("Chr : " + player.getChr());
        playermodel.addElement("Str : " + player.getStr());
        playermodel.addElement("Dex : " + player.getDex());
        playermodel.addElement("Intl : " + player.getIntl());
        playermodel.addElement("Fth : " + player.getFth());

        systemmodel.addElement("Weapon : " + sweapon + ": " + shealth);
        systemmodel.addElement("Id : " + system.getId());
        // systemmodel.addElement("HP : " + system.getHP());
        systemmodel.addElement("Con : " + system.getCon());
        systemmodel.addElement("Chr : " + system.getChr());
        systemmodel.addElement("Str : " + system.getStr());
        systemmodel.addElement("Dex : " + system.getDex());
        systemmodel.addElement("Intl : " + system.getIntl());
        systemmodel.addElement("Fth : " + system.getFth());
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting
        // code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
         * html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextAdventureGUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextAdventureGUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextAdventureGUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextAdventureGUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TextAdventureGUI storyBoard = new TextAdventureGUI();
                try {
                    File inputFile = new File("1 Holding the Ice Fortress.txt");
                    SAXBuilder saxB = new SAXBuilder();
                    Document doc;
                    doc = saxB.build(inputFile);
                    Element storyElement = doc.getRootElement();
                    Scene firstScene = null;

                    List<Element> scenesList = storyElement.getChildren();
                    for (Element sceneElement : scenesList) {
                        Scene scene = storyBoard.buildScene(sceneElement);
                        storyBoard.getScenesMap().put(scene.getId(), scene);
                        // storyBoard.buildCharacter(sceneElement);
                        if (firstScene == null) {
                            firstScene = scene;
                        }
                        // if (scene.getType() == "combat") {

                        // }
                    }

                    storyBoard.initScene(firstScene);

                    storyBoard.setVisible(true);
                    // save.writeObject(firstScene);
                    // save.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(storyBoard.scenesMap);
                storyBoard.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton confirmbutton;
    private javax.swing.JList enemylist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel label;
    private javax.swing.JList list;
    private javax.swing.JButton load;
    private javax.swing.JLabel optionslabel;
    private javax.swing.JList optionslist;
    private javax.swing.JList playerlist;
    private javax.swing.JButton save;
    private javax.swing.JButton use;
    private javax.swing.JLabel usemagiclabel;
    private javax.swing.JList usemagiclist;
    private javax.swing.JTextArea overViewTA;
}