import java.util.List;
import java.util.NoSuchElementException;


public class BingeIterator implements EpisodeIterator {

    private final List<Season> seasons;
    private int seasonIndex = 0;
    private EpisodeIterator currentIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        if (!seasons.isEmpty()) {
            currentIterator = seasons.get(0).normalOrderIterator();
        }
    }

    @Override
    public boolean hasNext() {
        while (seasonIndex < seasons.size()) {
            if (currentIterator != null && currentIterator.hasNext()) {
                return true;
            }
            seasonIndex++;
            if (seasonIndex < seasons.size()) {
                currentIterator = seasons.get(seasonIndex).normalOrderIterator();
            }
        }
        return false;
    }

    @Override
    public Episode next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more episodes in series.");
        }
        return currentIterator.next();
    }
}
