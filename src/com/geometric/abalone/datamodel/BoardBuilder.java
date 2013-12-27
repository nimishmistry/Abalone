/**
 * 
 */
package com.geometric.abalone.datamodel;

/**
 * @author nimishm
 * 
 */
public class BoardBuilder {
	/**
	 * 
	 * @return
	 */
	public static Board Build() {
		Board board = new Board();

		for (int hIndex = 1; hIndex <= 9; ++hIndex) {
			Bound iBound = BoardBounds.getBounds(hIndex);

			for (int iIndex = iBound.getLower(); iIndex <= iBound.getUpper(); ++iIndex) {
				board.addCell(new Cell(hIndex, iIndex));
			}
		}

		return board;
	}
}
