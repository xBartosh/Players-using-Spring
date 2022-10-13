package pl.beniaminek.players.group;

import pl.beniaminek.players.group.Group;
import pl.beniaminek.players.player.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PlayerGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private Group groupName;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "group_id")
    private List<Player> players = new ArrayList<>();

    public PlayerGroup() {
    }

    public PlayerGroup(Group groupName) {
        this.groupName = groupName;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getGroupName() {
        return groupName;
    }

    public void setGroupName(Group groupName) {
        this.groupName = groupName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
