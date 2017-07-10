package scripts.fc.missions.fc_druidic_ritual.tasks.impl;

import org.tribot.api.Timing;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.travel.Travel;
import scripts.fc.framework.task.Task;

public abstract class SanfewDialogue extends Task
{
	private static final long serialVersionUID = 2669913014463908630L;

	public static final Positionable SANFEW_TILE = new RSTile(2900,3427,1);
	private static final Positionable STAIRS_TILE = new RSTile(2897, 3428,0);
	public static final int DIST_THRESH = 7;
	
	@Override
	public boolean execute()
	{
		RSTile pos = Player.getPosition();
		if(pos.getPlane() == 1 && pos.distanceTo(SANFEW_TILE) <= DIST_THRESH)
			return new NpcDialogue("Talk-to", "Sanfew", 10, 0,1).execute();
		else if(pos.distanceTo(STAIRS_TILE) > DIST_THRESH)
			return Travel.webWalkTo(STAIRS_TILE) && Timing.waitCondition(FCConditions.withinDistanceOfTile(STAIRS_TILE, DIST_THRESH), 5000);
		return new ClickObject("Climb-up", "Staircase", 7).execute() && Timing.waitCondition(FCConditions.planeChanged(0), 5000);
	}
	
}
