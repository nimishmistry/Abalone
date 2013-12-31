package com.geometric.abalone.algo;

import java.util.ArrayList;
import java.util.List;

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

		while (currentCell != null && currentCell.getState() != CellState.EMPTY) {
			cells.add(currentCell);
			currentCell = mBoard.getNextCell(currentCell, direction);
		}

		if (currentCell != null) {
			cells.add(currentCell);
		}

		for (int i = cells.size() - 1; i >= 1; --i) {
			cells.get(i).setState(cells.get(i - 1).getState());
		}

		cells.get(0).setState(CellState.EMPTY);
	}

	/**
	 * 
	 */
	public Boolean CanMove(Cell cell, Direction direction) {

		ArrayList<Cell> cells = new ArrayList<Cell>();

		Cell currentCell = cell;

		while (currentCell != null && currentCell.getState() != CellState.EMPTY) {
			cells.add(currentCell);
			currentCell = mBoard.getNextCell(currentCell, direction);
		}

		int size = cells.size();

		if (size > 5
				|| getStateCount(cells, cell.getState()) > 3
				|| (cells.get(size - 1).getState() == cell.getState() && mBoard
						.getNextCell(cells.get(size - 1), direction) == null)) {
			return false;
		}

		for (Cell o : cells.subList(0, 1 + (cells.size() / 2))) {
			if (o.getState() != cell.getState())
				return false;
		}

		return true;
	}

	/**
	 * 
	 * @param cells
	 * @param state
	 * @return
	 */
	private int getStateCount(List<Cell> cells, CellState state) {
		int count = 0;
		for (int i = 0; i < cells.size(); ++i) {
			if (cells.get(i).getState() == state) {
				++count;
			}
		}
		return count;
	}
}
