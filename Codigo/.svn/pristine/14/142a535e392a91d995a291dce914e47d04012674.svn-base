package Presentacion.Ventas;

import javax.swing.plaf.basic.BasicComboBoxRenderer;



import java.awt.Color;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

public class EnabledJComboBoxRenderer extends BasicComboBoxRenderer{
	static final long serialVersionUID = -984932432414L;
	private final ListSelectionModel enabledItems;
	private Color disabledColor = Color.lightGray;

	public EnabledJComboBoxRenderer(ListSelectionModel enabled){

		super();

		this.enabledItems = enabled;

	}
	public void setDisabledColor(Color disabledColor){
		this.disabledColor = disabledColor;

	}

	@SuppressWarnings("rawtypes")
	@Override

	public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus) {

		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		if ( !enabledItems.isSelectedIndex(index) ){//not enabled
			if ( isSelected ){
				c.setBackground(UIManager.getColor("ComboBox.background"));
			}else{
				c.setBackground(super.getBackground());
			}
			c.setForeground(disabledColor);
		}else{
			c.setBackground(super.getBackground());
			c.setForeground(super.getForeground());
		}
		return c;

	}
}
