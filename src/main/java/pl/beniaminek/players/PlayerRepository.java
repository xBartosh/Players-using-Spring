package pl.beniaminek.players;

import org.springframework.data.repository.CrudRepository;
import pl.beniaminek.players.player.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
