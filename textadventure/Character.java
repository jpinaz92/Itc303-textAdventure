package textadventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Character {
	private  int id;
	private String description;
	private int con;
	private int str;
	private int dex;
	private int intl;
	private int fth;
	private int chr;
        private int HP;
         HashMap<String, Integer> items;
         HashMap<String, Integer> magic;

    public Character() {
        items = new HashMap<String, Integer>();
        magic = new HashMap<String, Integer>();
    }
	
        
        
    public int hashCode() {
        int hash = 3;
        return hash;
    }
    
    private Random rand = new Random();
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCon() {
    	return con;
    }
    
	public void setCon(int con) {
		this.con = con;
	}
        
    public int getHP() {
        HP = con * 2;
        return HP;
    }
    
    public void setHP(int HP) {
        this.HP = HP;
    }
	
    public int getStr() {
    	return str;
    }
	
	public void setStr(int str) {
		this.str = str;
	}
	
    public int getDex() {
    	return dex;
    }
	
	public void setDex(int dex) {
		this.dex = dex;
	}
	
    public int getIntl() {
    	return intl;
    }
	
	public void setIntl(int intl) {
		this.intl = intl;
	}
	
    public int getFth() {
    	return fth;
    }
	
	public void setFth(int fth) {
		this.fth = fth;
	}
	
    public int getChr() {
    	return chr;
    }
	
	public void setChr(int chr) {
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
    
    public int roll(int seed)
    {
    	Random roll = new Random();
        return roll.nextInt(seed);
    }

    public void clearMaps()
    {
        for(String s: items.keySet())
        {
           items.remove(s);
        }
        for(String s: magic.keySet())
        {
           magic.remove(s);
        }
    }
    
}

