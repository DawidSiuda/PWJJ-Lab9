package application;

import javafx.scene.shape.Rectangle;

public class RectangleWrapper extends Rectangle {
	private int posOnBoardX;
	private int posOnBoardY;
	private Boolean isSelected = false;

	public void setPosX(int posX) {
		this.posOnBoardX = posX;
	}

	public void setPosY(int posY) {
		this.posOnBoardY = posY;
	}

	public int getPosX() {
		return posOnBoardX;
	}

	public int getPosY() {
		return posOnBoardY;
	}

	public RectangleWrapper(int posX, int posY, int width, int height, int posOnBoardX, int posOnBoardY) {
		super(posX, posY, width, height);
		this.posOnBoardX = posOnBoardX;
		this.posOnBoardY = posOnBoardY;
	}

	public void setIsSelect(Boolean value) {
		isSelected = value;
	}

	public Boolean getIsSelect() {
		return isSelected;
	}
}
