import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;

public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new LinkedList<>();
    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public int size() {
        return episodes.size();
    }

    @Override
    public Iterator<Episode> iterator() {
        return new SeasonIterator(episodes);
    }

    public EpisodeIterator normalOrderIterator() {
        return new SeasonIterator(episodes);
    }

    public EpisodeIterator reverseOrderIterator() {
        return new ReverseSeasonIterator(episodes);
    }

    public EpisodeIterator shuffleOrderIterator(long seed) {
        return new ShuffleSeasonIterator(episodes, seed);
    }
}
