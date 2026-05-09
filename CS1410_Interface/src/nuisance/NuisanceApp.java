package nuisance;

import java.util.ArrayList;

public class NuisanceApp {

	public static void main(String[] args) {
		Friend[] friends = {new Friend("Juan", 27, Hobby.MUSIC), new Friend("Kate", 27, Hobby.SPORTS), new Friend("Alex", 21, Hobby.MUSIC)};
		System.out.println(friends.length + " Friends:");
		System.out.println("friend1: " + friends[0].toString());
		System.out.println("friend2: " + friends[1].toString());
		System.out.println("friend3: " + friends[2].toString());
		System.out.println();
		
		System.out.println("friend1 equals friend2: " + friends[0].equals(friends[1]));
		System.out.println("friend2 equals friend3: " + friends[1].equals(friends[2]));
		Friend newFriend = new Friend("Kate", 27, Hobby.SPORTS);
		System.out.println("friend2 equals new friend: " + friends[1].equals(newFriend));
		System.out.println();
		
		Telemarketer fritz = new Telemarketer("Fritz", 25);
		System.out.println("telemarketer: " + fritz.toString());
		System.out.println();
		
		ArrayList<String> swallowtailColors = new ArrayList<String>();
		swallowtailColors.add("yellow");
		swallowtailColors.add("black");
		swallowtailColors.add("blue");
		
		Mosquito mos = new Mosquito("Aedes vexans");
		PeskyMosquito quito = new PeskyMosquito("Anopheles walkeri");
		Butterfly butteredFly = new Butterfly("Swallowtail", swallowtailColors);
		Butterfly swallowedTail = new Butterfly(butteredFly);
		Insect[] arthropods = {mos, quito, butteredFly, swallowedTail};
		System.out.println(arthropods.length + " Insects:");
		for (Insect arth : arthropods) {
			System.out.println(arth.toString());
		}
		System.out.println();
		
		Nuisance[] nuisances = {fritz, mos, quito};
		System.out.println(nuisances.length + " Nuisances:");
		for (Nuisance n : nuisances) {
			if (n instanceof Mosquito) {
				System.out.println(((Mosquito)n).buzz());
				if (n instanceof PeskyMosquito) {
					System.out.println(((PeskyMosquito)n).bite());
				}
			}
			System.out.println(n.annoy());
			System.out.println();
		}
		System.out.println();
	}

}
