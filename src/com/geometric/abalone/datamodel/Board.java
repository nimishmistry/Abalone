/**
 * 
 */
package com.geometric.abalone.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nimishm
 * 
 */
public class Board {
	private List<Cell> mCells;

	/**
	 * 
	 */
	public Board() {
		mCells = new ArrayList<Cell>();
	}

	/**
	 * 
	 * @param cell
	 */
	void addCell(Cell cell) {
		mCells.add(cell);
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
}
