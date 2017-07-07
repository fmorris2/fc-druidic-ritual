package scripts.fc.missions.fc_druidic_ritual.tasks.impl;

import scripts.fc.api.items.FCItem;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_druidic_ritual.data.DRRequirements;
import scripts.fc.missions.fc_druidic_ritual.data.DRSettings;

public class DipMeats extends Task implements ItemsRequiredTask
{
	private static final long serialVersionUID = 350376515426295528L;

	@Override
	public boolean execute()
	{
		return false;
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
		return new FCItem[]
		{
			new FCItem(1, false, DRRequirements.BEAR_MEAT),
			new FCItem(1, false, DRRequirements.BEEF),
			new FCItem(1, false, DRRequirements.CHICKEN),
			new FCItem(1, false, DRRequirements.RAT_MEAT),
		};
	}

}
