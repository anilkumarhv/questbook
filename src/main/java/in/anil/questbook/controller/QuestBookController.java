package in.anil.questbook.controller;

import in.anil.questbook.dao.UserRepository;
import in.anil.questbook.model.QuestBook;
import in.anil.questbook.model.Status;
import in.anil.questbook.service.QuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static in.anil.questbook.model.Status.*;

@Controller
public class QuestBookController {
    @Autowired
    private QuestBookService questBookService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/admin/getAll")
    public String questBookList(Model model) {
        model.addAttribute("questBooks", questBookService.getAll());
        return "questBookList";
    }

    @GetMapping(value = "/myQuestBooks")
    public String myQuestBookList(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("questBooks", questBookService.getQuestBookOfUser(userName));
        return "myQuestBooks";
    }

    @PostMapping(value = "/questbook")
    public String questBook(@ModelAttribute("questbookForm") QuestBook questBook) {
        questBookService.save(questBook);
        return "redirect:/myQuestBooks";
    }

    @PostMapping(value = "/questbook/{id}/{status}")
    public String editQuestBook(@PathVariable Long id, @PathVariable String status, Model model) {
        QuestBook questBook = questBookService.get(id);
        if (Status.valueOf(status) == APPROVED) {
            questBook.setApproved(true);
            questBook.setStatus(APPROVED);
        } else if (Status.valueOf(status) == REJECTED) {
            questBook.setRejected(true);
            questBook.setStatus(REJECTED);
        } else {
            questBook.setRejected(true);
            questBook.setStatus(PENDING);
        }
        questBookService.save(questBook);
        return "redirect:/admin/getAll";
    }


}
