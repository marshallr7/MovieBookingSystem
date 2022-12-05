package Movie;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Review {
    private double rating;
    private String header;
    private String reviewer;
    private String review;
}
