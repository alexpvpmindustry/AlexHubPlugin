package alexhub;

import arc.util.CommandHandler;
import mindustry.gen.Player;
import mindustry.mod.Plugin;

public class AlexHubPlugin extends Plugin{

    //called when game initializes
    @Override
    public void init(){
    }

    //register commands that player can invoke in-game
    @Override
    public void registerClientCommands(CommandHandler handler){

        //register a simple reply command
        handler.<Player>register("reply25", "<text...>", "A simple ping command that echoes a player's text.", (args, player) -> {
            player.sendMessage("You said: [accent] " + args[0]);
        });

    }
}
