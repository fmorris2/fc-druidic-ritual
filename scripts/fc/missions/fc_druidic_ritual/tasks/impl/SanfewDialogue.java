package scripts.fc.missions.fc_druidic_ritual.tasks.impl;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.travel.Travel;
import scripts.fc.framework.task.Task;

public abstract class SanfewDialogue extends Task
{
	private static final long serialVersionUID = 2669913014463908630L;

	private static final Positionable SANFEW_TILE = new RSTile(2898,3427,1);
	private static final int DIST_THRESH = 7;
	
	@Override
	public boolean execute()
	{
		if(Player.getPosition().distanceTo(SANFEW_TILE) > DIST_THRESH)
			return Travel.webWalkTo(SANFEW_TILE);
		
		return new NpcDialogue("Talk-to", "Sanfew", 10, 0,1).execute();
	}
	
}
