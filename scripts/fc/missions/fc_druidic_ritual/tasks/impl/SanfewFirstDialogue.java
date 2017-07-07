package scripts.fc.missions.fc_druidic_ritual.tasks.impl;

import scripts.fc.api.items.FCItem;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_druidic_ritual.data.DRRequirements;
import scripts.fc.missions.fc_druidic_ritual.data.DRSettings;

public class SanfewFirstDialogue extends SanfewDialogue implements ItemsRequiredTask
{
	private static final long serialVersionUID = 2033003712538748738L;

	@Override
	public boolean shouldExecute()
	{
		return DRSettings.FIRST_SANFEW_DIALOGUE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Sanfew first dialogue";
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
