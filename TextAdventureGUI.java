import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import javax.swing.event.ListSelectionListener;
import javax.swing.event.*;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

//import javax.swing.JTextArea;
import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
//import javax.swing.JScrollBar;

public class TextAdventureGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-20,79
	 */
	private final JPanel panel = new JPanel();
	private static JList list;
	JScrollPane scrollPane;
	ListSelectionModel listSelectionModel;
	private final JTextPane txtpn = new JTextPane();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JButton Button = new JButton("Confirm");
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JTextPane txtpn_1 = new JTextPane();
	private final JScrollPane scrollPane_3 = new JScrollPane();
	private final JList list_1 = new JList();
	private final JButton btnConfirm = new JButton("Confirm");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					File inputFile = new File("input");
					SAXBuilder saxB = new SAXBuilder();
				
					Document doc = saxB.build(inputFile);
			
					Element storyElement = doc.getRootElement();
					
					List<Element> scenesList = storyElement.getChildren();
					
					Element sceneElement = scenesList.get(1);
					List<Element> sceneChildren = sceneElement.getChildren();
					
					List<Element> choicesList = sceneChildren.subList(1, sceneChildren.size());
					
					
					TextAdventureGUI frame = new TextAdventureGUI(sceneElement, choicesList);
					frame.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public TextAdventureGUI(Element scene, List<Element> choices) {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(panel_1, "name_1020693468148476");
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.add(scrollPane_1);
		scrollPane_1.setViewportView(txtpn);
		txtpn.setEditable(false);
		txtpn.setText(scene.getChildText("SceneDescription")); 
		list = new JList(choices.toArray());
		scrollPane = new JScrollPane(list);
		panel_1.add(scrollPane);
		
		listSelectionModel = list.getSelectionModel();
		scrollPane.setViewportView(list);
		panel_1.add(Button);
		
		contentPane.add(panel_2, "name_1020795165001452");
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_2.add(scrollPane_2);
		
		scrollPane_2.setViewportView(txtpn_1);
		panel_2.add(scrollPane_3);
		
		scrollPane_3.setViewportView(list_1);
		
		panel_2.add(btnConfirm);
		
		Button.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Confirm"));
		{
			Element Selection = (Element) list.getSelectedValue();
		}
	}
}
