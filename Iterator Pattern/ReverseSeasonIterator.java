import java.util.List;
import java.util.NoSuchElementException;

public class ReverseSeasonIterator implements EpisodeIterator {

    private final List<Episode> episodes;
    private int currentIndex;

    public ReverseSeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
        this.currentIndex = episodes.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public Episode next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more episodes.");
        }
        return episodes.get(currentIndex--);
    }
}
