package labCollection;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Initializes ArrayLists and a HashSet of Couch objects.
 * 
 * @author Lydia
 */
public class CouchApp {

	public static void main(String[] args) {
		Color[] colors = {Color.BLACK, Color.BLUE, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.RED, Color.WHITE};
	
		List<Couch> couches = new ArrayList<>();
		for(int i = 0; i < colors.length; i++) {
			couches.add(new Couch(colors[i], Material.FABRIC));
			couches.add(new Couch(colors[i], Material.LEATHER));
			couches.add(new Couch(colors[i], Material.VINYL));
		}
		
		List<Couch> favorites = new ArrayList<>();
		favorites.add(new Couch(Color.RED, Material.FABRIC));
		favorites.add(new Couch(Color.BLACK, Material.LEATHER));
		favorites.add(new Couch(Color.WHITE, Material.VINYL));
		
		printCouchesNumOfCouchesAndFavoritesInList(couches, favorites);
		
		System.out.println("Removing all vinyl couches . . .\n");
		couches.removeIf(couch -> couch.getMaterial() == Material.VINYL);
		
		printCouchesNumOfCouchesAndFavoritesInList(couches, favorites);
		
		System.out.println("Adding all the favorites to the list couches . . .\n");
		couches.addAll(favorites);
		
		printCouchesNumOfCouchesAndFavoritesInList(couches, favorites);
		
		System.out.println("Initializing new Set based on List of couches (the set will remove duplicates) . . .\n");
		Set<Couch> couchSet = new HashSet<>(couches);
		printCouchesNumOfCouchesAndFavoritesInList(couchSet, favorites);
	}

	private static void printCouchesNumOfCouchesAndFavoritesInList(Collection<Couch> couches, Collection<Couch> favorites) { // should have programmed to interface from the beginning here
		System.out.println("All couches:");
		couches.forEach(couch -> System.out.println(couch.toString()));
		
		System.out.printf("Number of elements in list couches: %d%n", couches.size());
		
		System.out.println(couches.containsAll(favorites) ? "All favorites are in the list." :  "Not all favorites are in the list.");
		System.out.println();
	}

}
