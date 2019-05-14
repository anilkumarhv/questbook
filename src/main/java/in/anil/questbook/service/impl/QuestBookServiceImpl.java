package in.anil.questbook.service.impl;

import in.anil.questbook.dao.QuestBookRepository;
import in.anil.questbook.dao.UserRepository;
import in.anil.questbook.model.QuestBook;
import in.anil.questbook.model.User;
import in.anil.questbook.service.QuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class QuestBookServiceImpl implements QuestBookService {
    @Autowired
    private QuestBookRepository questBookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public QuestBook save(QuestBook questBook) {
        return questBookRepository.save(questBook);
    }

    @Override
    public QuestBook update(QuestBook questBook) {
        return questBookRepository.save(questBook);
    }

    @Override
    public QuestBook get(Long id) {
        return questBookRepository.getOne(id);
    }

    @Override
    public List<QuestBook> getAll() {
        return questBookRepository.findAll();
    }

    @Override
    public List<QuestBook> getPendingList() {
        return questBookRepository.findAll().stream().filter(questBook -> questBook.getPending().equals(true)).collect(Collectors.toList());
    }

    @Override
    public List<QuestBook> getApprovedList() {
        return questBookRepository.findAll().stream().filter(questBook -> questBook.getApproved().equals(true)).collect(Collectors.toList());
    }

    @Override
    public List<QuestBook> getRejectedList() {
        return questBookRepository.findAll().stream().filter(questBook -> questBook.getRejected().equals(true)).collect(Collectors.toList());
    }

    @Override
    public List<QuestBook> getQuestBookOfUser(String username) {
        User user=userRepository.findByUsername(username);
        return questBookRepository.findAll().stream().filter(questBook -> questBook.getUser().getUsername().equals(user.getUsername())).collect(Collectors.toList());
    }
}
