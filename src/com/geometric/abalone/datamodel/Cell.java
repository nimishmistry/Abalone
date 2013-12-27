package com.geometric.abalone.datamodel;

/**
 * 
 * @author nimishm
 * 
 */
public class Cell {
	private CellState state = CellState.EMPTY;
	private int hIndex;
	private int iIndex;

	/**
	 * 
	 * @param hIndex
	 * @param iIndex
	 */
	public Cell(int hIndex, int iIndex) {
		this.hIndex = hIndex;
		this.iIndex = iIndex;
	}

	/**
	 * 
	 * @return
	 */
	public int getHIndex(){
		return hIndex;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIIndex(){
		return iIndex;
	}
	
	/**
	 * 
	 * @return
	 */
	public CellState getState() {
		return this.state;
	}

	/**
	 * 
	 * @param state
	 */
	public void setState(CellState state) {
		this.state = state;
	}
}
