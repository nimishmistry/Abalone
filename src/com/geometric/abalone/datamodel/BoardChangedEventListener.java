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
public interface BoardChangedEventListener extends EventListener {
	void onBoardChanged(EventObject e);
}
