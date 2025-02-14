package com.crschnick.pdxu.app.info.eu4;

import com.crschnick.pdxu.app.gui.game.GameImage;
import com.crschnick.pdxu.app.info.SavegameData;
import com.crschnick.pdxu.app.info.SimpleInfoComp;
import com.crschnick.pdxu.app.lang.PdxuI18n;
import com.crschnick.pdxu.io.node.Node;
import com.crschnick.pdxu.io.node.NodePointer;
import com.crschnick.pdxu.io.savegame.SavegameContent;
import javafx.scene.image.Image;

public class Eu4AchievementOkComp extends SimpleInfoComp {

    private boolean ironman;
    private boolean achievementOk;

    @Override
    public boolean requiresPlayer() {
        return false;
    }

    @Override
    protected Image getImage() {
        return GameImage.EU4_ICON_ACHIEVEMENT;
    }

    @Override
    protected boolean shouldShow() {
        return ironman;
    }

    @Override
    protected String getTooltip() {
        if (achievementOk) {
            return PdxuI18n.get("ACHIEVEMENT_ELIGIBLE");
        } else {
            return PdxuI18n.get("ACHIEVEMENT_INELIGIBLE");
        }
    }

    @Override
    protected String getDisplayValue() {
        return null;
    }

    @Override
    protected void init(SavegameContent content, SavegameData<?> data) {
        ironman = data.isIronman();
        achievementOk = NodePointer.builder().name("achievement_ok").build().getIfPresent(content.get())
                .map(Node::getBoolean)
                .orElse(false);
    }
}
