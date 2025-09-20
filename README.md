  █████████     ███████    █████       █████  █████ ███████████ █████    ███████    ██████   █████
 ███░░░░░███  ███░░░░░███ ░░███       ░░███  ░░███ ░█░░░███░░░█░░███   ███░░░░░███ ░░██████ ░░███ 
░███    ░░░  ███     ░░███ ░███        ░███   ░███ ░   ░███  ░  ░███  ███     ░░███ ░███░███ ░███ 
░░█████████ ░███      ░███ ░███        ░███   ░███     ░███     ░███ ░███      ░███ ░███░░███░███ 
 ░░░░░░░░███░███      ░███ ░███        ░███   ░███     ░███     ░███ ░███      ░███ ░███ ░░██████ 
 ███    ░███░░███     ███  ░███      █ ░███   ░███     ░███     ░███ ░░███     ███  ░███  ░░█████ 
░░█████████  ░░░███████░   ███████████ ░░████████      █████    █████ ░░░███████░   █████  ░░█████
 ░░░░░░░░░     ░░░░░░░    ░░░░░░░░░░░   ░░░░░░░░      ░░░░░    ░░░░░    ░░░░░░░    ░░░░░    ░░░░░ 
                                                                                                  
                                                                                                  
                                                                                                  
 ███████████   █████████   ███████████     █████████     ███████    ██████   █████                
░█░░░░░░███   ███░░░░░███ ░░███░░░░░███   ███░░░░░███  ███░░░░░███ ░░██████ ░░███                 
░     ███░   ░███    ░███  ░███    ░███  ███     ░░░  ███     ░░███ ░███░███ ░███                 
     ███     ░███████████  ░██████████  ░███         ░███      ░███ ░███░░███░███                 
    ███      ░███░░░░░███  ░███░░░░░███ ░███    █████░███      ░███ ░███ ░░██████                 
  ████     █ ░███    ░███  ░███    ░███ ░░███  ░░███ ░░███     ███  ░███  ░░█████                 
 ███████████ █████   █████ █████   █████ ░░█████████  ░░░███████░   █████  ░░█████                
░░░░░░░░░░░ ░░░░░   ░░░░░ ░░░░░   ░░░░░   ░░░░░░░░░     ░░░░░░░    ░░░░░    ░░░░░     


# (WIP)
<p>Solution Zargon is a text based adventure game being built with JAVA where you are a scavenger running missions between two planets using space station zargon as a mid-point. Caught between the words of rich and poor you struggle to stay out of conflict.</p>
<i>WIP = Work in Progress</i>

## Progress
### System functions
* Prolouge ✓ - Add fast-forward and skip / escape 
* Saved Game Loading - WIP - started prototype from txt file but have since migrated over to item and action classes.
  * Load room history, room actions etc
  * Load item class history
  * Load npc history
* Inventory
  * Pickup ✓
  * Drop ✓
  * Use (WIP) - tied into room actions
* Rooms (WIP)
  * Create rooms parent class ✓
  * Create individual room classes with actions ✓
  * Create Game Map to tie together room exists ✓
* NPC (WIP)
  * Create NPC inventory/store 
  * Create NPC actions ✓
  * Create Game Map to tie together room exists ✓


  ## Story



  ## How to play
  from the zargon folder with the pom.xml run
  `mvn clean package`
  cd into targer

  for testing run:
  `java -cp zargon-1.0-SNAPSHOT.jar com.zargon.Main`

  to run the actual file
  `java -jar zargon-1.0-SNAPSHOT.jar`


  ## Whats Working
  Prolouge, You can read the story 
  First Room, Spaceship - You have docked at the Zargon space station ready to unload and refuel.
  Inventory - you can look, grab, drop items.
  
  NOTE: This is WIP and only has the first room as I enginner the framework.

  look
  take / grab
  inventory / inv
  show exits / exists
  go north, go south, go east, go west  | n,s,e,w

  exit - quit the game
  save (not working)