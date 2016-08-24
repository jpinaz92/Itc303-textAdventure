
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.io.*;
import java.util.*;
import javax.swing.DefaultListModel;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import com.sun.org.apache.xerces.internal.parsers.SAXParser;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class TextAdventureGUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    /**
     * @wbp.nonvisual location=-20,79
     */
    private final JPanel panel = new JPanel();
    private static JList list;
    JScrollPane scrollPane;
    private final JTextPane txtpn = new JTextPane();
    private final JScrollPane scrollPane_1 = new JScrollPane();
    private final JButton Button = new JButton("Confirm");
    private final DefaultListModel<Choice> model = new DefaultListModel<Choice>();

    private Map<String, Scene> scenesMap = new HashMap<String, Scene>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TextAdventureGUI storyBoard = new TextAdventureGUI();
                    FileOutputStream out = new FileOutputStream("saveFile");
                    File inputFile = new File("Demo");
                    ObjectOutputStream save = new ObjectOutputStream(out);
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
                        if (scene.getType() == "combat") {
                        	storyBoard.fight(scene);
                        }
                    }
                    storyBoard.initScene(firstScene);
                    storyBoard.setVisible(true);
                    save.writeObject(firstScene);
                    save.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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
        
        if (id != null && type == "combat") {
        	 String sceneDescription = sceneElement.getChild("SceneDescription").getText();
             scene = new Scene(id, sceneDescription, type);
             List<Element> sceneChildren = sceneElement.getChildren();
             for (Element element : sceneChildren) {
                 if (element.getName().equals("enemy")) {
                     scene.getCharacters().add(this.buildCharacter(element));
                 }
             }
        }
        return scene;
    }
    
    private void fight(Scene scene) {
    	Character enemy = buildCharacter(null);
    	int con = Integer.parseInt(enemy.getCon());
    	int str = Integer.parseInt(enemy.getStr());
    	int dex = Integer.parseInt(enemy.getDex());
    	int intl = Integer.parseInt(enemy.getIntl());
    	int fth = Integer.parseInt(enemy.getFth());
    	int chr = Integer.parseInt(enemy.getChr());
    	
    	//hard coded player stats emulating warrior class used until character creator scenes are completely written		
    	//<Str> 15 </Str>
		//<Con> 10 </Con>
		//<Dex> 8 </Dex>
		//<Int> 4 </Int>
		//<Fth> 4 </Fth>
		//<Chr> 6 </Chr>
    	int pcon = 10;
    	int pstr = 15;
    	int pdex = 8;
    	int pintl = 4;
    	int pfth = 4;
    	int pchr = 6;
    	
    	
    	
    	int HP = con * 2;
    	int PHP = pcon * 2;
    	
    	int initiative = dex + enemy.roll(20);
    	int pinitiative = pdex + enemy.roll(20);
    	
    	while (HP > 0 ^ PHP > 0)
    	{
    		if (pinitiative <= initiative)
    		{
    			
    		}
    		else
    		{
    			
    		}
    	}
    }
    
    private Character buildCharacter(Element charElement) {
    	Character npc = null;
    	String id = charElement.getAttributeValue("id"); 
    	if (id != null)
    	{
    		npc = new Character();
    		npc.setId(id);
    		npc.setCon(charElement.getAttributeValue("con"));
    		npc.setStr(charElement.getAttributeValue("str"));
    		npc.setDex(charElement.getAttributeValue("dex"));
    		npc.setIntl(charElement.getAttributeValue("intl"));
    		npc.setFth(charElement.getAttributeValue("fth"));
    		npc.setChr(charElement.getAttributeValue("chr"));
    		//npc.Stats(npc);

    	}
    	return npc;
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

    public TextAdventureGUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 482, 311);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(5, 0));
        //String[] array = null; 
        list = new JList();
        list.setModel(model);
        scrollPane = new JScrollPane(list);

        contentPane.add(scrollPane_1);
        scrollPane_1.setViewportView(txtpn);

        txtpn.setEditable(false);
        //txtpn.setCaretPosition(0);
        Button.addActionListener(this);
        contentPane.add(scrollPane);
        scrollPane.setViewportView(list);
        contentPane.add(Button);
        scrollPane_1.getVerticalScrollBar().setValue(0);
        //scrollPane.getViewport().setViewPosition(new Point(0, 0));;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Confirm"));
        {
            Choice choice = (Choice) list.getSelectedValue();
            Scene outCome = scenesMap.get(choice.getOutSceneId());
            if (outCome != null) {
                initScene(outCome);
            }
        }
    }
    
    public void load(Scene scene) {
    	FileInputStream in = new FileInputStream("saveFile");
    	ObjectInputStream load = new ObjectInputStream(in);
    	scene = (Scene)load.readObject();
    }

    
    public Map<String, Scene> getScenesMap() {
        return scenesMap;
    }

    public void initScene(Scene scene) {
        txtpn.setText(scene.getDescription());
        txtpn.setCaretPosition(0);
        model.clear();
        for (Choice choice : scene.getChoices()) {
            model.addElement(choice);
        }
    }

}


