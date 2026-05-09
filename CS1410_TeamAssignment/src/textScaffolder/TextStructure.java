package textScaffolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a TextStructure to store and give information about what structure each TextLine should be in.
 * Some of this information is also used in TextScaffolder, such as structureName.
 * 
 * @author Lydia
 * 
 */
public class TextStructure {
	private String fillableText;
	private String fillableSlotMark;
	private String structureName;
	private String structureDesc;
	private String iteratorMark;
	private int numberOfTextLines;
	private TextLine[] textLines;
	private List<String> separatedFillableText;
	private int startFrom;
	
	/**
	 * Constructs a TextStructure, based mostly on fillableText that will be parsed in a TextLine, using the fillableSlotMark and (if used) iteratorMark.
	 * 
	 * @param structureName - labels the TextStructure with a name.
	 * @param structureDesc - briefly describes the purpose of this TextStructure.
	 * @param fillableText - the text that can be filled, which is repeated in every TextLine.
	 * @param fillableSlotMark - marks a location in fillableText that should become a fillable slot when the TextStructure is used to initialize components.
	 * @param iteratorMark - marks a location in fillableText that should be replaced by an iterator when the TextStructure is used to initialize components.
	 * @param numberOfTextLines - marks how many TextLines this text structure should initialize. (always defaults to 5 in the scope of this project.)
	 */
	public TextStructure(String structureName, String structureDesc, String fillableText, String fillableSlotMark, String iteratorMark, int numberOfTextLines, int startFrom) {
		this.structureName = structureName;
		this.structureDesc = structureDesc;
		this.fillableText = fillableText;
		this.fillableSlotMark = fillableSlotMark;
		this.iteratorMark = iteratorMark;
		this.startFrom = startFrom;
		this.numberOfTextLines = numberOfTextLines;
		
		separatedFillableText = new ArrayList<>();
		
		// source of regex used below: https://stackoverflow.com/questions/2206378/how-to-split-a-string-but-also-keep-the-delimiters
		String[] splitFillableText = fillableText.split("((?<=\\" + fillableSlotMark + ")|(?=\\" + fillableSlotMark + "))" );
		
		for (String str : splitFillableText) { // for some reason, Collections.addAll() wasn't working here
			separatedFillableText.add(str);
		}
		
	}
	
	/**
	 * Constructs a TextStructure, based mostly on fillableText that is already separated into a List<String>.
	 * This constructor is only used if initializing a TextStructure from within another class.
	 * It was used in this project for testing, and will probably be useful if/when I continue this project in the future.
	 * 
	 * @param separatedFillableText - the text that can be filled, already separated into a List.
	 * @param fillableSlotMark
	 * @param structureDesc
	 * @param iteratorMark
	 * @param numberOfTextLines
	 */
	public TextStructure(String structureName, String structureDesc, List<String> separatedFillableText, String fillableSlotMark, String iteratorMark, int numberOfTextLines, int startFrom) {
		this.structureName = structureName;
		this.structureDesc = structureDesc;
		this.separatedFillableText = separatedFillableText;
		this.fillableSlotMark = fillableSlotMark;
		this.iteratorMark = iteratorMark;
		this.startFrom = startFrom;
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
		sb.append("\n" + this.getNumberOfTextLines() + "\n" + this.getStartFrom());
		
		return sb.toString();
	}

	/**
	 * @return the startFrom
	 */
	public int getStartFrom() {
		return startFrom;
	}
}
