package oogasalad.builder.backend.record;

import java.util.List;

/**
 * PhaseBuilderRecord class is generated by the Builder UI Contains information about a phase in a
 * turn
 * <p>
 * Description is a string that describes the phase AllowedGroups is a list of groups that can be
 * interacted with during a given phase HandsToCheck is a map that associates a group name with a
 * list of conditions (needs to be converted to PlayerActions later by Parser) MaxTransfers is the
 * maximum number of transfers that can be made during a given phase
 * <p>
 * TODO: Direction of transfers *must* be consistent for all transfers in a phase (i.e. all
 * transfers must be from player to CPU or vice versa)
 * TODO This is set by Builder UI which makes sure that all CPUActionBuilder that are transfers in a phase have the same direction
 */
public record PhaseRecord(String description, List<ConditionRecord> conditions,
                          List<PlayerActionRecord> playerActions) implements StageRecord {

  //TODO Changed: removed enum list of cond. Now need to initialize ConditionRecord Objects!!!
  @Override
  public List<ComputerActionRecord> beforeActions() {
    return null;
  } //supposed to be null

  @Override
  public List<ComputerActionRecord> afterActions() {
    return null;
  } //supposed to be null

  @Override
  public List stages() {
    return null;
  } //supposed to be null

  public String toVerboseString() {
    return "PhaseBuilderRecord{" +
            "description='" + description + '\'' +
            ", playerActions=" + playerActions.toString() +
            ", conditions=" + conditions.toString() +
            '}';
  }
  @Override
  public String toString() {
    return description;
  }
}

