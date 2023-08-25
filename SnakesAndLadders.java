package new1;

import java.util.Random;

public class SnakesAndLadders {
	
	public static void main(String[] args) {
		String[][]stringBoard=finalBoard();
		System.out.println("End");
		printTwoD(stringBoard);
		System.out.println("Start");
		printBlank();
		int firstPlayer = determineFirst();
		int playerOne=1;
		int playerTwo=1;
		int diceOne;
		int diceTwo;
		int[][]integerBoard = intBoard();
		
		System.out.println("Both player 1 (*) and player 2 (**) start at square 1!");
		System.out.println();
		String[][]newBoard=updateBoard(stringBoard, playerOne, playerTwo, integerBoard);
		printTwoD(newBoard);
		printBlank();
		if (firstPlayer==1) {
			System.out.println("Player 1 goes first!");
			do {
				diceOne = diceGeneratorSix();
				playerOne = playerPosition(playerOne, diceOne, integerBoard, stringBoard);
				stringBoard=finalBoard();
				newBoard=updateBoard(stringBoard, playerOne, playerTwo, integerBoard);
				printTwoD(newBoard);
				if (playerOne>=100) {
					System.out.println("Player 1: Dice Roll-" + diceOne + "\t Player 1 WINS");
				}//if
				
				else {
					System.out.println("Player 1: Dice Roll-" + diceOne  + "\t New Position: " + playerOne);
					printBlank();
					diceTwo = diceGeneratorSix();
					playerTwo = playerPosition(playerTwo, diceTwo, integerBoard, stringBoard);
					stringBoard=finalBoard();
					newBoard=updateBoard(stringBoard, playerOne, playerTwo, integerBoard);
					printTwoD(newBoard);
					if (playerTwo>=100 && playerOne<100) {
						System.out.println("Player 2: Dice Roll-" + diceTwo + "\t Player 2 WINS");
					}//if
					else {
						System.out.println("Player 2: Dice Roll-" + diceTwo  + "\t New Position: " + playerTwo);
					}//else
				}//else
				printBlank();
			}//do
			while (playerOne<100 && playerTwo<100);
		}//if
		else if (firstPlayer==2){
			System.out.println("Player 2 goes first!");
			do {
				diceTwo = diceGeneratorSix();
				playerTwo = playerPosition(playerTwo, diceTwo, integerBoard, stringBoard);
				stringBoard=finalBoard();
				newBoard=updateBoard(stringBoard, playerOne, playerTwo, integerBoard);
				printTwoD(newBoard);
				if (playerTwo>=100) {
					System.out.println("Player 2: Dice Roll-" + diceTwo + "\t Player 2 WINS");
				}//if
				else {
					System.out.println("Player 2: Dice Roll-" + diceTwo  + "\t New Position: " + playerTwo);
					printBlank();
					diceOne = diceGeneratorSix();
					playerOne = playerPosition(playerOne, diceOne, integerBoard, stringBoard);
					stringBoard=finalBoard();
					newBoard=updateBoard(stringBoard, playerOne, playerTwo, integerBoard);
					printTwoD(newBoard);
					if (playerOne>=100 && playerTwo<100) {
						System.out.println("Player 1: Dice Roll-" + diceOne + "\t Player 1 WINS");
					}//if
					else {
						System.out.println("Player 1: Dice Roll-" + diceOne  + "\t New Position: " + playerOne);
					}//else
				}//else
				printBlank();
			}//do
			while (playerTwo<100 && playerOne<100);
		}//else
	
	}//main
	
	public static int[][]intBoard(){
		int[][]boardArray = new int[10][10];
		int count=100;
		for (int row=0; row<boardArray.length; row++) {
			if(row!=0) {
				count-=10;
			}//if
			for (int col=0; col<boardArray[row].length; col++) {
				if(row%2==0) {
					boardArray[row][col]=count;
					if (col!=9) {
						count--;
					}//if
				}//if
				else{
					boardArray[row][col]=count;
					if (col!=9) {
						count++;
					}//if
				}//else
			}//for col
		}//for row
		return boardArray;
	}//createBoard
	
	public static String[][]createBoard(){
		String[][]boardArray = new String[10][10];
		int count=100;
		for (int row=0; row<boardArray.length; row++) {
			if(row!=0) {
				count-=10;
			}//if
			for (int col=0; col<boardArray[row].length; col++) {
				if(row%2==0) {
					boardArray[row][col]=String.valueOf(count);
					if (col!=9) {
						count--;
					}//if
				}//if
				else{
					boardArray[row][col]=String.valueOf(count);
					if (col!=9) {
						count++;
					}//if
				}//else
			}//for col
		}//for row
		return boardArray;
	}//createBoard
	
	public static String[][]finalBoard(){
		String [][]board1 = createBoard();
		String [][]board2 = addChute(board1, 98, 78);
		String [][]board3 = addChute(board2, 95, 75);
		String [][]board4 = addChute(board3, 93, 73);
		String [][]board5 = addChute(board4, 87, 24);
		String [][]board6 = addChute(board5, 64, 60);
		String [][]board7 = addChute(board6, 62, 19);
		String [][]board8 = addChute(board7, 54, 34);
		String [][]board9 = addChute(board8, 17, 7);
		String [][]board10 = addLadder(board9, 2, 38);
		String [][]board11 = addLadder(board10, 4, 14);
		String [][]board12 = addLadder(board11, 9, 31);
		String [][]board13 = addLadder(board12, 21, 42);
		String [][]board14 = addLadder(board13, 28, 84);
		String [][]board15 = addLadder(board14, 51, 67);
		String [][]board16 = addLadder(board15, 71, 91);
		String [][]board17 = addLadder(board16, 80, 100);
		return board17;
	}
	
	public static String[][]addChute(String[][]twoD, int start, int end){
		for (int row = 0;row< twoD.length; row++){
			for (int col = 0;col<twoD[row].length; col++){
				if(twoD[row][col].compareTo(String.valueOf(start))==0){
					twoD[row][col]= ("S:" + end);
				}//if
			}//for col
		}//for row
		return twoD;
	}//addChute
	
	public static String[][]addLadder(String[][]twoD, int start, int end){
		for (int row = 0;row< twoD.length; row++){
			for (int col = 0;col<twoD[row].length; col++){
				if(twoD[row][col].compareTo(String.valueOf(start))==0){
					twoD[row][col]= ("L:" + end);
				}//if
			}//for col
		}//for row
		return twoD;
	}//addLadder
	
	public static String[][]updateBoard(String[][]twoD, int player1, int player2, int[][]intD){
		for (int row = 0;row< intD.length; row++){
			for (int col = 0;col<intD[row].length; col++){
				if (intD[row][col]==player1) {
					twoD[row][col]=twoD[row][col]+" *";
				}//if
				if (intD[row][col]==player2) {
					twoD[row][col]=twoD[row][col]+" **";
				}//if
			}//for col
		}//for row
		return twoD;
	}//updateBoard
	
	public static int determineFirst( ){
		int player1;
		int player2;
		do {
		player1 = diceGenerator();
		player2 = diceGenerator();
		}//do
		while (player1==player2);
		if (player1>player2) {
			return 1;
		}//if
		else {
			return 2;
		}//else
	}//determineFirst
	
	public static int playerPosition(int currentPosition, int diceRoll, int[][]twoD, String[][]board) {
		//This method gets the current position, the dice roll and the boards and returns the new position by calling another method
		int boardRow=0;//initialize boardRow
		int boardCol=0;//initialize boardCol
		int newPosition = currentPosition+diceRoll;//add diceRoll to currentPosition
		for (int row = 0;row< twoD.length; row++){
			for (int col = 0;col<twoD[row].length; col++){
				//find indices of newPosition in a 2D array to proceed with the move
				if (twoD[row][col]==newPosition) {
					boardRow=row;
					boardCol=col;
				}//if
			}//for col
		}//for row
		
		return coordinateMove(boardRow, boardCol, board, newPosition, currentPosition);	
		
	}//playerPosition
	
	public static int coordinateMove(int boardRow, int boardCol, String[][]board, int newPosition, int currentPosition) {
		//Return or call other methods according to the move type
		if (newPosition<=100) {
			//Return new position if its a regular move
			if (board[boardRow][boardCol].equals(Integer.toString(newPosition))){
				return newPosition;
			}//if
			//Call chuteLadder method in case there is a ladder
			else if (board[boardRow][boardCol].startsWith("L")){
				return chuteLadderUpdate(boardRow, boardCol, board);
			}//else if
			//Call chuteLadder method in case there is a chute
			else if (board[boardRow][boardCol].startsWith("S")){
				return chuteLadderUpdate(boardRow, boardCol, board);
			}//else if
		}//if
		//Return current position if new position>100
		return currentPosition;
	}//coordinateMove

	public static int chuteLadderUpdate(int row, int col, String[][]board){
		//Gets the indices of the board where the ladder is situated and returns the updated position
		int newPosition;
		String position = board[row][col].substring(2);//read string from 2D array
		newPosition = Integer.parseInt(position);//convert to int
		return newPosition;
	}//chuteLadderUpdate

	
	public static int diceGenerator() {
		Random rdObj = new Random();
		int diceRoll = rdObj.nextInt(6)+1;
		return diceRoll;
	}//diceGenerator
	
	public static int diceGeneratorSix() {
		int diceRoll = diceGenerator();
		int newDice;
		if (diceRoll==6) {
			do {
				newDice=diceGenerator();
				diceRoll+=newDice;
			}//do
			while(newDice==6);
		}//if
		return diceRoll;
	}//diceGeneratorSix
	
	public static void printBlank() {
		for (int count=0; count<50; count++) {
			System.out.println();
		}//for
	}//printBlank
	
	public static void printTwoD(String[][]twoD){
		//Prints the elements of a two dimensional array in the form of a table with rows and columns
		for (int row = 0;row< twoD.length; row++){
			System.out.println();
			for (int col = 0;col<twoD[row].length; col++){
				System.out.print(twoD[row][col] +"\t\t");
			}//for col
			System.out.println();
			System.out.println();

		} //for row
		}//printTwoD

}//SnakesAndLadders