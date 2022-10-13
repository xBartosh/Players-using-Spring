package pl.beniaminek.players;

import org.springframework.data.repository.CrudRepository;
import pl.beniaminek.players.group.Group;
import pl.beniaminek.players.group.PlayerGroup;

import java.util.Optional;

public interface PlayerGroupRepository extends CrudRepository<PlayerGroup,Long> {
    Optional<PlayerGroup> findByGroupName(Group groupName);
}
