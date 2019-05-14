package in.anil.questbook.service;

import in.anil.questbook.model.QuestBook;

import java.util.List;

public interface QuestBookService {
    QuestBook save(QuestBook questBook);
    QuestBook update(QuestBook questBook);
    QuestBook get(Long id);
    List<QuestBook> getAll();
    List<QuestBook> getPendingList();
    List<QuestBook> getApprovedList();
    List<QuestBook> getRejectedList();
    List<QuestBook> getQuestBookOfUser(String username);
}
