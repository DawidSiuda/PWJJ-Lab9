package application;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Controler {
	@FXML
	private Pane mainPane;

	private final int sizeX = 15;
	private final int sizeY = 10;

	GameBoard gameBoard;
	private int[][] intGameBoard;

	public Controler() {
		System.out.println("FUNCTION: constructor");
	}

	/**
	 * Initialize FX controllers.
	 */
	public void initialize() {
		System.out.println("FUNCTION: initialize");

		//
		// Random game board.
		//

		Random rand = new Random();

		int[][] exampleSolution = new int[sizeX][sizeY];

		for(int i = 0; i< sizeX; i++) {
			for(int j = 0; j< sizeY; j++) {
				exampleSolution[i][j] = rand.nextInt(2);
			}
		}

		//
		// Print array.
		//
		//for(int y = 0; y< sizeY; y++) {
		//	for(int x = 0; x< sizeX; x++) {
		//		System.out.print(exampleSolution[x][y] + ", ");
		//	}
		//	System.out.print("\n");
		//}

		//
		// Calculate value of all fields.
		//

		intGameBoard = new int[sizeX][sizeY];

		for(int i = 0; i< sizeX; i++) {
			for(int j = 0; j< sizeY; j++) {
				if((i+j*j)%3 == 0) {
					int value = 0;

					for (int x = -1; x <= 1; x++){
						for (int y = -1; y <= 1; y++) {
							if(i == 0 && x == -1)
								continue;
							if(i == sizeX-1 && x == 1)
								continue;
							if(j == 0 && y == -1)
								continue;
							if(j == sizeY-1 && y == 1)
								continue;

							if (exampleSolution[i+x][j+y] == 1)
								value++;
						}
					}

					intGameBoard[i][j] = value;
				} else {
					intGameBoard[i][j] = -1;
				}
			}
		}


		//
		// Create array of fields.
		//

		gameBoard = new GameBoard();
		AnchorPane anchorPane = gameBoard.createGameBoard(sizeX, sizeY, intGameBoard);

		anchorPane.setLayoutX(60);
		anchorPane.setLayoutY(130);

		mainPane.getChildren().add(anchorPane);
	}

	public void buttonCheckSolutionClicked() {
		System.out.println("FUNCTION: buttonStartGameClicked()");

		int[][] arrayOfSelectedSquares = gameBoard.getArrayOfSelectedSquares();

		//
		// Print array.
		//
		//for(int y = 0; y< sizeY; y++) {
		//	for(int x = 0; x< sizeX; x++) {
		//		System.out.print(arrayOfSelectedSquares[x][y] + ", ");
		//	}
		//	System.out.print("\n");
		//}

		//
		// Count field in received array.
		//

		int[][] arrayOfReceivedSolution = new int[sizeX][sizeY];
		for(int i = 0; i< sizeX; i++) {
			for(int j = 0; j< sizeY; j++) {
				if((i+j*j)%3 == 0) {
					int value = 0;

					for (int x = -1; x <= 1; x++){
						for (int y = -1; y <= 1; y++) {
							if(i == 0 && x == -1)
								continue;
							if(i == sizeX-1 && x == 1)
								continue;
							if(j == 0 && y == -1)
								continue;
							if(j == sizeY-1 && y == 1)
								continue;

							if (arrayOfSelectedSquares[i+x][j+y] == 1)
								value++;
						}
					}

					arrayOfReceivedSolution[i][j] = value;
				}
			}
		}

		//
		// Print array.
		//
		//for(int y = 0; y< sizeY; y++) {
		//	for(int x = 0; x< sizeX; x++) {
		//		System.out.print(arrayOfReceivedSolution[x][y] + ", ");
		//	}
		//	System.out.print("\n");
		//}

		//
		// Compare received array with orginal array.
		//
		for(int y = 0; y< sizeY; y++) {
			for(int x = 0; x< sizeX; x++) {
				if(intGameBoard[x][y] != -1 && arrayOfReceivedSolution[x][y] != intGameBoard[x][y]) {
					MyMessage.show("Wrong soluton!!!");
					return;
				}
			}
			System.out.print("\n");
		}

		MyMessage.show("Victory!!!!");
	}
}