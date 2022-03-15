package io.github.nexusdino.lifeofnexus.core.util;

import java.util.function.Supplier;

import net.minecraftforge.network.NetworkEvent;

public interface IPacket {
	boolean handle(Supplier<NetworkEvent.Context> context);
}
