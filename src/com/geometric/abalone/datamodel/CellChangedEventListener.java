/**
 * 
 */
package com.geometric.abalone.datamodel;

import java.util.EventListener;
import java.util.EventObject;

/**
 * @author nimishm
 * 
 */
public interface CellChangedEventListener extends EventListener {
	void onCellChanged(EventObject e);
}
