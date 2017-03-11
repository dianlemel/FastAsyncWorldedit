package com.boydti.fawe.object.pattern;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.function.pattern.AbstractPattern;
import com.sk89q.worldedit.function.pattern.Pattern;
import java.util.Arrays;
import java.util.Collection;

public class LinearBlockPattern extends AbstractPattern implements ResettablePattern {

    private final Collection<Pattern> patterns;
    private final Pattern[] patternsArray;
    private int index;

    public LinearBlockPattern(Pattern[] patterns) {
        this.patternsArray = patterns;
        this.patterns = Arrays.asList(patterns);
    }

    @Override
    public BaseBlock apply(Vector position) {
        if (index == patternsArray.length) {
            index = 0;
        }
        return patternsArray[index++].apply(position);
    }

    @Override
    public boolean apply(Extent extent, Vector position) throws WorldEditException {
        if (index == patternsArray.length) {
            index = 0;
        }
        return patternsArray[index++].apply(extent, position);
    }

    @Override
    public void reset() {
        index = 0;
    }
}
