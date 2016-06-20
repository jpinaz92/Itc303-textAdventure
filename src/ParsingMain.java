import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.SAXBuilder;

public class ParsingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			
			File inputFile = new File("input");
			SAXBuilder saxB = new SAXBuilder();
		
			Document doc = saxB.build(inputFile);
	
			Element storyElement = doc.getRootElement();
			
			List<Element> scenesList = storyElement.getChildren();
			Element sceneElement = scenesList.get(1);
			
			System.out.println(sceneElement.getChildText("SceneDescription"));
			List<Element> choicesList = sceneElement.getChildren();
			
			String id = sceneElement.getChildText("SceneDescription");
			while(id != "end1")
			{
				for(int temp = 1; temp < choicesList.size(); temp++)
				{
					Element choice = choicesList.get(temp);
					System.out.println("\n" + temp + " : " + choice.getChildText("choiceDescription"));
				
				}
				System.out.println("\n"+ "Enter a number to choose:");
			
				Scanner in = new Scanner(System.in);
				int decision = in.nextInt();
			
				switch(decision){
					case 0:{
						break;
					}
					case 1:{
						Element option = choicesList.get(1);
						String outcome = option.getAttributeValue("outcome");
					
						Element newScene = storyElement.getChild(outcome);
						System.out.println(newScene.getChildText("SceneDescription"));
					
						List<Element> newChoices = newScene.getChildren();
					
						for(int temp = 1; temp < newChoices.size(); temp++)
						{
							Element choice = newChoices.get(temp);
							System.out.println("\n" + temp + " : " + choice.getChildText("choiceDescription"));
						
						}
						id = newScene.getChildText("SceneDescription");
						
						break;
						
					}
					case 2:{
						Element option = choicesList.get(2);
						String outcome = option.getAttributeValue("outcome");
					
						Element newScene = storyElement.getChild(outcome);
						System.out.println(newScene.getChildText("SceneDescription"));
					
						List<Element> newChoices = newScene.getChildren();
					
						for(int temp = 1; temp < newChoices.size(); temp++)
						{
							Element choice = newChoices.get(temp);
							System.out.println("\n" + temp + " : " + choice.getChildText("choiceDescription"));
						
						}
						id = newScene.getChildText("SceneDescription");
					
						break;
					}
					
				}
			}
			
			}catch(JDOMException e){
				e.printStackTrace();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}

		}

}