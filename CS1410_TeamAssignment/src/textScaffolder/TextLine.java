package textScaffolder;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextLine {
	private TextStructure textStructure;
	private JPanel hostPanel;
	private List<String> separatedFillableText;
	private String fillableSlotMark;
	private String iteratorMark;
	
	/**
	 * @param textStructure
	 * @param hostPanel
	 * @param separatedFillableText
	 */
	public TextLine(TextStructure textStructure, JPanel hostPanel) {
		this.textStructure = textStructure;
		this.hostPanel = hostPanel;
		this.separatedFillableText = textStructure.getSeparatedFillableText();
		this.fillableSlotMark = textStructure.getFillableSlotMark();
		this.iteratorMark = textStructure.getIteratorMark();
	}
	
	public List<Component> createLine(int iterator) {
		List<Component> lineComponents = new ArrayList<>();
		
		for (String str : separatedFillableText) {
			if(str.contains(fillableSlotMark) || str.contains("*")) {
				JTextField textDynamicComponent = new JTextField();
				textDynamicComponent.setColumns(10);
				lineComponents.add(textDynamicComponent);
				hostPanel.add(textDynamicComponent);
			}
			else if (str.contains(iteratorMark)) {
				JLabel lblFixedComponent = new JLabel(str.replace(iteratorMark, Integer.toString(iterator)));
				lblFixedComponent.setHorizontalAlignment(SwingConstants.TRAILING);
				lineComponents.add(lblFixedComponent);
				hostPanel.add(lblFixedComponent);
			}
			else {
				JLabel lblFixedComponent = new JLabel(str);
				lblFixedComponent.setHorizontalAlignment(SwingConstants.TRAILING);
				lineComponents.add(lblFixedComponent);
				hostPanel.add(lblFixedComponent);
			}
		}
		
		return lineComponents;
	}
}
