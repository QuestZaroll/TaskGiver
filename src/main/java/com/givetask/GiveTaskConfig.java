package com.givetask;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface GiveTaskConfig extends Config
{
	@ConfigItem(
			keyName = "Give Task",
			name = "",
			description = "The current task"
	)
	default boolean overlay()
	{
		return false;
	}
}
