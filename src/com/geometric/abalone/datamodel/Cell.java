package com.geometric.abalone.datamodel;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

/**
 * 
 * @author nimishm
 * 
 */
public class Cell {
	private CellState state = CellState.EMPTY;
	private int hIndex;
	private int iIndex;
	private List<CellChangedEventListener> mEvemtListeners;

	/**
	 * 
	 * @param hIndex
	 * @param iIndex
	 */
	public Cell(int hIndex, int iIndex) {
		this.hIndex = hIndex;
		this.iIndex = iIndex;

		mEvemtListeners = new ArrayList<CellChangedEventListener>();
	}

	/**
	 * 
	 * @return
	 */
	public int getHIndex() {
		return hIndex;
	}

	/**
	 * 
	 * @return
	 */
	public int getIIndex() {
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
		for (CellChangedEventListener listener : mEvemtListeners) {
			listener.onCellChanged(new EventObject(this));
		}
	}

	/**
	 * 
	 * @param listener
	 */
	public void setOnChangedListener(CellChangedEventListener listener) {
		mEvemtListeners.add(listener);
	}
}
