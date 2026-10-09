package ariol.nylers.asbcore.core.island.services.region.configurator;

import ariol.nylers.asbcore.core.island.members.Member;
import ariol.nylers.asbcore.core.island.members.Membership;
import ariol.nylers.asbcore.core.profile.ProfileId;
import ariol.nylers.asbcore.core.profile.services.MetaProfileProvider;
import com.sk89q.worldguard.domains.DefaultDomain;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.RegionGroup;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import java.util.Optional;
import java.util.UUID;

public class FlagPrivateConfigurator implements PrivateConfigurator<RegionWithMembership> {

    private final MetaProfileProvider metaProfileProvider;

    public FlagPrivateConfigurator(MetaProfileProvider metaProfileProvider) {
        this.metaProfileProvider = metaProfileProvider;
    }


    @Override
    public void configure(RegionWithMembership regionWithMembership) {
        addMembers(regionWithMembership.region(), regionWithMembership.membership());
        configureFlags(regionWithMembership.region());
    }

    private void addMembers(ProtectedRegion region, Membership membership){
        DefaultDomain domain = new DefaultDomain();
        for (Member member : membership.getMembers()){
            ProfileId profileId = member.getProfileId();
            Optional<UUID> playerId = metaProfileProvider.getPlayerId(profileId);
            playerId.ifPresent(domain::addPlayer);
        }

        region.setMembers(domain);
    }

    private void configureFlags(ProtectedRegion region){
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
}
