package ariol.nylers.asbcore.core.pos;

import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Location;

public class IslandLocalLocation {

    @Getter private Location origin;

    @Getter private double localX;
    @Getter private double localY;
    @Getter private double localZ;

    @Getter private double worldX;
    @Getter private double worldY;
    @Getter private double worldZ;


    public IslandLocalLocation(Location origin, double localX, double localY, double localZ){
        this.origin = origin;

        setLocalXYZ(localX, localY ,localZ);
    }


    public void setLocalX(double x){
        localX = x;
        worldX = origin.getX()+localX;
    }

    public void setLocalY(double y){
        localY = y;
        worldY = origin.getY()+localY;
    }

    public void setLocalZ(double z){
        localZ = z;
        worldZ = origin.getZ()+localZ;
    }

    public void setLocalXYZ(double x, double y, double z){
        setLocalX(x);
        setLocalY(y);
        setLocalZ(z);
    }


    public void setWorldX(double x){
        worldX = x;
        localX = worldX-origin.getX();
    }

    public void setWorldY(double y){
        worldY = y;
        localY = worldY-origin.getY();
    }

    public void setWorldZ(double z){
        worldZ = z;
        localZ = worldZ-origin.getZ();
    }

    public void setWorldXYZ(double x, double y, double z){
        setWorldX(x);
        setWorldY(y);
        setWorldZ(z);
    }


    public void setOrigin(@NonNull Location origin) {
        this.origin = origin;
        syncWorldPosByLocal();
    }


    public Location getLocalLocation(){
        return new Location(origin.getWorld(), localX, localY, localZ);
    }

    public Location getWorldLocation(){
        return new Location(origin.getWorld(), worldX, worldY, worldZ);
    }


    private void syncWorldPosByLocal(){
        worldX = origin.getX() + localX;
        worldY = origin.getY() + localY;
        worldZ = origin.getZ() + localZ;
    }
}
