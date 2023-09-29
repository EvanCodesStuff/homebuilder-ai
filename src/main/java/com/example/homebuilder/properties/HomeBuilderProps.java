package com.example.homebuilder.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@ConfigurationProperties(prefix = "home")
@Component
public class HomeBuilderProps {

    private String role;
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
            "    } "; //todo Step1: Update with system role with our apps info and an objective for the AI

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

}
