package scripts.fc.missions.fc_druidic_ritual.tasks.impl;

import scripts.fc.api.items.FCItem;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_druidic_ritual.data.DRRequirements;
import scripts.fc.missions.fc_druidic_ritual.data.DRSettings;

public class StartQuest extends KaqemeexDialogue implements ItemsRequiredTask
{
	private static final long serialVersionUID = 5281100886246320024L;
	
	@Override
	public boolean shouldExecute()
	{
		return DRSettings.START_QUEST.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Start quest";
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
