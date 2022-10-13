package pl.beniaminek.players.service;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.beniaminek.players.group.Group;
import pl.beniaminek.players.group.PlayerGroup;
import pl.beniaminek.players.player.Player;
import pl.beniaminek.players.PlayerGroupRepository;
import pl.beniaminek.players.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    PlayerGroupRepository playerGroupRepository;
    PlayerRepository playerRepository;

    public PlayerService(PlayerGroupRepository playerGroupRepository, PlayerRepository playerRepository) {
        this.playerGroupRepository = playerGroupRepository;
        this.playerRepository = playerRepository;
    }

    @Transactional
    public void save(Player player, String group){
        Optional<PlayerGroup> playerGroup = playerGroupRepository.findByGroupName(Group.valueOf(group));
        playerGroup.ifPresent(p -> p.addPlayer(player));
    }

    public Optional<PlayerGroup> findPlayerGroup(String group){
        return EnumUtils.isValidEnum(Group.class, group) ? playerGroupRepository.findByGroupName(Group.valueOf(group)) : Optional.empty();
    }
    public List<PlayerGroup> findAllPlayerGroups(){
        List<PlayerGroup> groupList = new ArrayList<>();
        addGroups(groupList);

        return groupList;
    }

    private void addGroups(List<PlayerGroup> groupList) {
        Iterable<PlayerGroup> playerGroups = playerGroupRepository.findAll();
        playerGroups.forEach(groupList::add);
    }

}
