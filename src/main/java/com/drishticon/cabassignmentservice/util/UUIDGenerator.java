package com.drishticon.cabassignmentservice.util;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;

import java.util.UUID;

public class UUIDGenerator {
    static {
        timeBasedGenerator = Generators.timeBasedGenerator();
    }

    private static NoArgGenerator timeBasedGenerator;

    private UUIDGenerator() {
    }

    public static UUID generate() {
        return timeBasedGenerator.generate();
    }
}
