package application;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.Node;

public class GameBoard {

	private AnchorPane anchorPaneGameBoard;
	private int width = -1;
	private int height = -1;

	public GameBoard() {
		anchorPaneGameBoard = new AnchorPane();
	}

	public AnchorPane createGameBoard(int width, int height, int[][] array) {
		this.width = width;
		this.height = height;
		if (array == null)
			return null;

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				//
				// Create square to show.
				//

				int posX = x * 20;
				int posY = y * 20;

				RectangleWrapper rectangle;
				rectangle = new RectangleWrapper(posX, posY, 20, 20, x, y);

				rectangle.setFill(Color.TRANSPARENT);
				rectangle.setStroke(Color.BLACK);

				rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent t) {
						if (rectangle.getFill() == Color.TRANSPARENT) {
							rectangle.setFill(Color.GRAY);
							rectangle.setIsSelect(true);
						} else {
							rectangle.setFill(Color.TRANSPARENT);
							rectangle.setIsSelect(false);
						}
					}
				});

				anchorPaneGameBoard.getChildren().add(rectangle);

				String textValue;
				int value = array[x][y];
				if (value == -1)
					textValue = " ";
				else
					textValue = String.valueOf(value);

				Text text = new Text(posX + 5, posY + 15, textValue);

				text.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent t) {
						if (rectangle.getFill() == Color.TRANSPARENT) {
							rectangle.setFill(Color.GRAY);
							rectangle.setIsSelect(true);
						} else {
							rectangle.setFill(Color.TRANSPARENT);
							rectangle.setIsSelect(false);
						}
					}
				});
				anchorPaneGameBoard.getChildren().add(text);
			}
		}
		return anchorPaneGameBoard;
	}

	public int[][] getArrayOfSelectedSquares() {
		int[][] boardArray = new int[width][height];

		ObservableList<Node> obList = anchorPaneGameBoard.getChildren();

		for (Node node : obList) {
			if (node instanceof RectangleWrapper) {
				RectangleWrapper rectangle = (RectangleWrapper) node;
				int x = rectangle.getPosX();
				int y = rectangle.getPosY();

				Boolean isSelected = rectangle.getIsSelect();
				if (isSelected)
					boardArray[x][y] = 1;
				else
					boardArray[x][y] = 0;

			}
		}

		return boardArray;
	}

	AnchorPane getAnchorPaneGameBoard() {
		return anchorPaneGameBoard;
	}

}
