package com.givetask;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
	name = "Give Task"
)
public class GiveTaskPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private GiveTaskConfig config;

	private static final String NEW_TASK = "new task:";
	private String taskString = "";

	@Override
	protected void startUp() throws Exception
	{
//		log.info("Give Task started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
//		log.info("Give Task stopped!");
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage){

		MessageNode messageNode = chatMessage.getMessageNode();
		String message = messageNode.getValue();
		message = message.toLowerCase();
		if(message.startsWith(NEW_TASK)
				&& messageNode.getType().equals(ChatMessageType.PUBLICCHAT)){
				taskString = message.replaceFirst(NEW_TASK, "");
		}
	}

	public String getTaskString(){
		return this.taskString;
	}

	@Provides
    GiveTaskConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GiveTaskConfig.class);
	}
}
