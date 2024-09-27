package abbah.ahmed.BookSocialNetwork.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private String genre;
    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name="user_id")
    private List<>
}
