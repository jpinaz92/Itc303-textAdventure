import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Character {
	private  String id;
	private String description;
	private String con;
	private String str;
	private String dex;
	private String intl;
	private String fth;
	private String chr;
	
    public int hashCode() {
        int hash = 3;
        return hash;
    }
    
    private Random rand = new Random();
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getCon() {
    	return con;
    }
    
	public void setCon(String con) {
		this.con = con;
	}
	
    public String getStr() {
    	return str;
    }
	
	public void setStr(String str) {
		this.str = str;
	}
	
    public String getDex() {
    	return dex;
    }
	
	public void setDex(String dex) {
		this.dex = dex;
	}
	
    public String getIntl() {
    	return intl;
    }
	
	public void setIntl(String intl) {
		this.intl = intl;
	}
	
    public String getFth() {
    	return fth;
    }
	
	public void setFth(String fth) {
		this.fth = fth;
	}
	
    public String getChr() {
    	return chr;
    }
	
	public void setChr(String chr) {
		this.chr = chr;
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
        final Character other = (Character) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public void Stats(Character Enemy)
    {
    	int con = Integer.parseInt(Enemy.getCon());
    	int str = Integer.parseInt(Enemy.getStr());
    	int dex = Integer.parseInt(Enemy.getDex());
    	int intl = Integer.parseInt(Enemy.getIntl());
    	int fth = Integer.parseInt(Enemy.getFth());
    	int chr = Integer.parseInt(Enemy.getChr());
    	
    	int HP = con * 2;
    }




}
