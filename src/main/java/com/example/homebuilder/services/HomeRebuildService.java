package com.example.homebuilder.services;

import com.example.homebuilder.models.HomeRebuild;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class HomeRebuildService {

        private static final Map<Integer, HomeRebuild> homeRebuildMap = new HashMap<>();


        static {
            homeRebuildMap.put(1, new HomeRebuild(1,true,true,"2023-09-28T10:00:00Z","2023-09-28T14:30:00Z"));
            homeRebuildMap.put(1, new HomeRebuild(2,true,true,"2023-09-29T15:45:00Z","2023-09-29T18:20:00Z"));
            homeRebuildMap.put(1, new HomeRebuild(3,true,true,"2023-09-30T08:15:00Z","2023-09-30T11:00:00Z"));
            homeRebuildMap.put(1, new HomeRebuild(4,true,true,"2023-10-01T13:30:00Z","2023-10-01T17:00:00Z"));
            homeRebuildMap.put(1, new HomeRebuild(5,true,true,"2023-10-02T09:45:00Z","2023-10-02T12:10:00Z"));
        }

        public HomeRebuild getRebuild(int homeId) {
            return homeRebuildMap.get(homeId);
        }

}
