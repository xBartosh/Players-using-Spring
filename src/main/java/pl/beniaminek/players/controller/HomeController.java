package pl.beniaminek.players.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.UriComponentsBuilder;
import pl.beniaminek.players.service.PlayerService;
import pl.beniaminek.players.group.Group;
import pl.beniaminek.players.group.PlayerGroup;
import pl.beniaminek.players.player.Player;
import pl.beniaminek.players.player.PreferredFoot;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final PlayerService playerService;

    public HomeController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/")
    String home(){
        return "index";
    }

    @GetMapping("/dodaj")
    String add(Model model){
        model.addAttribute("foot", PreferredFoot.values());
        model.addAttribute("group", Group.values());
        return "add-player";
    }

    @PostMapping("/zapisz")
    String save(Player player, String group){
        playerService.save(player, group);
        return "redirect:/";
    }

    @GetMapping("/zawodnicy")
    String players(Model model){
        List<PlayerGroup> playerGroups = playerService.findAllPlayerGroups();
        model.addAttribute("playerGroups", playerGroups);
        return "players";
    }

    @GetMapping("/wyszukaj")
    String search(Model model){
        model.addAttribute("group", Group.values());
        return "search";
    }

    @PostMapping("/search-group")
    String searchGroup(Group group){
        PlayerGroup playerGroup = playerService.findPlayerGroup(group.getGroupName()).get();

        return UriComponentsBuilder
                .fromPath("redirect:group")
                .queryParam("groupName", playerGroup.getGroupName().getGroupName())
                .build().toString();
    }

    @GetMapping("/group")
    String group(String groupName, Model model){
        Optional<PlayerGroup> playerGroup = playerService.findPlayerGroup(groupName);
        if(!playerGroup.isPresent()){
            return "group-not-found";
        }

        model.addAttribute("playerGroup", playerGroup.get());
        return "group";
    }
}
