package com.drishticon.cabassignmentservice.util;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;

import java.util.UUID;

public class UuidGenerator {
    static {
        timeBasedGenerator = Generators.timeBasedGenerator();
    }

    private static NoArgGenerator timeBasedGenerator;

    private UuidGenerator() {
    }

    public static UUID generate() {
        return timeBasedGenerator.generate();
    }
}
