package scripts.fc.missions.fc_druidic_ritual.tasks.impl;

import scripts.fc.missions.fc_druidic_ritual.data.DRSettings;

public class TurnInQuest extends KaqeemexDialogue
{
	private static final long serialVersionUID = 2046412066279249548L;

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
