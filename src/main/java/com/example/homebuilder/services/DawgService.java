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
        dawgServiceMap.put("1", new DawgModel("Fido", "Male", "Golden Retriever", "Small", "Yellow", "Smith Family"));
        dawgServiceMap.put("2", new DawgModel("Snoopy","Male","Beagle","Small","White","Johnson Family"));
        dawgServiceMap.put("3", new DawgModel("Hamlet","Female","Labrador","Medium","Yellow","Brown Family"));
        dawgServiceMap.put("4", new DawgModel("Bridgette","Female","Poodle","Large","White","Davis Family"));
        dawgServiceMap.put("5", new DawgModel("Trevor","Male","Maltese","Small","White","Wilson Family"));
    }

    public DawgModel getDawgModel(String family) {return dawgServiceMap.get(family); }
}
