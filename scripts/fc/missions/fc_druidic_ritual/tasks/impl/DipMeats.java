package scripts.fc.missions.fc_druidic_ritual.tasks.impl;

import java.util.Arrays;

import org.tribot.api.Timing;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.interaction.impl.objects.ItemOnObject;
import scripts.fc.api.items.FCItem;
import scripts.fc.api.travel.Travel;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_druidic_ritual.data.DRRequirements;
import scripts.fc.missions.fc_druidic_ritual.data.DRSettings;

public class DipMeats extends Task implements ItemsRequiredTask
{
	private static final long serialVersionUID = 350376515426295528L;
	private static final Positionable CAULDRON_TILE = new RSTile(2892,9831,0);
	private static final int DIST_THRESH = 6;
	private static final String[] ITEM_NAMES = {"Raw bear meat", "Raw rat meat", "Raw chicken", "Raw beef"};
	private static final int CAULDRON_ID = 2142;

	@Override
	public boolean execute()
	{
		RSTile pos = Player.getPosition();
		if(pos.getPlane() == 1 && pos.distanceTo(SanfewDialogue.SANFEW_TILE) <= SanfewDialogue.DIST_THRESH)
			return new ClickObject("Climb-down", "Staircase", 10).execute() && Timing.waitCondition(FCConditions.planeChanged(1), 4000);
		else if(pos.distanceTo(CAULDRON_TILE) > DIST_THRESH)
			return Travel.webWalkTo(CAULDRON_TILE) && Timing.waitCondition(FCConditions.withinDistanceOfTile(CAULDRON_TILE, DIST_THRESH), 5000);
		
		Arrays.stream(ITEM_NAMES)
			.filter(s -> Inventory.getCount(s) > 0)
			.forEachOrdered(s -> {
				if(new ItemOnObject("Use", CAULDRON_ID, s, 10).execute())
					Timing.waitCondition(FCConditions.inventoryNotContains(s), 3500);
			});
		
		return true;
	}

	@Override
	public boolean shouldExecute()
	{
		return DRSettings.DIP_MEATS_IN_CAULDRON.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Dip meats";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		if(Inventory.getCount(ITEM_NAMES) > 0)
			return new FCItem[]{};
		
		return new FCItem[]
		{
			new FCItem(1, false, DRRequirements.BEAR_MEAT),
			new FCItem(1, false, DRRequirements.BEEF),
			new FCItem(1, false, DRRequirements.CHICKEN),
			new FCItem(1, false, DRRequirements.RAT_MEAT),
		};
	}

}
