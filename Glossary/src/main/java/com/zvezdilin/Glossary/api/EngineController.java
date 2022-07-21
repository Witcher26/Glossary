package com.zvezdilin.Glossary.api;

import com.zvezdilin.Glossary.engine.Engine;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

@Tag(name = "Engine controller", description = "контроллер взаимодействия с хранилищем")
@RestController
@RequestMapping(value = "api/engineController/v1/")
public class EngineController {
    private static MySingletonLogger myLogger = MySingletonLogger.getLogger();
    private static Engine engine;

    private EngineController() {
        engine = new Engine();
    }

    @Operation(
            summary = "Метод добавления слова, удаления слова, вывод всех слов "
    )
    @PostMapping("startEngine")
    public String startEngine(@Parameter(description = "ADD - добавление слова, REMOVE - удаление слова, GETALLTASKS - вывод всех слов",
            required=true, schema=@Schema(allowableValues={ "{\"target\":\"ADD\",\"word\":\"test\",\"translation\":\"тестовое слово для проверки\",\"locale\":\"EN\"}",
            "{\"target\":\"REMOVE\",\"word\":\"test\"}", "{\"target\":\"GETALLTASKS\"}" })) @RequestBody String requestFromClientInJson) {
        String result = "";
        result = engine.start(requestFromClientInJson);
        myLogger.appendInfo("Attempt to start engine. Result: " + result);
        return result;
    }
}


