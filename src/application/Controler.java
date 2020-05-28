package application;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Controler {
	//
	// FX variables
	//

	public Button buttonStartGame;
	//public TilePane tilePaneGameBoard;
	public AnchorPane anchorPaneGameBoard;

	public Controler() {
		System.out.println("FUNCTION: constructor");
	}

	/**
	 * Initialize FX controllers.
	 */
	public void initialize() {
		System.out.println("FUNCTION: initialize");

		//
		// Draw sth.
		//

		Rectangle rectangle = new Rectangle(0, 0, 20,20);
		rectangle.setFill(Color.TRANSPARENT);
		rectangle.setStroke(Color.BLACK);

		rectangle.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
            	rectangle.setFill(Color.GREY);
            }
        });

		StackPane stack = new StackPane();
		stack.getChildren().addAll(rectangle, new Text("1"));

		stack.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
            	if (rectangle.getFill() == Color.TRANSPARENT)
            		rectangle.setFill(Color.GRAY);
            	else
            		rectangle.setFill(Color.TRANSPARENT);
            }
        });

		anchorPaneGameBoard.getChildren().add(stack);

	}

	public void buttonStartGameClicked() {
		System.out.println("FUNCTION: buttonStartGameClicked()");
		MyMessage.show("My message");
	}
}