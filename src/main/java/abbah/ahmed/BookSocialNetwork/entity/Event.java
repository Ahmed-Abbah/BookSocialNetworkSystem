package abbah.ahmed.BookSocialNetwork.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String date;
    @Column
    private String location;
    @Column
    private String capacity;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}
