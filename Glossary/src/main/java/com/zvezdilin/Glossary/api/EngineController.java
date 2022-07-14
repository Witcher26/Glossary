package com.zvezdilin.Glossary.api;

import com.zvezdilin.Glossary.engine.Engine;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/engineController/v1/")
public class EngineController {
    private static MySingletonLogger myLogger = MySingletonLogger.getLogger();
    private static Engine engine;

    private EngineController() {
        engine = new Engine();
    }

    @Operation(
            summary = "методы добавления, удаления слов и их вывода"
    )
    @Schema(description = "json-строка", example = "{ \"target\": \"ADD\", " +
            "\"word\": \"unit\", " +
            "\"translation\": \"единица измерения\", " +
            "\"locale\": \"EN\"" +
            "}" +
            "OR" +
            "{ \"target\": \"REMOVE\", " +
            "\"word\": \"unit\"" +
            "}" +
            "OR" +
            "{ \"target\": \"GETALLTASKS\" " +
            "}"
    )
    @PostMapping("startEngine")
    public String startEngine(@RequestBody String requestFromClientInJson) {
        String result = "";
        result = engine.start(requestFromClientInJson);
        myLogger.appendInfo("Attempt to start engine. Result: " + result);
        return result;
    }
}
