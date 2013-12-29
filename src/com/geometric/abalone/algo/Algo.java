package com.geometric.abalone.algo;

import java.util.ArrayList;

import com.geometric.abalone.datamodel.Board;
import com.geometric.abalone.datamodel.Cell;
import com.geometric.abalone.datamodel.CellState;
import com.geometric.abalone.datamodel.Direction;

/**
 * 
 * @author nimishm
 * 
 */
public class Algo {
	/**
	 * Board
	 */
	private Board mBoard;

	/**
	 * 
	 * @param board
	 */
	public Algo(Board board) {
		mBoard = board;
	}

	/**
	 * 
	 * @param cell
	 * @param direction
	 */
	public void Move(Cell cell, Direction direction) {

		ArrayList<Cell> cells = new ArrayList<Cell>();

		Cell currentCell = cell;

		while (currentCell.getState() != CellState.EMPTY) {
			cells.add(currentCell);
			currentCell = mBoard.getNextCell(currentCell, direction);
		}

		cells.add(currentCell);

		for (int i = cells.size() - 1; i >= 1; --i) {
			cells.get(i).setState(cells.get(i - 1).getState());
		}

		cells.get(0).setState(CellState.EMPTY);
	}

	/**
	 * 
	 */
	public Boolean CanMove(Cell cell, Direction direction) {

		Boolean canMove = false;

		Cell adj1 = mBoard.getNextCell(cell, direction);

		// end of board
		if (adj1 == null) {
			return false;
		}

		if (adj1.getState() == CellState.EMPTY) {// adjacent cell is empty
			return true;
		} else if (adj1.getState() != cell.getState()) {// adjacent cell is
														// occupied by opponent
			return false;
		}

		// adjacent1 cell belongs to the same player
		Cell adj2 = mBoard.getNextCell(adj1, direction);

		// end of board
		if (adj2 == null) {
			return false;
		}

		if (adj2.getState() == CellState.EMPTY) {// adjacent cell is empty
			return true;
		}

		Cell adj3 = mBoard.getNextCell(adj2, direction);

		if (adj2.getState() != cell.getState()
				&& (adj3 == null || adj3.getState() == CellState.EMPTY)) {
			return true;
		}

		// adjacent 2 belongs to the same player
		if (adj3 == null) {
			return false;
		} else if (adj3.getState() == CellState.EMPTY) {
			return true;
		}

		Cell adj4 = mBoard.getNextCell(adj3, direction);

		if (adj4 == null || adj4.getState() == CellState.EMPTY
				|| adj4.getState() != cell.getState()) {
			return true;
		}

		return canMove;
	}
}
