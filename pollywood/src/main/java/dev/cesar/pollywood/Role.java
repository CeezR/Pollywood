package dev.cesar.pollywood;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Role {
    SYSTEM("system"),
    USER("user");

    private final String type;

    Role(String type) {
        this.type = type;
    }

    @JsonCreator
    public static Role fromType(String type) {
        for (Role role : Role.values()) {
            if (role.type.equalsIgnoreCase(type)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid Role: " + type);
    }


}
