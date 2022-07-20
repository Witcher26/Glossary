package com.zvezdilin.Glossary.api;

import com.zvezdilin.Glossary.engine.Engine;
import io.swagger.v3.oas.annotations.Operation;
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
            summary = "методы добавления, удаления слов и их вывода в режиме одного окна"
    )
    @PostMapping("startEngine")
    public String startEngine(@RequestBody String requestFromClientInJson) {
        String result = "";
        result = engine.start(requestFromClientInJson);
        myLogger.appendInfo("Attempt to start engine. Result: " + result);
        return result;
    }
}
