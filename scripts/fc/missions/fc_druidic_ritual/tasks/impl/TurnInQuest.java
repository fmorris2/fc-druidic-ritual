package scripts.fc.missions.fc_druidic_ritual.tasks.impl;

import org.tribot.api.Timing;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.missions.fc_druidic_ritual.data.DRSettings;

public class TurnInQuest extends KaqemeexDialogue
{
	private static final long serialVersionUID = 2046412066279249548L;
	
	@Override
	public boolean execute()
	{
		RSTile pos = Player.getPosition();
		if(pos.getPlane() == 1 && pos.distanceTo(SanfewDialogue.SANFEW_TILE) <= SanfewDialogue.DIST_THRESH)
			return new ClickObject("Climb-down", "Staircase", 10).execute() && Timing.waitCondition(FCConditions.planeChanged(1), 4000);
		
		return super.execute();
	}

	@Override
	public boolean shouldExecute()
	{
		return DRSettings.SECOND_KAQEMEEX_DIALOGUE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Turn in quest";
	}

}
