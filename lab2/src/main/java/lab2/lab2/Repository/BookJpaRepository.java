package lab2.lab2.Repository;

import lab2.lab2.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Long> {

    public void deleteByName(String name);

    @Modifying
    @Query("update Book b set b.availableCopies=?2 where b.id=?1")
    public void change(long id,int vrednost);

}
