import java.io.*;
import java.util.Random;
public class MyTicTacToe {
	public static boolean con1=true;
	public static boolean con2=true;
	public static boolean con3=true;
	public static boolean con4=true;
	public static boolean con5=true;
	public static boolean con6=true;
	public static boolean con7=true;
	public static boolean con8=true;
    public static void main(String[] args) throws IOException
	{
		MyTicTacToe obj = new MyTicTacToe ();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
		System.out.println("Hello! Welcome to the TicTacToe program \nIf you want to play, Enter 'y', else Enter 'n'");
		char a = (char)br.read();
		br.readLine();
		char[] board=new  char[9];
		if(a=='n')
		{
			System.out.println("Okay, Thanks for coming here :)");
			System.exit(0);
		}
		else
		{
			boolean check=true;
			int c,d=0;
			char comp;
			System.out.println("Great!! Please Enter you name");
			String name = br.readLine();
			System.out.println("Greetings"+" "+name);
			System.out.println("Great!! We will stat now");
			System.out.println("What would you like to play as, 'X' or 'O'? If you pick 'X' you go first, otherwise the computer goes first");
			char b = (char)br.read();
			br.readLine();
			b= Character.toUpperCase(b);
			System.out.println("This is how the game board looks like now, Starting from the top, the first place for an 'X' or 'O' is called 0 while the last place is 8");
			obj.printboard (board);
			if(b=='X')
			{
				while(d<5)
				{
					
				   comp='O';
				   System.out.println("Enter the position where you want to put your 'X'");
				   c= Integer.parseInt(br.readLine());
				   if(board[c]!=0)
				   {
					   System.out.println("Oooops, looks like that place in the board is already taken, try again please");
					   break;
				   }
				   d++;
				   board[c]='X';
				   obj.computers_Chance(board,comp);
				   
				}
				if(d==5)
				{
					System.out.println("\nWell Played, Looks Like it's a draw\n");
				}					
			}
			else if(b=='O')
			{
				while(d<4)
				{
				    comp='X';
					d++;
				    obj.computers_Chance(board,comp);
				    System.out.println("Enter the position where you want to put your 'O'");
				    c= Integer.parseInt(br.readLine());
					board[c]='O';
				}
				if(d==4)
				{
					System.out.println("\nWell Played, Looks Like it's a draw\n");
				}
			}
				
		}
	}
	}
	public void printboard(char game[])
	{
		System.out.println("  "+'|'+"   "+'|');
		System.out.println(" "+game[0]+'|'+" "+game[1]+" "+'|'+" "+game[2]);
		System.out.println("  "+'|'+"   "+'|');
		System.out.println("---------");
		System.out.println("  "+'|'+"   "+'|');
		System.out.println(" "+game[3]+'|'+" "+game[4]+" "+'|'+" "+game[5]);
		System.out.println("  "+'|'+"   "+'|');
	    System.out.println("---------");
		System.out.println("  "+'|'+"   "+'|');
		System.out.println(" "+game[6]+'|'+" "+game[7]+" "+'|'+" "+game[8]);
		System.out.println("  "+'|'+"   "+'|');
	}
	public void computers_Chance(char game2[], char comp)
	{
		int e;
		e=is_Winning(game2, comp);
		System.out.println("\n");
	    if(game2[4]!='X' && game2[4]!='O')
		{
		    game2[4]= comp;
			printboard(game2);
			return;
		}
	    else if (e!=9)
	    {
		    game2[e]= comp;
			printboard(game2);
	    }
	    else if(e==9)
	    {
			if(game2[0]==(char)0)
				game2[0]=comp;
			else if(game2[2]==(char)0)
				game2[2]=comp;
			else if(game2[6]==(char)0)
				game2[6]=comp;
			else if(game2[8]==(char)0)
				game2[8]=comp;
			else if(game2[1]==(char)0)
				game2[1]=comp;
			else if(game2[3]==(char)0)
				game2[3]=comp;
			else if(game2[5]==(char)0)
				game2[5]=comp;
			else
				game2[7]=comp;
			printboard(game2);
	    }
		else
			printboard(game2);
	}
	public int is_Winning(char game3[], char d)
	{
		int num=9;
		int j;
		char[] copy=new  char[9];
		if(d=='X')
			d='O';
		else
			d='X';
		for(j=0;j<=8;j++)
		{
			copy=game3.clone();
			copy[j]=d;
			if((copy[0]==copy[1]) && (copy[1]==copy[2]) && (copy[0]!=0) &&(con1==true) &&(game3[j]==0))
			{
				con1=false;
				return j;
			}
			else if((copy[3]==copy[4]) && (copy[4]==copy[5]) && (copy[3]!=0) &&(con2==true) &&(game3[j]==0))
			{
				con2=false;
				return j;
			}
			else if((copy[6]==copy[7]) && (copy[7]==copy[8]) && (copy[6]!=0) &&(con3==true) &&(game3[j]==0))
			{
				con3=false;
				return j;
			}
			else if((copy[0]==copy[3]) && (copy[3]==copy[6]) && (copy[0]!=0) &&(con4==true) &&(game3[j]==0))
			{
				con4=false;
				return j;
			}
			else if((copy[1]==copy[4]) && (copy[4]==copy[7]) && (copy[1]!=0) &&(con5==true) &&(game3[j]==0))
			{
				con5=false;
				return j;
			}
			else if((copy[2]==copy[5]) && (copy[5]==copy[8]) && (copy[2]!=0) &&(con6==true) &&(game3[j]==0))
			{
				con6=false;
				return j;			}
			else if((copy[0]==copy[4]) && (copy[4]==copy[8]) && (copy[0]!=0) &&(con7==true) &&(game3[j]==0))
			{
				con7=false;
				return j;
			}
			else if((copy[2]==copy[4]) && (copy[4]==copy[6]) && (copy[2]!=0) &&(con8==true) &&(game3[j]==0))
			{
				con8=false;
				return j;
			}
		}	
		return num;
	}
	
}

	
			