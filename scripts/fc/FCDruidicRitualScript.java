package scripts.fc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Ending;
import org.tribot.script.interfaces.Painting;
import org.tribot.script.interfaces.Starting;

import scripts.fc.framework.mission.Mission;
import scripts.fc.framework.paint.FCPaintable;
import scripts.fc.framework.script.FCMissionScript;

@ScriptManifest(
		authors     = { 
		    "Final Calibur",
		}, 
		category    = "Quests", 
		name        = "FC Druidic Ritual", 
		version     = 0.1, 
		description = "Completes Druidic Ritual for you. Start anywhere. Must have enough gold on account to buy requirements from GE.", 
		gameMode    = 1)
public class FCDruidicRitualScript extends FCMissionScript implements FCPaintable, Painting, Starting, Ending
{
	@Override
	protected Queue<Mission> getMissions()
	{
		return new LinkedList<>(Arrays.asList());
	}

	@Override
	protected String[] scriptSpecificPaint()
	{
		return new String[]{};
	}
}
