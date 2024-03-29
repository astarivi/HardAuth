package com.astarivi.hardauth.player;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Stores PlayerSessions in a ConcurrentHashMap to serve as cache.
 */

public class PlayerStorage {
    private static ConcurrentHashMap<UUID, PlayerSession> playerStorage;

    public static void initialize(){
        playerStorage = new ConcurrentHashMap<>();
    }

    public static void addPlayerSession(PlayerSession playersession){
        playerStorage.put(playersession.getUUID(), playersession);
    }

    public static PlayerSession getPlayerSession(UUID uuid){
        try {
            return playerStorage.get(uuid);
        } catch (NullPointerException e){
            return null;
        }
        
    }

    public static void removePlayerSession(UUID uuid){
        try {
            playerStorage.remove(uuid);
        } catch (NullPointerException ignored){
        }
    }
}