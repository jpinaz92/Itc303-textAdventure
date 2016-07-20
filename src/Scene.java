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

    public Scene(String id, String description) {
        this.id = id;
        this.description = description;
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


}