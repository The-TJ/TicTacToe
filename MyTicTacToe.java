/*Author - Tanmay Joshi
Program that plays TicTacToe*/

public class Tictac {
	public static boolean con1=true;
	public static boolean con2=true;
	public static boolean con3=true;
	public static boolean con4=true;
	public static char winner=' ';
	public static int checker=1;
	public static int checker2=1;
	public static int checker3=0;
	public static int checkX=0;
	public static boolean con5=true;
	public static boolean con6=true;
	public static boolean con7=true;
	public static boolean con8=true;
    public static void main(String[] args) throws IOException
	{
		Tictac obj = new Tictac ();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
		System.out.println("Hello! Welcome to the TicTacToe program \nIf you want to play, Enter 'y', else Enter 'n'");
		char a = (char)br.read();
		br.readLine();
		char[] board=new  char[9];  //An array of length 9 to store the X's and O's
		if(a=='n')
		{
			System.out.println("Okay, Thanks for coming here :)");
			System.exit(0);
		}
		else
		{
			boolean check=true;
			int c,d=0,po;
			char comp= ' ';
			System.out.println("Great!! Please Enter you name");
			String name = br.readLine();
			System.out.println("Greetings"+" "+name);
			System.out.println("Great!! We will start now");
			System.out.println("What would you like to play as, 'X' or 'O'? If you pick 'X' you go first, otherwise the computer goes first");
			char b = (char)br.read();
			br.readLine();
			b= Character.toUpperCase(b);
			System.out.println("This is how the game board looks like now, Starting from the top, the first place for an 'X' or 'O' is called 1 while the last place is 9");
			obj.printboard (board);
			if(b=='X')       //If the user decides to go first
			{
				checkX=0;
				while(d<5)
				{
				   comp='O';
				   System.out.println("Enter the position where you want to put your 'X'");
				   c= Integer.parseInt(br.readLine());
				   c=c-1;
				   checkX++;
				   if(board[c]!=0)     //Condition to break the loop in case the positin of the board is already occupied
				   {
					   System.out.println("Oooops, looks like that place in the board is already taken, try again please");
					   break;
				   }
				   d++;
				   if(d>=5)
					   break;
				   board[c]='X';
				   po = obj.has_Anyone_Won(board);           //Function to check if anyone has won yet
				   if(po!=9)
				   {
					   if(winner=='O')
					   {
						   System.out.println("\n");
						 obj.printboard(board);              
					     System.out.println("\nTough Luck, the computer has won\nBetter Luck Next Time\n\n");
						 break;
					   }
					   else
					   {
						   System.out.println("\n");
						   obj.printboard(board);
						   System.out.println("\nYayyy!! Looks like you win, great job\n\n");
						   break;
					   }
				   }
				   obj.computers_Chance_X(board,comp);     //Pass the board to a function that is the AI that makes the move
				   po = obj.has_Anyone_Won(board);
				   if(po!=9)
				   {
					   if(winner=='O')
					   {
						   System.out.println("\n");
						 obj.printboard(board);
					     System.out.println("\nTough Luck, the computer has won\nBetter Luck Next Time\n\n");
						 break;
					   }
					   else
					   {
						   System.out.println("\n");
						   obj.printboard(board);
						   System.out.println("\nYayyy!! Looks like you win, great job\n\n");
						   break;
					   }
				   }
				   
				}
				if(d==5)
				{
					System.out.println("\nWell Played, Looks Like it's a draw\n");
				}					
			}
			else if(b=='O')            //If the user decides to go first
			{
				    checker=1;
					checker2=1;
					checker3=0;
				while(d<4)
				{
				    comp='X';
				    if(d==0)
					{
						board[0]= comp;
						obj.printboard(board);
						d++;
						System.out.println("Enter the position where you want to put your 'O'");
				        c= Integer.parseInt(br.readLine());
					    c=c-1;
					    board[c]='O';
						obj.computers_Chance(board,comp);
						checker++;
					}
					else
					{	
					d++;
					checker2++;
					System.out.println("Enter the position where you want to put your 'O'");
				    c= Integer.parseInt(br.readLine());
					c=c-1;
					if(board[c]!=0)
				   {
					   System.out.println("Oooops, looks like that place in the board is already taken, try again please");
					   break;
				   }
					board[c]='O';
					po = obj.has_Anyone_Won(board);
					if(po!=9)
				   {
					   if(winner=='X')
					   {
						 obj.printboard(board);
					     System.out.println("Tough Luck, the computer has won\nBetter Luck Next Time");
						 break;
					   }
					   else
					   {
						   obj.printboard(board);
						   System.out.println("Yayyy!! Looks like you win, great job");
						   break;
					   }
				   }
				    obj.printboard(board);
				    obj.computers_Chance(board,comp);
					po = obj.has_Anyone_Won(board);
					if(po!=9)
				   {
					   if(winner=='X')
					   {
					     System.out.println("\nTough Luck, the computer has won\nBetter Luck Next Time\n\n");
						 break;
					   }
					   else
					   {
						   obj.printboard(board);
						   System.out.println("\nYayyy!! Looks like you win, great job\n\n");
						   break;
					   }
				   }
				}
				if(d==4)
				{
					obj.computers_Chance(board,comp);
					System.out.println("\nWell Played, Looks Like it's a draw\n");
				}
				}
			}
				
		}
	}
	} 
	//Function that prints the board whenever it's called
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
	//This is the AI that makes the move of Computer when the computer plays as 'X'
	public void computers_Chance(char game2[], char comp)
	{
		int e;
		char player=' ';
		if(comp=='X')
			player='O';
		e=is_Winning(game2, comp);
		System.out.println("\n");
		if((checker2==2) && (game2[4]==0))           //Function that checks if a move could be made that'd make a two way win situation 
		{
			checker3++;
			if((game2[3]==player) && ((game2[1]==player) || (game2[2]==player)))
			{
				game2[8]=comp;
				printboard(game2);
			}
			else if((game2[3]==player) && (game2[7]==player))
			{
				game2[2]=comp;
				printboard(game2);
			}
			else if((game2[1]==player) && ((game2[3]==player) || (game2[6]==player)))
			{
				game2[8]=comp;
				printboard(game2);
			}
			else if((game2[1]==player) && ((game2[5]==player) || (game2[8]==player)))
			{
				game2[6]=comp;
				printboard(game2);
			}
		}
	    else if((checker==1) && (game2[4]==(char)0))              //Condition to see if after the first move, the centre is occupied or not
		{
			checker3++;
			if((game2[1]==player) || (game2[2]==player) || (game2[7]==player))
			{
				game2[6]=comp;
				printboard(game2);
			}
			else if((game2[3]==player) || (game2[5]==player) || (game2[6]==player) || (game2[8]==player))
			{
				game2[2]=comp;
				printboard(game2);
			}
		}
		else if(checker3==2)              //condition to check if the computer can win in the next move
		{
			char[] dupli=new  char[9];
			for(int lo=0; lo<=8;lo++)
			{
				dupli=game2.clone();
				dupli[lo]=comp;
				if((dupli[0]==dupli[1]) && (dupli[1]==dupli[2]) &&(game2[lo]==0))
			{
				game2[lo]=comp;
				printboard(game2);
			}
			else if((dupli[3]==dupli[4]) && (dupli[4]==dupli[5]) &&(game2[lo]==0))
			{
				game2[lo]=comp;
				printboard(game2);
			}
			else if((dupli[6]==dupli[7]) && (dupli[7]==dupli[8]) &&(game2[lo]==0))
			{
				game2[lo]=comp;
				printboard(game2);
			}
			else if((dupli[0]==dupli[3]) && (dupli[3]==dupli[6]) &&(game2[lo]==0))
			{
				game2[lo]=comp;
				printboard(game2);
			}
			else if((dupli[1]==dupli[4]) && (dupli[4]==dupli[7]) &&(game2[lo]==0))
			{
				game2[lo]=comp;
				printboard(game2);
			}
			else if((dupli[2]==dupli[5]) && (dupli[5]==dupli[8]) &&(game2[lo]==0))
			{
				game2[lo]=comp;
				printboard(game2);		}
			else if((dupli[0]==dupli[4]) && (dupli[4]==dupli[8]) &&(game2[lo]==0))
			{
				game2[lo]=comp;
				printboard(game2);
			}
			else if((dupli[2]==dupli[4]) && (dupli[4]==dupli[6]) &&(game2[lo]==0))
			{
			    game2[lo]=comp;
				printboard(game2);
			}
			}
		}
				
	    else if(game2[4]!='X' && game2[4]!='O')
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
			{
				game2[0]=comp;
				printboard(game2);
			}
			else if(game2[2]==(char)0)
			{
				game2[2]=comp;
				printboard(game2);
			}
			else if(game2[6]==(char)0)
			{
				game2[6]=comp;
				printboard(game2);
			}
			else if(game2[8]==(char)0)
			{
				game2[8]=comp;
				printboard(game2);
			}
			else if(game2[1]==(char)0)
			{
				game2[1]=comp;
				printboard(game2);
			}
			else if(game2[3]==(char)0)
			{
				game2[3]=comp;
				printboard(game2);
			}
			else if(game2[5]==(char)0)
			{
				game2[5]=comp;
				printboard(game2);
			}
			else
			{
				game2[7]=comp;
			    printboard(game2);
			}
	    }
		else
			printboard(game2);
	}
	public int is_Winning(char game3[], char d)        //Condition to check if the user can win in the next move, and if he can win, the computer returns the position where it should place its move to block the user from winning
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
	public int has_Anyone_Won(char game4[])         //Function to check if anyone has won yet
	{
		int num2=9;
		int k;
		char[] copy2=new  char[9];
		for(k=0;k<=8;k++)
		{
			copy2=game4.clone();
			if((copy2[0]==copy2[1]) && (copy2[1]==copy2[2]) && (copy2[0]!=0) )
			{
				if(copy2[0]=='X')
					winner = 'X';
				else
					winner = 'O';
				return k;
			}
			else if((copy2[3]==copy2[4]) && (copy2[4]==copy2[5]) && (copy2[3]!=0))
			{
				if(copy2[3]=='X')
				{
					winner = 'X';
				}
				else
					winner = 'O';
				return k;
			}
			else if((copy2[6]==copy2[7]) && (copy2[7]==copy2[8]) && (copy2[6]!=0))
			{
				if(copy2[6]=='X')
					winner = 'X';
				else
					winner = 'O';
				return k;
			}
			else if((copy2[0]==copy2[3]) && (copy2[3]==copy2[6]) && (copy2[0]!=0))
			{
				if(copy2[0]=='X')
					winner = 'X';
				else
					winner = 'O';
				return k;
			}
			else if((copy2[1]==copy2[4]) && (copy2[4]==copy2[7]) && (copy2[1]!=0))
			{
				if(copy2[1]=='X')
					winner = 'X';
				else
					winner = 'O';
				return k;
			}
			else if((copy2[2]==copy2[5]) && (copy2[5]==copy2[8]) && (copy2[2]!=0))
			{
				if(copy2[2]=='X')
					winner = 'X';
				else
					winner = 'O';
				return k;
			}
			else if((copy2[0]==copy2[4]) && (copy2[4]==copy2[8]) && (copy2[0]!=0))
			{
				if(copy2[0]=='X')
					winner = 'X';
				else
					winner = 'O';
				return k;
			}
			else if((copy2[2]==copy2[4]) && (copy2[4]==copy2[6]) && (copy2[2]!=0))
			{
				if(copy2[2]=='X')
					winner = 'X';
				else
					winner = 'O';
				return k;
			}
		}	
		return num2;
	}
	
	public void computers_Chance_X(char game5[], char compp)        //AI that makes the computer's move when the computer plays as 'O'
	{
		int rt;
		rt=is_Winning(game5, compp);
		if((checkX==2) && (game5[4]=='O'))
		{
			if((game5[0]==game5[8]) && (game5[8]=='X'))
			{
				game5[3]=compp;
				printboard(game5);
				return;
			}
			else if((game5[2]==game5[6]) && (game5[6]=='X'))
			{
				game5[3]=compp;
				printboard(game5);
				return;
			}
		}
	    else if(game5[4]!='X' && game5[4]!='O')
		{
		    game5[4]= compp;
			printboard(game5);
			return;
		}
	    else if (rt!=9)
	    {
		    game5[rt]= compp;
			printboard(game5);
	    }
	    else if(rt==9)
	    {
			if(game5[0]==(char)0)
				game5[0]=compp;
			else if(game5[2]==(char)0)
				game5[2]=compp;
			else if(game5[6]==(char)0)
				game5[6]=compp;
			else if(game5[8]==(char)0)
				game5[8]=compp;
			else if(game5[1]==(char)0)
				game5[1]=compp;
			else if(game5[3]==(char)0)
				game5[3]=compp;
			else if(game5[5]==(char)0)
				game5[5]=compp;
			else
				game5[7]=compp;
			printboard(game5);
	    }
		else
			printboard(game5);
	}
}

	
			
