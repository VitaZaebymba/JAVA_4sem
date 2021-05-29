package ru.mirea.controllers;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.mirea.dto.DtoConverter;
import ru.mirea.services.GroupService;

@Controller
@RequestMapping({"/home", "/groups"})
public class GroupController {
    @Autowired
    private DtoConverter dtoConverter;
    @Autowired
    private GroupService groupService;

    @GetMapping
    public String index(Map<String, Object> model) {
        model.put(
                "groups",
                groupService.takeAllGroups(dtoConverter::toGroupResponseList)
        );
        return "home";
    }

    @PostMapping("/{groupId}/delete")
    public RedirectView delete(@PathVariable long groupId) {
        groupService.delete(groupId);
        return new RedirectView("/home");
    }
}
