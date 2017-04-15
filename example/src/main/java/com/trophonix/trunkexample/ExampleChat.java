package com.trophonix.trunkexample;

import com.trophonix.trunk.api.chat.TrunkChat;

import java.util.UUID;

/**
 * Created by Lucas on 4/14/17.
 */
public class ExampleChat extends TrunkChat {

    private TrunkExample main;

    public ExampleChat(TrunkExample main) {
        super(main);
        this.main = main;
    }

    @Override
    public String getPrefix(UUID uniqueId) {
        return main.getConfig().getString(playerString(uniqueId, "prefix"), "");
    }

    @Override
    public void setPrefix(UUID uniqueId, String prefix) {
        main.getConfig().set(playerString(uniqueId, "prefix"), prefix);
    }

    @Override
    public String getSuffix(UUID uniqueId) {
        return main.getConfig().getString(playerString(uniqueId, "suffix"), "");
    }

    @Override
    public void setSuffix(UUID uniqueId, String suffix) {
        main.getConfig().set(playerString(uniqueId, "suffix"), suffix);
    }

    @Override
    public String getGroupPrefix(String group) {
        return main.getConfig().getString(groupString(group, "prefix"));
    }

    @Override
    public void setGroupPrefix(String group, String prefix) {
        main.getConfig().set(groupString(group, "prefix"), prefix);
    }

    @Override
    public String getGroupSuffix(String group) {
        return main.getConfig().getString(groupString(group, "suffix"));
    }

    @Override
    public void setGroupSuffix(String group, String suffix) {
        main.getConfig().set(groupString(group, "suffix"), suffix);
    }

    @Override
    public boolean getBooleanPlayerOption(String world, UUID uniqueId, String node, boolean defaultValue) {
        return false;
    }

    @Override
    public void setBooleanPlayerOption(String world, UUID uniqueId, String node, boolean value) {

    }

    @Override
    public int getIntegerPlayerOption(String world, UUID uniqueId, String node, int defaultValue) {
        return 0;
    }

    @Override
    public void setIntegerPlayerOption(String world, UUID uniqueId, String node, int value) {

    }

    @Override
    public double getDoublePlayerOption(String world, UUID uniqueId, String node, double defaultValue) {
        return 0;
    }

    @Override
    public void setDoublePlayerOption(String world, UUID uniqueId, String node, double value) {

    }

    @Override
    public String getStringPlayerOption(String world, UUID uniqueId, String node, String defaultValue) {
        return "";
    }

    @Override
    public void setStringPlayerOption(String world, UUID uniqueId, String node, String value) {

    }

    @Override
    public boolean getBooleanGroupOption(String world, String group, String node, boolean defaultValue) {
        return false;
    }

    @Override
    public void setBooleanGroupOption(String world, String group, String node, boolean value) {

    }

    @Override
    public int getIntegerGroupOption(String world, String group, String node, int defaultValue) {
        return 0;
    }

    @Override
    public void setIntegerGroupOption(String world, String group, String node, int value) {

    }

    @Override
    public double getDoubleGroupOption(String world, String group, String node, double defaultValue) {
        return 0;
    }

    @Override
    public void setDoubleGroupOption(String world, String group, String node, double value) {

    }

    @Override
    public String getStringGroupOption(String world, String group, String node, String defaultValue) {
        return "";
    }

    @Override
    public void setStringGroupOption(String world, String group, String node, String value) {

    }

    private static String playerString(UUID uniqueId, String node) {
        return "permissions.players." + uniqueId.toString() + "." + node;
    }

    private static String groupString(String group, String node) {
        return "permissions.groups." + group + "." + node;
    }

}
