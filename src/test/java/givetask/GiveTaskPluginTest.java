package givetask;

import com.givetask.GiveTaskPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class GiveTaskPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(GiveTaskPlugin.class);
		RuneLite.main(args);
	}
}