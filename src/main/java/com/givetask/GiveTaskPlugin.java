package com.givetask;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.io.IOException;

@Slf4j
@PluginDescriptor(
	name = "Give Task"
)
public class GiveTaskPlugin extends Plugin
{
	static final String CONFIG_GROUP = "give_task";
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Client client;

	@Inject
	private GiveTaskConfig config;

	@Inject TaskOverlay overlay;

	private static final String NEW_TASK = "new task:";
	private String taskString = "";

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
//		log.info("Give Task started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
//		log.info("Give Task stopped!");
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage){

		MessageNode messageNode = chatMessage.getMessageNode();
		String message = messageNode.getValue();
		message = message.toLowerCase();
		if(message.startsWith(NEW_TASK)
				&& (messageNode.getType().equals(ChatMessageType.PUBLICCHAT)
				|| messageNode.getType().equals(ChatMessageType.MODCHAT))){
				taskString = message.replaceFirst(NEW_TASK, "");



			log.info("task inputted: " + taskString);
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
