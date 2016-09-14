package textadventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Scene {
   private  String id;
   private String description;
   private String type;
   private String victory;
   private String defeat;
   private String runVictory;
   private String runDefeat;
    List<Choice> choices = new ArrayList<Choice>();
    List<Character> characters = new ArrayList<Character>();
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Scene(String id, String description, String type) {
        this.id = id;
        this.description = description;
        this.type = type;
    }

    public List<Choice> getChoices() {
        return choices;
    }
    
    public List<Character> getCharacters() {
    	return characters;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    
    public String getType() {
    	return type;
    }
    public String toString(){
    	return description;
    }

	public String getVictory() {
		return victory;
	}

	public void setVictory(String victory) {
		this.victory = victory;
	}

	public String getDefeat() {
		return defeat;
	}

	public void setDefeat(String defeat) {
		this.defeat = defeat;
	}
        
        public String getRunVictory() {
            return runVictory;
        }
        
        public void setRunVictory(String runVictory) {
                this.runVictory = runVictory;
	}
        
        public String getRunDefeat() {
            return runDefeat;
	}
        
        public void setRunDefeat(String runDefeat) {
		this.runDefeat = runDefeat;
	}

}