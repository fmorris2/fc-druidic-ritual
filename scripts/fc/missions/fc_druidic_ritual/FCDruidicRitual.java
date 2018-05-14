package scripts.fc.missions.fc_druidic_ritual;

import java.util.Arrays;
import java.util.LinkedList;

import org.tribot.api2007.WorldHopper;

import scripts.fc.framework.quest.QuestScriptManager;
import scripts.fc.framework.requirement.Requirement;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_druidic_ritual.data.DRRequirements;
import scripts.fc.missions.fc_druidic_ritual.data.DRSettings;
import scripts.fc.missions.fc_druidic_ritual.tasks.impl.DipMeats;
import scripts.fc.missions.fc_druidic_ritual.tasks.impl.SanfewFirstDialogue;
import scripts.fc.missions.fc_druidic_ritual.tasks.impl.SanfewSecondDialogue;
import scripts.fc.missions.fc_druidic_ritual.tasks.impl.StartQuest;
import scripts.fc.missions.fc_druidic_ritual.tasks.impl.TurnInQuest;

public class FCDruidicRitual extends QuestScriptManager
{
	public static final int SETTING = 80;
	
	public FCDruidicRitual(FCMissionScript fcScript)
	{
		super(fcScript);
	}

	@Override
	public boolean canStart()
	{
		return WorldHopper.isMembers(WorldHopper.getWorld());
	}

	@Override
	public boolean hasReachedEndingCondition()
	{
		return DRSettings.QUEST_COMPLETE.isValid();
	}

	@Override
	public String getMissionName()
	{
		return "FC Druidic Ritual";
	}

	@Override
	public String getEndingMessage()
	{
		return "FC Druidic Ritual has ended";
	}

	@Override
	public String[] getMissionSpecificPaint()
	{
		return new String[]{};
	}

	@Override
	public void resetStatistics()
	{
	}

	@Override
	public Requirement[] getRequirements()
	{
		return new Requirement[]{new DRRequirements(missionScript)};
	}

	@Override
	public LinkedList<Task> getTaskList()
	{
		return new LinkedList<>(Arrays.asList(new StartQuest(), new TurnInQuest(), new SanfewFirstDialogue(),
				new SanfewSecondDialogue(), new DipMeats(), new TurnInQuest()));
	}
	
	public String toString()
	{
		return "Druidic Ritual";
	}

	@Override
	public int getQuestPointReward() {
		return 4;
	}

}
