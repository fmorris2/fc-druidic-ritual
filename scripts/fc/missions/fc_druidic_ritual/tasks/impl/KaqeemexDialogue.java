package scripts.fc.missions.fc_druidic_ritual.tasks.impl;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.travel.Travel;
import scripts.fc.framework.task.Task;

public abstract class KaqeemexDialogue extends Task
{
	private static final long serialVersionUID = 1258735248555577559L;
	private static final Positionable KAQEEMEX_TILE = new RSTile(2922,3483,0);
	private static final int DIST_THRESH = 10;
	
	@Override
	public boolean execute()
	{
		if(Player.getPosition().distanceTo(KAQEEMEX_TILE) > DIST_THRESH)
			return Travel.webWalkTo(KAQEEMEX_TILE);
		
		return new NpcDialogue("Talk-to", "Kaqeemex", 10, 1,0).execute();
	}
	
}
