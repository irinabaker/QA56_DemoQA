package com.demoqa.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MyArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                arguments("Jamal Musiala","jamal@gm.com","Berlin"),
                arguments("Jamal Musiala","ja@gm.com","Berlin"),
                arguments("Jamal Musiala","jamallllllllllllllllllllllllllllllllllllllll@gm.com","Berlin")
        );
    }
}
