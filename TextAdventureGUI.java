import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.SAXBuilder;

public class TextAdventureGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-20,79
	 */
	private final JPanel panel = new JPanel();

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
					List<Element> choicesList = sceneElement.getChildren();
					
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
	public TextAdventureGUI(Element scene, List<Element> choices) {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 0));
		
		//String buttonNames[] = {"choice1", "choice2", "choice3", "choice4", "choice5"};
		JButton[] cButtons = new JButton[18];
		
		for(int temp = 1; temp <= choices.size(); temp++)
		{
			Element choice = choices.get(temp);
			//String bName = buttonNames[temp];
			cButtons[temp] = new JButton(choice.getChildText("choiceDescription"));
			cButtons[temp].addActionListener(this);
			contentPane.add(cButtons[temp]);
			
		}
		
		JTextArea textArea = new JTextArea(scene.getChildText("sceneDescription"));
		textArea.setBounds(5, 11, 451, 104);
		contentPane.add(textArea);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
