package Movie;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data @Builder
public class Movie {
    private String title;
    private String description;
    private double price;
    private int ticketsSold;
    private HashMap<String, List<String>> showings; // Theater location - List of Times
    public List<Review> reviews;

    public void addShowing(String theater, String time) {
        if (!showings.containsKey(theater)) {
            List<String> times = new ArrayList<>();
            times.add(time);
            showings.put(theater, times);
        } else {
            showings.get(theater).add(time);
        }
    }

    public void addReview(Review review) {
        reviews.add(review);
    }
}
