public class Main {
    public static void main(String[] args) {

        Episode e1 = new Episode("Pilot", 1800);
        Episode e2 = new Episode("Second Episode", 1850);
        Episode e3 = new Episode("Finale", 1900);

        Season season1 = new Season();
        season1.addEpisode(e1);
        season1.addEpisode(e2);
        season1.addEpisode(e3);

        Season season2 = new Season();
        season2.addEpisode(new Episode("Season 2 - Ep 1", 2000));
        season2.addEpisode(new Episode("Season 2 - Ep 2", 2100));

        Series mySeries = new Series();
        mySeries.addSeason(season1);
        mySeries.addSeason(season2);

        System.out.println("Normal order:");
        EpisodeIterator it1 = season1.normalOrderIterator();
        while (it1.hasNext()) {
            System.out.println(it1.next().getTitle());
        }

        System.out.println("\nReverse order:");
        EpisodeIterator it2 = season1.reverseOrderIterator();
        while (it2.hasNext()) {
            System.out.println(it2.next().getTitle());
        }

        System.out.println("\nShuffle order:");
        EpisodeIterator it3 = season1.shuffleOrderIterator(42);
        while (it3.hasNext()) {
            System.out.println(it3.next().getTitle());
        }

        System.out.println("\nBinge watching entire series:");
        EpisodeIterator binge = mySeries.bingeIterator();
        while (binge.hasNext()) {
            System.out.println(binge.next().getTitle());
        }
    }
}
