package com.nexoria.coins;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(NexoriaCoins.MODID)
public class NexoriaCoins {

    public static final String MODID = "nexoriacoins";

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> NEXORIA_COIN =
            ITEMS.registerSimpleItem("nexoria_coin", p -> p.stacksTo(64));

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> NEXORIA_TAB =
            TABS.register("nexoria_tab", () -> CreativeModeTab.builder()
                    .title(Component.literal("NEXORIA COINS"))
                    .icon(() -> NEXORIA_COIN.get().getDefaultInstance())
                    .displayItems((parameters, output) ->
                            output.accept(NEXORIA_COIN.get()))
                    .build());

    public NexoriaCoins(IEventBus modEventBus, ModContainer modContainer) {
        ITEMS.register(modEventBus);
        TABS.register(modEventBus);
    }
                       }
