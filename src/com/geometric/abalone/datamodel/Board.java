/**
 * 
 */
package com.geometric.abalone.datamodel;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

/**
 * @author nimishm
 * 
 */
public class Board {
	private List<Cell> mCells;
	private List<BoardChangedEventListener> mEvemtListeners;

	/**
	 * 
	 */
	public Board() {
		mCells = new ArrayList<Cell>();
		mEvemtListeners = new ArrayList<BoardChangedEventListener>();
	}

	/**
	 * 
	 * @param cell
	 */
	void addCell(Cell cell) {
		mCells.add(cell);
		cell.setOnChangedListener(new CellChangedEventListener() {

			@Override
			public void onCellChanged(EventObject e) {
				for (BoardChangedEventListener listener : mEvemtListeners) {
					listener.onBoardChanged(new EventObject(this));
				}
			}
		});
	}

	/**
	 * 
	 * @return
	 */
	public List<Cell> getCells() {
		return mCells;
	}

	/**
	 * 
	 * @param hIndex
	 * @param iIndex
	 * @return
	 */
	public Cell getCell(int hIndex, int iIndex) {
		for (Cell cell : mCells) {
			if (cell.getHIndex() == hIndex && cell.getIIndex() == iIndex) {
				return cell;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param cell
	 * @param direction
	 * @return
	 */
	public Cell getNextCell(Cell cell, Direction direction) {
		Cell adjCell = null;
		switch (direction) {
		case EAST:
			adjCell = getCell(cell.getHIndex(), cell.getIIndex() + 1);
			break;
		case NORTH_EAST:
			adjCell = getCell(cell.getHIndex() + 1, cell.getIIndex() + 1);
			break;
		case NORTH_WEST:
			adjCell = getCell(cell.getHIndex() + 1, cell.getIIndex());
			break;
		case SOUTH_EAST:
			adjCell = getCell(cell.getHIndex() - 1, cell.getIIndex());
			break;
		case SOUTH_WEST:
			adjCell = getCell(cell.getHIndex() - 1, cell.getIIndex() - 1);
			break;
		case WEST:
			adjCell = getCell(cell.getHIndex(), cell.getIIndex() - 1);
			break;
		default:
			break;
		}

		return adjCell;
	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	public Cell getCellAtNE(Cell cell) {
		return getCell(cell.getHIndex() + 1, cell.getIIndex() + 1);
	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	public Cell getCellAtE(Cell cell) {
		return getCell(cell.getHIndex(), cell.getIIndex() + 1);
	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	public Cell getCellAtSE(Cell cell) {
		return getCell(cell.getHIndex() - 1, cell.getIIndex());
	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	public Cell getCellAtSW(Cell cell) {
		return getCell(cell.getHIndex() - 1, cell.getIIndex() - 1);
	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	public Cell getCellAtW(Cell cell) {
		return getCell(cell.getHIndex(), cell.getIIndex() - 1);
	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	public Cell getCellAtNW(Cell cell) {
		return getCell(cell.getHIndex() + 1, cell.getIIndex());
	}

	/**
	 * 
	 * @param listener
	 */
	public void setOnChangedListener(BoardChangedEventListener listener) {
		mEvemtListeners.add(listener);
	}
}
