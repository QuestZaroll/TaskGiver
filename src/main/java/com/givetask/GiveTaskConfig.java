package com.givetask;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("give_task")
public interface GiveTaskConfig extends Config
{
	@ConfigItem(
			position = 1,
			keyName = "overlay",
			name = "Task Overlay",
			description = "Display overlay of current task"
	)
	default boolean overlay()
	{
		return true;
	}
	@ConfigItem(
			position = 2,
			keyName = "currentTask",
			name = "Current Task",
			description = "Your current task"
	)
	default String currentTask(){
		return "";
	}
}
