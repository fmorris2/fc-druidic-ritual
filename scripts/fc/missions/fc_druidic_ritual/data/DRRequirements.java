package scripts.fc.missions.fc_druidic_ritual.data;

import scripts.fc.framework.quest.InvBankBool;
import scripts.fc.framework.quest.InvBankBool.TYPE;
import scripts.fc.framework.quest.Order;
import scripts.fc.framework.quest.SettingBool;
import scripts.fc.framework.requirement.item.ItemRequirement;
import scripts.fc.framework.requirement.item.ReqItem;
import scripts.fc.framework.requirement.item.SingleReqItem;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.missions.fc_druidic_ritual.FCDruidicRitual;

public class DRRequirements extends ItemRequirement
{
	public static final int RAT_MEAT = 2134, BEAR_MEAT = 2136, CHICKEN = 2138, BEEF = 2132,
			ENCHANTED_RAT = 523, ENCHANTED_BEAR = 524, ENCHANTED_CHICKEN = 525, ENCHANTED_BEEF = 522;
	
	public DRRequirements(FCMissionScript script)
	{
		super(script);
	}

	@Override
	public ReqItem[] getReqItems()
	{
		return new ReqItem[]
		{
			new SingleReqItem(RAT_MEAT, 1, true, true)
				.when(new SettingBool(FCDruidicRitual.SETTING, 2, true, Order.BEFORE).and(new InvBankBool(ENCHANTED_RAT, 1, TYPE.IN_ONE, false))),
			
			new SingleReqItem(BEAR_MEAT, 1, true, true)
				.when(new SettingBool(FCDruidicRitual.SETTING, 2, true, Order.BEFORE).and(new InvBankBool(ENCHANTED_BEAR, 1, TYPE.IN_ONE, false))),
			
			new SingleReqItem(CHICKEN, 1, true, true)
				.when(new SettingBool(FCDruidicRitual.SETTING, 2, true, Order.BEFORE).and(new InvBankBool(ENCHANTED_CHICKEN, 1, TYPE.IN_ONE, false))),
			
			new SingleReqItem(BEEF, 1, true, true)
				.when(new SettingBool(FCDruidicRitual.SETTING, 2, true, Order.BEFORE).and(new InvBankBool(ENCHANTED_BEEF, 1, TYPE.IN_ONE, false))),	
		};
	}
}
