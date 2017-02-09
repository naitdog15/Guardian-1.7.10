A small code dump for gany or anyone of the Minecraft 1.7 modding community. Solving small issue with placement of the Guardian mob in 1.7.10.

Render and modeling seem fit for 1.7 algorithm. Behaviour out of water also seem to work fine. Issues include: I assume the BoundingBox() method to cause the mob to swim downward when reaching the surface is invalid. Mob does not hover from distance and exicute Guardian Beam on the hostility of the player. No elder chance. Mob can not move on the Y axis. (swim up and down to required target).

I've pretty much copied the majority of 1.8 code, changing the code where nessessary and adding extenders to help with additional code required.

If anyone can figure out solutions to these problems, please do let me know. And gany thankyou for taking a look if this is you.
