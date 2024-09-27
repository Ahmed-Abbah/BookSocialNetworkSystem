package abbah.ahmed.BookSocialNetwork.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private boolean isDamaged;
    @Column
    private String review;
    @Column
    private String rating;

}
