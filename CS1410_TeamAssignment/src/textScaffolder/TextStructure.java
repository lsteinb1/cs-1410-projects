package textScaffolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 */
public class TextStructure {
	private String fillableText;
	private String fillableSlotMark;
	// private int fillableSlots; // might be unnecessary
	private String structureName;
	private String structureDesc;
	private String iteratorMark;
	private int numberOfTextLines;
	private TextLine[] textLines;
	private List<String> separatedFillableText;
	
	/**
	 * @param fillableText - the text that can be filled, which is repeated in every TextLine.
	 * @param fillableSlotMark
	 * @param fillableSlots
	 * @param structureDesc
	 * @param iteratorMark
	 * @param numberOfTextLines
	 */
	public TextStructure(String structureName, String structureDesc, String fillableText, String fillableSlotMark, String iteratorMark, int numberOfTextLines) {
		this.structureName = structureName;
		this.structureDesc = structureDesc;
		this.fillableText = fillableText;
		this.fillableSlotMark = fillableSlotMark;
		this.iteratorMark = iteratorMark;
		this.numberOfTextLines = numberOfTextLines;
		
		separatedFillableText = new ArrayList<>();
		
		String[] splitFillableText = fillableText.split("((?<=\\" + fillableSlotMark + ")|(?=\\" + fillableSlotMark + "))" );
		// https://stackoverflow.com/questions/2206378/how-to-split-a-string-but-also-keep-the-delimiters
		for (String str : splitFillableText) { // for some reason, Collections.addAll() wasn't working here
			separatedFillableText.add(str);
		}
		
	}
	
	/**
	 * @param separatedFillableText
	 * @param fillableSlotMark
	 * @param structureDesc
	 * @param iteratorMark
	 * @param numberOfTextLines
	 */
	public TextStructure(String structureName, String structureDesc, List<String> separatedFillableText, String fillableSlotMark, String iteratorMark, int numberOfTextLines) {
		this.structureName = structureName;
		this.structureDesc = structureDesc;
		this.separatedFillableText = separatedFillableText;
		this.fillableSlotMark = fillableSlotMark;
		this.iteratorMark = iteratorMark;
		this.numberOfTextLines = numberOfTextLines;
	}

	/**
	 * @return the fillableText
	 */
	public String getFillableText() {
		return fillableText;
	}

	/**
	 * @return the fillableSlotMark
	 */
	public String getFillableSlotMark() {
		return fillableSlotMark;
	}
	
	/**
	 * @return the structureName
	 */
	public String getStructureName() {
		return structureName;
	}

	/**
	 * @return the structureDesc
	 */
	public String getStructureDesc() {
		return structureDesc;
	}

	/**
	 * @return the iteratorMark
	 */
	public String getIteratorMark() {
		return iteratorMark;
	}

	/**
	 * @return the numberOfTextLines
	 */
	public int getNumberOfTextLines() {
		return numberOfTextLines;
	}

	/**
	 * @return the textLines
	 */
	public TextLine[] getTextLines() {
		return textLines;
	}

	/**
	 * @return the separatedFillableText
	 */
	public List<String> getSeparatedFillableText() {
		return separatedFillableText;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getStructureName() + "\n" + this.getStructureDesc() + "\n" + this.getFillableSlotMark() + "\n" + this.getIteratorMark() + "\n");
		for(String str : separatedFillableText) {
			sb.append(str);
		}
		
		return sb.toString();
	}
}
