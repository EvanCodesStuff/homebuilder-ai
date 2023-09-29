package com.example.homebuilder.controller;

import com.example.homebuilder.models.ChatRequest;
import com.example.homebuilder.models.ChatResponse;
import com.example.homebuilder.properties.HomeBuilderProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChatController {
    @Autowired
    private HomeBuilderProps homeBuilderProps;

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    private String system = "Hey friend, I would like you be a digital assistant to provide information to customers about my application. \n" +
            "The app allows you to query for home rebuild events. Please be concise in your responses.\n" +
            "\n" +
            "API endpoints:\n" +
            "\n" +
            "- History of the House. Knowing that the house was built. This api enriches the rebuild_status api.\n" +
            "METHOD: GET \n" +
            "PATH: /${HOME_ID}/inventory\n" +
            "HomeInventory:\n" +
            "{\n" +
            "\thomeId : String,\n" +
            "\tlocation: String,\n" +
            "\tinsuranceCompanyName: String,\n" +
            "\tfamily: String\n" +
            "}\n" +
            "\n" +
            "- Give you information on a rebuild that has happened\n" +
            "METHOD: GET\n" +
            "PATH: /${HOME_ID}/rebuild_status/\n" +
            "HomeRebuild:\n" +
            "[ {\n" +
            "\tisCritical: boolean,\n" +
            "\thomeId : String,\n" +
            "\tsuccess: boolean,\n" +
            "\tstartTimestamp: String, // ISO-8601 format\n" +
            "\tendTimestamp: String, // ISO-8601 format\n" +
            "}]\n" +
            "\n" +
            "- gives information on a dogs that may belong to a certain family\n" +
            "METHOD: GET\n" +
            "PATH: /{FAMILY}/dogFinding\n" +
            "DawgModel:\n" +
            "[ {\n" +
            "    name:String,\n" +
            "    gender:String,\n" +
            "    breed:String,\n" +
            "    size:String,\n" +
            "    colour:String,\n" +
            "    family:String,\n" +
            "}]\n" +
            "\n" +
            "CurrentData:\n" +
            "\n" +
            "    -Mock Home rebuild data\n" +
            "    static {\n" +
            "        homeRebuildMap.put(1, new HomeRebuild(1,false,false,\"2023-09-28T10:00:00Z\",\"2023-09-28T14:30:00Z\"));\n" +
            "        homeRebuildMap.put(1, new HomeRebuild(2,true,true,\"2023-09-29T15:45:00Z\",\"2023-09-29T18:20:00Z\"));\n" +
            "        homeRebuildMap.put(1, new HomeRebuild(3,true,false,\"2023-09-30T08:15:00Z\",\"2023-09-30T11:00:00Z\"));\n" +
            "        homeRebuildMap.put(1, new HomeRebuild(4,false,true,\"2023-10-01T13:30:00Z\",\"2023-10-01T17:00:00Z\"));\n" +
            "        homeRebuildMap.put(1, new HomeRebuild(5,true,true,\"2023-10-02T09:45:00Z\",\"2023-10-02T12:10:00Z\"));\n" +
            "    }\n" +
            "    \n" +
            "    -Mock home inventory data\n" +
            "    static {\n" +
            "        homeInventoryMap.put(1, new HomeInventory(1, \"123 Main St\", \"ABC Insurance\", \"Smith Family\"));\n" +
            "        homeInventoryMap.put(2, new HomeInventory(2, \"456 Oak Ave\", \"XYZ Insurance\", \"Johnson Family\"));\n" +
            "        homeInventoryMap.put(3, new HomeInventory(3, \"789 Pine Rd\", \"DEF Insurance\", \"Brown Family\"));\n" +
            "        homeInventoryMap.put(4, new HomeInventory(4, \"101 Elm Blvd\", \"GHI Insurance\", \"Davis Family\"));\n" +
            "        homeInventoryMap.put(5, new HomeInventory(5, \"202 Cedar Ct\", \"JKL Insurance\", \"Wilson Family\"));\n" +
            "    }\n" +
            "\n" +
            "    -Mock dog data\n" +
            "    static {\n" +
            "\n" +
            "        dawgServiceMap.put(\"1\", new DawgModel(\"Fido\", \"Male\", \"Golden Retriever\", \"Small\", \"Yellow\", \"Smith Family\"));\n" +
            "        dawgServiceMap.put(\"2\", new DawgModel(\"Snoopy\",\"Male\",\"Beagle\",\"Small\",\"White\",\"Johnson Family\"));\n" +
            "        dawgServiceMap.put(\"3\", new DawgModel(\"Hamlet\",\"Female\",\"Labrador\",\"Medium\",\"Yellow\",\"Brown Family\"));\n" +
            "        dawgServiceMap.put(\"4\", new DawgModel(\"Bridgette\",\"Female\",\"Poodle\",\"Large\",\"White\",\"Davis Family\"));\n" +
            "        dawgServiceMap.put(\"5\", new DawgModel(\"Trevor\",\"Male\",\"Maltese\",\"Small\",\"Gray\",\"Wilson Family\"));\n" +
            "    } ";

    @GetMapping("/chat")//TODO step 3 create UI interface for chat bot
    public String chat(@RequestParam String prompt) {
        // create a request
        System.out.println(prompt);
        ChatRequest request = new ChatRequest(model, prompt,system);
        request.setN(1);

        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        // return the first response
        return response.getChoices().get(0).getMessage().getContent();
    }
}
