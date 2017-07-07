package scripts.fc.missions.fc_druidic_ritual.data;

import java.util.Arrays;

import scripts.fc.framework.quest.InvBankBool;
import scripts.fc.framework.quest.Order;
import scripts.fc.framework.quest.QuestState;
import scripts.fc.framework.quest.SettingBool;
import scripts.fc.missions.fc_druidic_ritual.FCDruidicRitual;

public enum DRSettings
{
	START_QUEST
	(
		new QuestState
		(
			new SettingBool(FCDruidicRitual.SETTING, 0, true, Order.EQUALS)
		)
	),
	
	FIRST_SANFEW_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCDruidicRitual.SETTING, 1, true, Order.EQUALS)
		)
	),
	
	DIP_MEATS_IN_CAULDRON
	(
		new QuestState
		(
			new SettingBool(FCDruidicRitual.SETTING, 2, true, Order.EQUALS),
			new InvBankBool(DRRequirements.BEAR_MEAT, 1, InvBankBool.TYPE.IN_ONE, true),
			new InvBankBool(DRRequirements.BEEF, 1, InvBankBool.TYPE.IN_ONE, true),
			new InvBankBool(DRRequirements.CHICKEN, 1, InvBankBool.TYPE.IN_ONE, true),
			new InvBankBool(DRRequirements.RAT_MEAT, 1, InvBankBool.TYPE.IN_ONE, true)
		)
	),
	
	SECOND_SANFEW_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCDruidicRitual.SETTING, 2, true, Order.EQUALS),
			new InvBankBool(DRRequirements.ENCHANTED_BEAR, 1, InvBankBool.TYPE.IN_ONE, true),
			new InvBankBool(DRRequirements.ENCHANTED_BEEF, 1, InvBankBool.TYPE.IN_ONE, true),
			new InvBankBool(DRRequirements.ENCHANTED_CHICKEN, 1, InvBankBool.TYPE.IN_ONE, true),
			new InvBankBool(DRRequirements.ENCHANTED_RAT, 1, InvBankBool.TYPE.IN_ONE, true)
		)
	),
	
	SECOND_KAQEMEEX_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCDruidicRitual.SETTING, 3, true, Order.EQUALS)
		)
	);
	
	private QuestState[] states;
	
	DRSettings(QuestState... states)
	{
		this.states = states;
	}
	
	public boolean isValid()
	{
		return Arrays.stream(states).allMatch(s -> s.validate());
	}
}
