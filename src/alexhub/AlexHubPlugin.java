package alexhub;

import arc.Events;
import arc.util.CommandHandler;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.gen.Call;
import mindustry.gen.Player;
import mindustry.mod.Plugin;

public class AlexHubPlugin extends Plugin{
    //called when game initializes
    @Override
    public void init(){
        Config.main();
        Events.on(EventType.ServerLoadEvent.class, event -> {
            Vars.netServer.admins.addActionFilter(playerAction -> false);
            Call.label(ConfigTranslate.get("server1.title"), 1100f, 25f, 25f);
        });
    }

    //register commands that player can invoke in-game
    @Override
    public void registerClientCommands(CommandHandler handler){

        //register a simple reply command
        handler.<Player>register("reply25", "<text...>", "A simple ping command that echoes a player's text.", (args, player) -> {
            player.sendMessage("You said: [accent] " + args[0]);
        });
        //register a simple reply command
        handler.<Player>register("survival", "<text...>", "command to jump to survival.", (args, player) -> {
            player.sendMessage("You said: [accent] " + args[0]);
            Call.connect(player.con,"alexmindustry.ddns.net",6569);
        });
        handler.<Player>register("pvp", "<text...>", "command to jump to survival.", (args, player) -> {
            player.sendMessage("You said: [accent] " + args[0]);
            Call.connect(player.con,"http://alexmindustry.ddns.net",6568);
        });


    }
}
