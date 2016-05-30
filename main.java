
import java.io.*;
import java.util.*;
public class main {
	
	public static int alarm(int T){
		Scanner in = new Scanner(System.in);
		System.out.println("The guards come running they seem irritated but not suprised at what you show them. They ask you to explain what happened:");
		System.out.println("1: Say that you just found her like this");
		System.out.println("2: Blame someone for the murder");
		int c = in.nextInt();
		
		
		switch (c){
		case 1: System.out.println("The guards aknowledge that she was probably killed during the night and they send you on your way.");
			T += 1;
			break;
		case 2: System.out.println("Chose a person to blame");
		//in the actual game this list will be made up of names of people the player has met;
		System.out.println("1: Mallok The Brutal");
		System.out.println("2: Malthus Van Bane");
		System.out.println("3: Lucian Varg");
		System.out.println("4: Victoria Luperia");
		int d = in.nextInt();
		//in the actual game I will put effort into making the dialogue sound more "Game of Thrones" and less "Law and Order" 
			switch (d){
			case 1: System.out.println("The guards advise that they will look into it and send you on your way");
				T -= 1;
				break;
			case 2: System.out.println("The guards look confused, they send you on your way, as you leave you hear one of them say 'Who the hell is Malthus Van Bane?'");
				T -= 5;
				break;
			case 3: System.out.println("The guards look concerned, they snd you on your way, as you leave you hear one of them say 'Lucian can't be back in town right?'");
				T += 1;
				break;
			case 4: System.out.println("The guards look concerned, they snd you on your way, as you leave you hear one of them say 'This does look like her handy work'");
				T += 5;
				break;
			}
		}
		return T;
	}
	
	public static int mutilate(int T){
		T -= 8;
		Scanner in = new Scanner(System.in);
		System.out.println("You mutilate the corpse beyond recognition destroying all the remaining items in her pockets");
		System.out.println("Now what would you like to do?");
		System.out.println("1: Call the city guards");
		System.out.println("2: Walk away");
		int c = in.nextInt();
		
		switch (c){
		case 1:	System.out.println("The guards come running they seem disgusted and surprised by what youshow them. They ask you to explain what happened:");
			System.out.println("1: Say that you just found her like this");
			System.out.println("2: Blame someone for the murder");
			int d = in.nextInt();
			
			switch (d){
			case 1: if(T <= -5){
				System.out.println("The guards don't belive you, you have been arrested.");
				GameOver();
				break;
			}
			else{
				System.out.println("The guards show you on your way and advise you tostay off the street at night");
			}
			case 2: System.out.println("Chose a person to blame");
			//in the actual game this list will be made up of names of people the player has met;
			System.out.println("1: Mallok The Brutal");
			System.out.println("2: Malthus Van Bane");
			System.out.println("3: Lucian Varg");
			System.out.println("4: Victoria Luperia");
			int e = in.nextInt();
			//in the actual game I will put effort into making the dialogue sound more "Game of Thrones" and less "Law and Order" 
				switch (e){
				case 1: System.out.println("The guards advise that they will look into it and send you on your way");
					T -= 4;
					break;
				case 2: System.out.println("The guards look confused, they send you on your way, as you leave you hear one of them say 'Who the hell is Malthus Van Bane?' to which the other replies 'I don't know but they're one sick son of a bitch!");
					T -= 8;
					break;
				case 3: System.out.println("The guards look concerned, they snd you on your way, as you leave you hear one of them say 'Do you really think Lucian would do this?'");
					T -= 1;
					break;
				case 4: System.out.println("The guards look concerned, they snd you on your way, as you leave you hear one of them say 'She's stepped up her game'");
					T += 2;
					break;
			}
			
		}
		break;
			
		case 2: T -= 2;
		break;
		}
		
		return T;
	}
	
	public static int loot(int T){
		System.out.println("You search her pockets and find a small book; it appears to be a client ledger");
		//in the actual game the client ledger would be added to an inventory and the options in this method would naturally present themselves later on; 
		System.out.println("What will you do with the client ledger?");
		System.out.println("1: Keep the ledger");
		System.out.println("2: Sell the ledger");
		System.out.println("3: give the ledger to the guards");
		System.out.println("4: destroy the ledger");
		
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		
		switch (c){
		case 1: System.out.println("You keep the ledger to use at your behest");
		break;
		
		case 2: System.out.println("You sell the ledger to an aspireing pimp for 20 gold");
		T -= 1;
		break;
		
		case 3:  System.out.println("You give the ledger to the guards");
		T += 1;
		break;
		
		case 4:  System.out.println("You destroy the ledger the secrets inside will never be known");
		T += 5;
		break;
		}
		return T;
	}
	
	public static int necrophelia(int T){
		T -= 10;
		System.out.println("You do unspeakable things to the womans corpse...");
		System.out.println("You have contracted a communicable disease, your max HP will now be halved until you are cured");
		System.out.println("and anyone you have sexual contact with will also contract the diease");
		System.out.println("What will you do now?");
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("1: Find healer");
		System.out.println("2: Intentionally infect another prostitute with the disease");
		
		int c = in.nextInt();
		
		switch(c){
		case 1: System.out.println("You find a healer he tells you that he can cure you for 10 gold");
		System.out.println("What will you do now?");
		
		System.out.println("1: pay the money be healed and reevaluate your life");
		System.out.println("2: demand he lower the price");
		System.out.println("3: seduce the healer in an attempt to give him the disease");
		int d = in.nextInt();
			
			switch(d){
			case 1: System.out.println("You pay the money and while he heals you you think long and hard on the choices you've made and how you got to where you are now.");
			T += 2;
			break;
			
			case 2: System.out.println("you demand that he lower the price, the healer is angered he attacks you with powerful magic");
			GameOver();
			break;
			
			case 3: System.out.println("you attempt to seduce the healer");
			if(T <= -10){
				System.out.println("The healer sees through your sceme and attacks you with powerful magic");
				GameOver();
				break;
			}
			else{
				System.out.println("you seduce the healer and infect him with the disease, this gives you a sinister sense of satisfaction");
				T -= 10;
				break;
			}
			}
			break;
		case 2: System.out.println("you hire a prostitute and infect her with the disease, this gives you a sinister sense of satisfaction");
		T -= 10;
		break;
		}
		return T;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tendancy = 0;
		Scanner in = new Scanner(System.in);
		System.out.println ("You have found the dead body of a prostitute in the street would you like to:");
		System.out.println("1: Call the city guards");
		System.out.println("2: Mutilate her corpse");
		System.out.println("3: Search her pockets for valuables");
		System.out.println("4: Necrophelia");
		System.out.println("5: Walk away");
		
		int c = in.nextInt();
		
		switch (c) {
		case 1: alarm(tendancy);
			break;
			
		case 2: mutilate(tendancy);
			break;
			
		case 3: loot(tendancy);
			break;
			
		case 4: necrophelia(tendancy);
			break;
		
		case 5: System.out.println("You walk away.");
			break;
		}
	}
	
	public static void GameOver(){
		System.out.println("GAME OVER");
	}

}
