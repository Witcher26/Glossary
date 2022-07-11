package com.zvezdilin.Glossary.api;

import com.zvezdilin.Glossary.engine.Engine;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/engineController/v1/")
public class EngineController {
    private static MySingletonLogger myLogger = MySingletonLogger.getLogger();
    private static Engine engine;

    private EngineController() {
        engine = new Engine();
    }

    @PostMapping("startEngine")
    public String startEngine(@RequestBody String requestFromClientInJson) {
        String result = "";
        result = engine.start(requestFromClientInJson);
        myLogger.appendInfo("Attempt to start engine. Result: " + result);
        return result;
    }
}
