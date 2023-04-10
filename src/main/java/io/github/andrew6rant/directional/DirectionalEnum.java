package io.github.andrew6rant.directional;

import net.minecraft.util.StringIdentifiable;

public enum DirectionalEnum implements StringIdentifiable {
    // yes, I know prefixing with _ is bad practice, but I want my variable names to be the angles of the models
    _0("0"),
    _22_5("22_5"),
    _45("45"),
    _67_5("67_5"); // yes, I know that the actual angle is -22.5

    private final String name;

    private DirectionalEnum(String name) {
        this.name = name;
    }

    public String toString() {
        return this.asString();
    }

    public String asString() {
        return this.name;
    }
}
