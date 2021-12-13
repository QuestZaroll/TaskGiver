package com.givetask;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

public class TaskOverlay extends OverlayPanel {

    private final Client client;
    private final GiveTaskPlugin plugin;
    @Inject
    private GiveTaskConfig config;

    @Inject
    private TaskOverlay(Client client, GiveTaskPlugin plugin){
        super(plugin);
            setPosition(OverlayPosition.BOTTOM_LEFT);
        this.client = client;
        this.plugin = plugin;
        getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Task overlay"
        ));
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        String task = "Current Task: " + config.currentTask();

        if(config.overlay()){
            panelComponent.getChildren().add(LineComponent.builder()
                    .left(task)
                    .leftColor(Color.GREEN)
                    .build());

//            panelComponent.getChildren().add(TitleComponent.builder()
//                    .text("Current Task: " + plugin.getTaskString())
//                    .color(Color.GREEN)
//                    .build()
//            );

            panelComponent.setPreferredSize(new Dimension(
                    graphics.getFontMetrics().stringWidth(task) + 10,
                    0));
        }


        return super.render(graphics);
    }


}
