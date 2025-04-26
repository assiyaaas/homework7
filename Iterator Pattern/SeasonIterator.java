import java.util.List;
import java.util.NoSuchElementException;

public class SeasonIterator implements EpisodeIterator {

    private final List<Episode> episodes;
    private int currentIndex = 0;

    public SeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < episodes.size();
    }

    @Override
    public Episode next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more episodes.");
        }
        return episodes.get(currentIndex++);
    }
}
