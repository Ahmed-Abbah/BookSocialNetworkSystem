package abbah.ahmed.BookSocialNetwork.repository;


import abbah.ahmed.BookSocialNetwork.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Long,Book> {

}
