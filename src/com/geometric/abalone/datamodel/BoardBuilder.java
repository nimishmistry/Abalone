/**
 * 
 */
package com.geometric.abalone.datamodel;

/**
 * @author nimishm
 * 
 */
public class BoardBuilder {

	private static Board sBoard;

	/**
	 * 
	 * @return
	 */
	public static Board Build() {
		sBoard = new Board();

		for (int hIndex = 1; hIndex <= 9; ++hIndex) {
			Bound iBound = BoardBounds.getBounds(hIndex);

			for (int iIndex = iBound.getLower(); iIndex <= iBound.getUpper(); ++iIndex) {
				sBoard.addCell(new Cell(hIndex, iIndex));
			}
		}

		LoadGame();

		return sBoard;
	}

	private static void LoadGame() {
		// player 1
		sBoard.getCell(1, 1).setState(CellState.PLAYER1);
		sBoard.getCell(1, 2).setState(CellState.PLAYER1);
		sBoard.getCell(1, 3).setState(CellState.PLAYER1);
		sBoard.getCell(1, 4).setState(CellState.PLAYER1);
		sBoard.getCell(1, 5).setState(CellState.PLAYER1);
		sBoard.getCell(2, 2).setState(CellState.PLAYER1);
		sBoard.getCell(2, 3).setState(CellState.PLAYER1);
		sBoard.getCell(2, 4).setState(CellState.PLAYER1);
		sBoard.getCell(2, 5).setState(CellState.PLAYER1);
		sBoard.getCell(3, 3).setState(CellState.PLAYER1);
		sBoard.getCell(3, 4).setState(CellState.PLAYER1);
		sBoard.getCell(3, 5).setState(CellState.PLAYER1);
		sBoard.getCell(4, 4).setState(CellState.PLAYER1);
		sBoard.getCell(4, 5).setState(CellState.PLAYER1);

		// player 2
		sBoard.getCell(9, 5).setState(CellState.PLAYER2);
		sBoard.getCell(9, 6).setState(CellState.PLAYER2);
		sBoard.getCell(9, 7).setState(CellState.PLAYER2);
		sBoard.getCell(9, 8).setState(CellState.PLAYER2);
		sBoard.getCell(9, 9).setState(CellState.PLAYER2);
		sBoard.getCell(8, 5).setState(CellState.PLAYER2);
		sBoard.getCell(8, 6).setState(CellState.PLAYER2);
		sBoard.getCell(8, 7).setState(CellState.PLAYER2);
		sBoard.getCell(8, 8).setState(CellState.PLAYER2);
		sBoard.getCell(7, 5).setState(CellState.PLAYER2);
		sBoard.getCell(7, 6).setState(CellState.PLAYER2);
		sBoard.getCell(7, 7).setState(CellState.PLAYER2);
		sBoard.getCell(6, 5).setState(CellState.PLAYER2);
		sBoard.getCell(6, 6).setState(CellState.PLAYER2);
	}
}
