
package textadventure;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import java.io.*;
import java.util.*;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.DefaultListModel;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;
import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class TextAdventureGUI extends javax.swing.JFrame {
    
    
    private javax.swing.JButton confirmButton;
    private javax.swing.JList enemyList;
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
    private javax.swing.JLabel optionsLabel;
    private javax.swing.JList optionsList;
    private javax.swing.JList overviewList;
    private javax.swing.JList playerList;
    private javax.swing.JButton save;
    private javax.swing.JButton use;
    private javax.swing.JLabel useMagicLabel;
    private javax.swing.JList useMagicList;
    //private final JTextPane txtpn = new JTextPane();
    //private final JScrollPane scrollPane_1 = new JScrollPane();
    private Map<String, Scene> scenesMap = new HashMap<String, Scene>();
    

    DefaultListModel model;
    DefaultListModel playerModel;
    DefaultListModel enemyModel;
    DefaultListModel optionsModel;
    DefaultListModel listModel;
    Character player;
    Character enemy;

    String weapon = "default";
    int weaponHealth = 100;
    String sweapon = "default";
    int shealth = 100;
    String current = "";
    int magicEffect = 0;

    
        public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextAdventureGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextAdventureGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextAdventureGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextAdventureGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 try {
                    TextAdventureGUI storyBoard = new TextAdventureGUI();
                    //FileOutputStream out = new FileOutputStream("saveFile");
                    File inputFile = new File("Demo");
                    //ObjectOutputStream save = new ObjectOutputStream(out);
                    //InputStream inStream = new FileInputStream(inputFile);
                    //Reader reader = new InputStreamReader(inStream, "UTF-8");
                    //InputSource inSource = new InputSource(reader);
                    //inSource.setEncoding("UTF-8");

                    //SAXParser.parse(inSource, handler);
                    SAXBuilder saxB = new SAXBuilder();

                    Document doc = saxB.build(inputFile);
                 

                    Element storyElement = doc.getRootElement();
                    Scene firstScene = null;
                    List<Element> scenesList = storyElement.getChildren();
                    for (Element sceneElement : scenesList) {
                        Scene scene = storyBoard.buildScene(sceneElement);
                        storyBoard.getScenesMap().put(scene.getId(), scene);
                        //storyBoard.buildCharacter(sceneElement);
                        if (firstScene == null) {
                            firstScene = scene;
                        }
                       // if (scene.getType() == "combat") {
                        	
                        //}
                    }
                    storyBoard.initScene(firstScene);
                    storyBoard.setVisible(true);
                    //save.writeObject(firstScene);
                    //save.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        new TextAdventureGUI().setVisible(true);
    }

    public TextAdventureGUI() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        optionsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        optionsList = new javax.swing.JList();
        //jScrollPane2 = new javax.swing.JScrollPane();
        overviewList = new javax.swing.JList();
        confirmButton = new javax.swing.JButton();
        load = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        playerList = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        enemyList = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        label = new javax.swing.JLabel();
        useMagicLabel = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        useMagicList = new javax.swing.JList();
        use = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Player Progress");

        jLabel2.setText("Enemy Progress");

        jLabel3.setText("Overview");

        optionsLabel.setText("Player Options");

        jScrollPane1.setViewportView(optionsList);

        jScrollPane2.setViewportView(overviewList);

        confirmButton.setText("Confirm");
        
        
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
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

        jScrollPane3.setViewportView(playerList);

        jScrollPane4.setViewportView(enemyList);

        jScrollPane5.setViewportView(list);

        label.setText("Use Item");

        useMagicLabel.setText("UseMagic");

        jScrollPane6.setViewportView(useMagicList);

        use.setText("Use");
        use.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(optionsLabel))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(useMagicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(use)))
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(load)
                .addGap(95, 95, 95)
                .addComponent(save))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(confirmButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(optionsLabel))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(useMagicLabel)
                            .addComponent(label))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(use)))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(load)
                    .addComponent(save)))
        );

        pack();
    }

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {

        int option = optionsList.getSelectedIndex();
        if (option == 0) {
            System.out.println("Attack");
            model.addElement("Player Chooses to attack");
            Random n = new Random();
            int attack = n.nextInt(20);
            int intelligence = player.getIntl();
            int enemyDex = enemy.getDex();
            if ((attack + intelligence) > enemyDex) {
                model.addElement("Attack done successfully");
                model.addElement("Player has made a damage to Enemy");
                attack(weapon);
            }

            if (enemy.getCon() > 0) {
                SystemTurn();
            } else {
                model.addElement("Player Wins");
                optionsLabel.setVisible(false);
                optionsList.setVisible(false);
                confirmButton.setVisible(false);
            }
        } else if (option == 1) {
            System.out.println("Use Magic");
            model.addElement("Player Chooses to Use Magic");

            useMagic();
        } else if (option == 2) {
            System.out.println("Use Item");
            model.addElement("Player Chooses to Use Item");

            useItem();
        } else if (option == 3) {
            System.out.println("Flee");
            model.addElement("Player Chooses to Flee");

            Flee();
        }


    }

    void attack(String weapon) {

        if (weapon.equals("default")) {
            player.setStr(player.getStr() + 5);
            player.setDex(player.getDex() + 5);
            player.setIntl(player.getIntl() + 5);
            player.setFth(player.getFth() + 5);
            player.setStr(player.getStr() - 4);
            
            weaponHealth -=10;
            
            enemy.setDex(enemy.getDex() - 4);
            enemy.setHP(enemy.getHP() - 20);
        } else if (weapon.contains("Magic")) {
            enemy.setHP(enemy.getHP() - magicEffect);
        } 
        setModels();

    }

    void useMagic() {
        listModel.removeAllElements();
        current = "Item";
        use.setVisible(true);
        label.setVisible(false);
        list.setVisible(true);
        useMagicLabel.setVisible(true);
        current = "Magic";

        System.out.println(current);

        for (String s : player.magic.keySet()) {
            System.out.println(s);
            listModel.addElement(s);
        }

    }

    void useItem() {
        listModel.removeAllElements();
        current = "Item";
        use.setVisible(true);
        label.setVisible(true);
        list.setVisible(true);
        useMagicLabel.setVisible(false);

        for (String s : player.items.keySet()) {
            listModel.addElement(s);
        }
    }

    void Flee() {
        FleeForm f = new FleeForm();
        f.setVisible(true);
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        
        useMagicLabel.setVisible(false);
        label.setVisible(false);
        list.setVisible(false);
        useMagicList.setVisible(true);
        use.setVisible(false);

        player = new Character();
        enemy = new Character();

        optionsLabel.setVisible(false);
        optionsList.setVisible(false);
        confirmButton.setVisible(false);

        model = new DefaultListModel();
        playerModel = new DefaultListModel();
        enemyModel = new DefaultListModel();
        optionsModel = new DefaultListModel();
        listModel = new DefaultListModel();

        playerList.setModel(playerModel);
        enemyList.setModel(enemyModel);
        overviewList.setModel(model);
        optionsList.setModel(optionsModel);
        list.setModel(listModel);

        optionsModel.addElement("Attack");
        optionsModel.addElement("Use Magic");
        optionsModel.addElement("Use Item");
        optionsModel.addElement("Flee");

        setInitials();

        int pseed = player.roll(100) + player.getDex();
        int sseed = enemy.roll(100) + enemy.getDex();
        System.out.println(pseed);
        model.addElement("Players Rolling");
        int p = 0;
        try {

            pause();

            model.addElement("Players number is " + String.valueOf(pseed));

            model.addElement("System Rolling");

            model.addElement("System number is " + String.valueOf(sseed));

            if (pseed > sseed) {
                model.addElement("Players turn first");
                p++;
            } else {
                model.addElement("System turn first");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TextAdventureGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (p == 1) {
            optionsLabel.setVisible(true);
            optionsList.setVisible(true);
            confirmButton.setVisible(true);
        } else {
            SystemTurn();
        }


    }

    void SystemTurn() {
        optionsLabel.setVisible(true);
        optionsList.setVisible(true);
        confirmButton.setVisible(true);
        if (enemy.getCon() > 0) {
            int r = enemy.roll(100);
            double flee = player.getChr() / (enemy.getCon() * 2);
            if (r < flee) {
                model.addElement("Enemy choses to Flee");
                int c = enemy.roll(3);
                if (c == 1) {
                    System.exit(1);
                } else if (c == 2) {
                    int temp = 0;
                    String magic = "";
                    int magicPower = 0;
                    for (String s : enemy.magic.keySet()) {
                        temp += enemy.magic.get(s);
                        magic = s;
                        magicPower = enemy.magic.get(s);
                    }
                    if (r < temp) {
                        model.addElement("System used Spell " + magic);
                        enemy.setCon(enemy.getCon() - magicPower);
                    }
                } else {
                    String w = "";
                    int wh = 0;
                    for (String s : enemy.items.keySet()) {
                        w = s;
                        wh = enemy.items.get(s);
                    }
                    model.addElement("System switching weapon " + w);
                    enemy.items.put(sweapon, shealth);
                    sweapon = w;
                    shealth = enemy.items.get(w);
                    enemy.items.remove(w);
                }
            } else {
                model.addElement("Enemy Attacks");
                enemy.setStr(enemy.getStr() + 5);
                enemy.setDex(enemy.getDex() + 5);
                enemy.setIntl(enemy.getIntl() + 5);
                enemy.setFth(enemy.getFth() + 5);
                enemy.setStr(enemy.getStr() - 4);
                shealth -= 10;
                
                player.setDex(player.getDex() - 4);
                player.setCon(player.getCon() - 20);

                model.addElement("Enemy has made a damage to Player");
                setModels();
            }

            if (player.getCon() <= 0) {
                model.addElement("Enemy Wins.");
                optionsLabel.setVisible(false);
                optionsList.setVisible(false);
                confirmButton.setVisible(false);
            }
        } else {
            model.addElement("Player Wins.");
        }
    }

    private void useActionPerformed(java.awt.event.ActionEvent evt) {

        if (current.equals("Magic")) {
            int index = list.getSelectedIndex();
            String magic = listModel.get(index).toString();
            model.addElement("Player used magic " + magic);
            magicEffect = player.magic.get(magic);
            player.magic.remove(magic);
            useMagicLabel.setVisible(false);
            attack("Magic=" + magic);
            SystemTurn();
        } else {
            int index = list.getSelectedIndex();
            String item = listModel.get(index).toString();
            model.addElement("Player Switched weapon to " + item);

            player.items.put(weapon, weaponHealth);
            weapon = item;
            weaponHealth = player.items.get(item);
            player.items.remove(item);
            label.setVisible(false);
        }

        list.setVisible(false);
        use.setVisible(false);
        
    }//GEN-LAST:event_useActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Playerfile.txt"));
            
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
            for(String s:player.items.keySet())
            {
                 bw.write(","+s+" "+ player.items.get(s));
            }
            
            bw.newLine();
            bw.write("Magic");
            for(String s:player.magic.keySet())
            {
                bw.write(","+s+" "+ player.magic.get(s));
            }
            bw.close();
            
            
            bw = new BufferedWriter(new FileWriter("Systemfile.txt"));
            
            bw.write(sweapon);
            bw.newLine();
            bw.write(String.valueOf(shealth));
            bw.newLine();
            bw.write(String.valueOf(enemy.getChr()));
            bw.newLine();
            bw.write(String.valueOf(enemy.getCon()));
            bw.newLine();
            bw.write(String.valueOf(enemy.getDex()));
            bw.newLine();
            bw.write(String.valueOf(enemy.getFth()));
            bw.newLine();
            bw.write(String.valueOf(enemy.getId()));
            bw.newLine();
            bw.write(String.valueOf(enemy.getIntl()));
            bw.newLine();
            bw.write(String.valueOf(enemy.getStr()));
            
            for(String s:enemy.items.keySet())
            {
                bw.newLine();
                bw.write(s+" "+ enemy.items.get(s));
            }
            
            for(String s:enemy.magic.keySet())
            {
                bw.newLine();
                bw.write(s+" "+ enemy.magic.get(s));
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(TextAdventureGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    void removeAllpreviousElements()
    {
        player.clearMaps();
        enemy.clearMaps();
    }
    
    
    private void loadActionPerformed(java.awt.event.ActionEvent evt) {


        try {
            BufferedReader br = new BufferedReader(new FileReader("input"));
            
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
            
            
            for(int i=1; i<items.length; i++)
            {
                String[] values = items[i].split(" ");
                player.items.put(values[0], Integer.parseInt(values[1]));
            }
            
            for(int i=1; i<magics.length; i++)
            {
                String[] values = magics[i].split(" ");
                player.magic.put(values[0], Integer.parseInt(values[1]));
            }
            br.close();
            
            br = new BufferedReader(new FileReader("Systemfile.txt"));
            
            sweapon = br.readLine();
            shealth = Integer.parseInt(br.readLine());
            enemy.setChr(Integer.parseInt(br.readLine()));
            enemy.setCon(Integer.parseInt(br.readLine()));
            enemy.setDex(Integer.parseInt(br.readLine()));
            enemy.setFth(Integer.parseInt(br.readLine()));
            enemy.setId(Integer.parseInt(br.readLine()));
            enemy.setIntl(Integer.parseInt(br.readLine()));
            enemy.setStr(Integer.parseInt(br.readLine()));
        
            item = br.readLine();
            magic = br.readLine();
            
            String[] items1 = item.split(",");
            String[] magics1 = magic.split(",");
            
            
            for(int i=1; i<items1.length; i++)
            {
                String[] values = items1[i].split(" ");
                enemy.items.put(values[0], Integer.parseInt(values[0]));
            }
            
            for(int i=1; i<magics1.length; i++)
            {
                String[] values = magics1[i].split(" ");
                enemy.magic.put(values[0], Integer.parseInt(values[0]));
            }
            br.close();
            
            setModels();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextAdventureGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TextAdventureGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void pause() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

            }
        });
    }

    void setInitials() {
        player.setId(1);
        player.setCon(100);
        player.setChr(50);
        player.setStr(20);
        player.setDex(50);
        player.setIntl(50);
        player.setFth(50);
        player.items.put("Sword", 100);
        player.items.put("Mace", 100);
        player.magic.put("Fire Ball", 35);
        player.magic.put("Lightning Bolt", 40);

        enemy.setId(2);
        enemy.setCon(100);
        enemy.setChr(50);
        enemy.setStr(20);
        enemy.setDex(50);
        enemy.setIntl(50);
        enemy.setFth(50);
        enemy.items.put("Axe", 100);
        enemy.items.put("Bow", 100);
        enemy.magic.put("Poison Mist", 35);
        enemy.magic.put("Lightning Bolt", 40);

        setModels();
    }

    void setModels() {

        playerModel.removeAllElements();
        enemyModel.removeAllElements();

        playerModel.addElement("Weapon : " + weapon + ": " + weaponHealth);
        //playerModel.addElement("Id : " + player.getId());
        playerModel.addElement("HP : " + player.getHP());
       // playerModel.addElement("Chr : " + player.getChr());
        //playerModel.addElement("Str : " + player.getStr());
        //playerModel.addElement("Dex : " + player.getDex());
        //playerModel.addElement("Intl : " + player.getIntl());
        //playerModel.addElement("Fth : " + player.getFth());

        enemyModel.addElement("Weapon : " + sweapon + ": " + shealth);
        enemyModel.addElement("Id : " + enemy.getId());
        enemyModel.addElement("HP : " + enemy.getHP());
        //enemyModel.addElement("Chr : " + enemy.getChr());
        //enemyModel.addElement("Str : " + enemy.getStr());
        //enemyModel.addElement("Dex : " + enemy.getDex());
        //enemyModel.addElement("Intl : " + enemy.getIntl());
        //enemyModel.addElement("Fth : " + enemy.getFth());
    }

    /**
     * @param args the command line arguments
     */

    
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
        
    public Map<String, Scene> getScenesMap() {
        return scenesMap;
    }
    
        
private Scene buildScene(Element sceneElement) {
        Scene scene = null;
        String id = sceneElement.getAttributeValue("id");
        String type = sceneElement.getAttributeValue("type");
        if (id != null && type != "combat") {
            String sceneDescription = sceneElement.getChild("SceneDescription").getText();
            scene = new Scene(id, sceneDescription, type);
            List<Element> sceneChildren = sceneElement.getChildren();
            for (Element element : sceneChildren) {
                if (element.getName().equals("choice")) {
                    scene.getChoices().add(this.buildChoice(element));
                }
            }
        }
        
        return scene;
    }

    public void initScene(Scene scene) {
        //txtpn.setText(scene.getDescription());
        //txtpn.setCaretPosition(0);
        model.addElement(scene.getDescription());
        model.clear();
        for (Choice choice : scene.getChoices()) {
            optionsModel.addElement(choice);
        }
    }



}
