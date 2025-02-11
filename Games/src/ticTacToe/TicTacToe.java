package ticTacToe;

import java.util.Scanner;

public class TicTacToe {
	
	int num_row = 5;
	int num_col = 5;
	
	String[][] board = { 
			{"/", "|" , "/", "|" , "/"},
			{"-", "|" , "-", "|" , "-"},
			{"/", "|" , "/", "|" , "/"},
			{"-", "|" , "-", "|" , "-"},
			{"/", "|" , "/", "|" , "/"},
	};
	
	public void rules() {
		System.out.println("  Rules:");
		System.out.println("- It's like regular tic tac toe, get three in a row and win");
		System.out.println("- Once either someone gets three in a row, or all nine spots are"
				+ " taken, the game will out put the results");
		System.out.println("- the rows consist of 0, 2, 4, while columns consist of 0, 2, 4");
		System.out.println("- To choose where you want to place your mark, you will type the "
				+ "location cordinates, leave a space between the row and column");
		System.out.println("You can place you mark at any location that has a '/'");
		System.out.println("  Example:");
		System.out.println("  2, 2");
		System.out.println("- If you want to end the game early, just type in Q to quit the game");
		System.out.println("  Thank You for Playing :)");
	}
	
	public void printBoard() {
		System.out.printf("%6s%5s%5s%5s%5s", 0,1,2,3,4);
		System.out.println();
		for(int i = 0; i < num_row; i++) {
			System.out.print(i);
			for(int j = 0; j < num_col; j++) {
				System.out.printf("%5s", board[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean changeElements(boolean XorO,int row, int col) {
		boolean el = false;
		if(!el) {
			for(int i = 0; i < num_row; i++	) {
				for(int j = 0; j < num_col; j++) {
					if(XorO && row == i && col == j && board[i][j] != "X" && board[i][j] != "O") {
						board[i][j] = "O";
						el = true;
					} else if(!XorO && row == i && col == j && board[i][j] != "O" && board[i][j] != "X") {
						board[i][j] = "X";
						el = true;
					} else if(row == i && col == j) {
						printBoard();
						System.out.println("This spot is already taken, choose a different location");
					}
				}
			}
		}
		return el;
	}
	
	public boolean checkBoard(boolean XorO) {
		boolean endGame = false;	
		String sXorO = "O";
		
		if(XorO) {
			sXorO = "O";
		} else {
			sXorO = "X";
		}
		
		for(int i = 0; i < num_row; i++) {
			if(endGame) {
				break;
			}
			for(int j = 0; j < num_col; j++) {
				if(j < 1) {
					if(board[i][j] == sXorO && board[i][j + 2] == sXorO && board[i][j + 4] == sXorO && j < 1) {
						printBoard();
						System.out.println("Congratulations " + sXorO + " you won the game");
						endGame = true;
						break;
					} 
				}
				if(i < 1) {
					if(board[i][j] == sXorO && board[i + 2][j] == sXorO && board[i + 4][j] == sXorO) {
						printBoard();
						System.out.println("Congratulations " + sXorO + " you won the game");
						endGame = true;
						break;
					}
				}
				if(i < 1 && j < 1) {
					if(board[i][j] == sXorO && board[i + 2][j + 2] == sXorO && board[i + 4][j + 4] == sXorO) {
						printBoard();
						System.out.println("Congratulations " + sXorO + " you won the game");
						endGame = true;
						break;
					}
				}
				if(i == 4 && j < 1) {
					if(board[i][j] == sXorO && board[i - 2][j + 2] == sXorO && board[i - 4][j + 4] == sXorO) {
						printBoard();
						System.out.println("Congratulations " + sXorO + " you won the game");
						endGame = true;
						break;
					}
				}
				if(i < 1 && j == 4) {
					if(board[i][j] == sXorO && board[i + 2][j - 2] == sXorO && board[i + 4][j - 4] == sXorO) {
						printBoard();
						System.out.println("Congratulations " + sXorO + " you won the game");
						endGame = true;
						break;
					}
				}
				if(i == 4 && j == 4) {
					if(board[i][j] == sXorO && board[i - 2][j - 2] == sXorO && board[i - 4][j - 4] == sXorO) {
						printBoard();
						System.out.println("Congratulations " + sXorO + " you won the game");
						endGame = true;
						break;
					}
				}
			}
		}
		
		return endGame;
		}

	public void runner() {
		
		int row = -1;
		int col = -1;
		int counter = 0;
		boolean running = true;
		boolean XorO = true;
		
		Scanner myScanner = new Scanner(System.in);		
		
		rules();
		printBoard();
		
		while(running) {
			
			if(counter == 9) {
				System.out.println("The game ended in a tie");
				break;
			}
			
			if (myScanner.hasNextInt()) {
				row = myScanner.nextInt();
				if (myScanner.hasNextInt()) {
					col = myScanner.nextInt();
					if(col%2 == 0 && row%2 == 0 && row < 5 && col < 5) {
						if(changeElements(XorO, row, col)) {
							counter++;
							if(checkBoard(XorO)) {
								break;
							}
							printBoard();
							XorO = !XorO;
							if(XorO) {
								System.out.println("It's now O's turn");
							} else {
								System.out.println("It's now X's turn");
							}
						}
					} else {
						System.out.println("That location is not on the board, please try again.");
					}
				}
			} else {
				String userInput = myScanner.next();
				if (userInput.charAt(0) == 'Q' || userInput.charAt(0) == 'q') {
					myScanner.close();
					System.out.println("Good Bye");
					break;
				} 
			}	
		}
	}
	
	
	public static void main(String[] args) {
		TicTacToe start = new TicTacToe();
		start.runner();
	}

}
