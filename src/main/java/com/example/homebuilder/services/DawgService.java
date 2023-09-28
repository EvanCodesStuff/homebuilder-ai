package com.example.homebuilder.services;

import com.example.homebuilder.models.DawgModel;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class DawgService {

    private static final Map<String, DawgModel> dawgServiceMap = new HashMap<>();

    static {
        // Mock Dog Data
        dawgServiceMap.put("Smith", new DawgModel("Fido", "Male", "Golden Retriever", "Small", "Yellow", "Smith Family"));
        dawgServiceMap.put("Johnson", new DawgModel("Snoopy","Male","Beagle","Small","White","Johnson Family"));
        dawgServiceMap.put("Brown", new DawgModel("Hamlet","Female","Labrador","Medium","Yellow","Brown Family"));
        dawgServiceMap.put("Davis", new DawgModel("Bridgette","Female","Poodle","Large","White","Davis Family"));
        dawgServiceMap.put("Wilson", new DawgModel("Trevor","Male","Maltese","Small","Gray","Wilson Family"));
    }

    public DawgModel getDawgModel(String family) {
        return dawgServiceMap.get(family);
    }

}
