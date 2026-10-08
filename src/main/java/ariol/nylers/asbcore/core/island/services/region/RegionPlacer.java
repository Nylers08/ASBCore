package ariol.nylers.asbcore.core.island.services.region;

import ariol.nylers.asbcore.core.island.members.Member;
import ariol.nylers.asbcore.core.island.members.Membership;
import ariol.nylers.asbcore.core.island.region.IslandRegion;
import ariol.nylers.asbcore.core.utils.adapters.WorldEditAdapter;
import com.sk89q.worldguard.domains.DefaultDomain;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.RegionGroup;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class RegionPlacer {

    public void place(IslandRegion region, Membership membership){
        ProtectedRegion protectedRegion = WorldEditAdapter.adapt(region);

    }

    private void configure(ProtectedRegion region, Membership membership){

    }

    private void configureBaseFlags(ProtectedRegion region){
        region.setFlag(Flags.EXIT, StateFlag.State.DENY);
        region.setFlag(Flags.EXIT.getRegionGroupFlag(), RegionGroup.ALL);

        region.setFlag(Flags.ENDERPEARL, StateFlag.State.ALLOW);
        region.setFlag(Flags.ENDERPEARL.getRegionGroupFlag(), RegionGroup.ALL);

        region.setFlag(Flags.CHORUS_TELEPORT, StateFlag.State.ALLOW);
        region.setFlag(Flags.CHORUS_TELEPORT.getRegionGroupFlag(), RegionGroup.ALL);

        region.setFlag(Flags.BLOCK_PLACE, StateFlag.State.ALLOW);
        region.setFlag(Flags.BLOCK_PLACE.getRegionGroupFlag(), RegionGroup.MEMBERS);

        region.setFlag(Flags.BLOCK_BREAK, StateFlag.State.ALLOW);
        region.setFlag(Flags.BLOCK_BREAK.getRegionGroupFlag(), RegionGroup.MEMBERS);
    }

    private void configureMembersFlags(ProtectedRegion region, Membership membership){

    }

    private void configMemberFlags(ProtectedRegion region, Member member){
        DefaultDomain domain = new DefaultDomain();

    }
}
