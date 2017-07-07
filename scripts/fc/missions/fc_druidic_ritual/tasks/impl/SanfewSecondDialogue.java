package scripts.fc.missions.fc_druidic_ritual.tasks.impl;

import scripts.fc.api.items.FCItem;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_druidic_ritual.data.DRRequirements;
import scripts.fc.missions.fc_druidic_ritual.data.DRSettings;

public class SanfewSecondDialogue extends SanfewDialogue implements ItemsRequiredTask
{
	private static final long serialVersionUID = 1346784624476946188L;

	@Override
	public boolean shouldExecute()
	{
		return DRSettings.SECOND_SANFEW_DIALOGUE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Sanfew second dialogue";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]
		{
			new FCItem(1, false, DRRequirements.ENCHANTED_BEAR),
			new FCItem(1, false, DRRequirements.ENCHANTED_RAT),
			new FCItem(1, false, DRRequirements.ENCHANTED_CHICKEN),
			new FCItem(1, false, DRRequirements.ENCHANTED_BEEF)
		};
	}

}
