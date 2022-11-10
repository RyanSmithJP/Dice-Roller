import java.util.Random;
import java.util.Scanner;
public class diceRoller {
	
	Random rd = new Random();
	Scanner scanner = new Scanner(System.in);
	private int sides;
	private int count;
	private String s;
	
	diceRoller(){
		info();
		this.sides = createDice();
		rollDice(rd, sides);
	}
	public void rollDice(Random rd, int n){
		try{
			System.out.println("Your d"+sides+" has rolled a "+rd.nextInt(1,sides+1)+". Continue?");
		}
		catch(Exception e) {
			System.out.println("You cannot have less than one side\nTo change your dice, input \"change\"");
		}
		if(count == 0) {
			count++;
			info();
		}
		s = scanner.nextLine();
		if(s.equalsIgnoreCase("y")||s.length()==0) {
			rollDice(rd, n);
		}
		else if(s.equalsIgnoreCase("change")) {
			System.out.println("Please enter the amount of sides of your NEW dice");
			sides = Integer.parseInt(scanner.nextLine());
			try{
				rollDice(rd, sides);
			}
			catch(Exception e){
				System.out.println("You cannot have less than one side.\n To change your dice, input \"change\"");
			}
		}
		else {
			System.out.println("Finished.");
		}
	}
	public int createDice() {
		System.out.println("Please enter the amount of sides of your dice");
		return Integer.parseInt(scanner.nextLine());
	}
	public void info(){
		switch(count) {
		case 0 : System.out.println("Welcome to the dice roller!\n"); break;
		case 1 : System.out.println("\n__________________________________________________\n\nIf you wish to roll again, input \"y\" or press ENTER.\nTo change dice and roll again, input \"change\"\n__________________________________________________");
		}
	}
}
