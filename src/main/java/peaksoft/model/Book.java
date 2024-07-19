package peaksoft.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private Long id;
    private String name;
    private String country;
    private int publishedYear;
    private int price;
    private Long authorId;

}
