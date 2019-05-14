package in.anil.questbook.dao;

import in.anil.questbook.model.QuestBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestBookRepository extends JpaRepository<QuestBook, Long> {
}
