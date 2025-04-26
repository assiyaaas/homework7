import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.NoSuchElementException;

public class ShuffleSeasonIterator implements EpisodeIterator {

    private final List<Episode> shuffledEpisodes;
    private int currentIndex = 0;

    public ShuffleSeasonIterator(List<Episode> episodes, long seed) {
        this.shuffledEpisodes = new ArrayList<>(episodes);
        Collections.shuffle(this.shuffledEpisodes, new Random(seed));
    }

    @Override
    public boolean hasNext() {
        return currentIndex < shuffledEpisodes.size();
    }

    @Override
    public Episode next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more episodes.");
        }
        return shuffledEpisodes.get(currentIndex++);
    }
}
