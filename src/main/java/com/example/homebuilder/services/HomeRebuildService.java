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
        Random random = new Random();

        // Generate mock data and populate the map
        for (int i = 1; i <= 5; i++) {
            HomeRebuild homeRebuild = new HomeRebuild();

            homeRebuild.setHomeId(i);
            homeRebuild.setCritical(random.nextBoolean());
            homeRebuild.setSuccess(random.nextBoolean());
            homeRebuild.setStartTime("2023-09-27T" + String.format("%02d:%02d:%02d", random.nextInt(24), random.nextInt(60), random.nextInt(60)));
            homeRebuild.setEndTime("2023-09-28T" + String.format("%02d:%02d:%02d", random.nextInt(24), random.nextInt(60), random.nextInt(60)));

            homeRebuildMap.put(i, homeRebuild);
        }
    }


        public HomeRebuild getRebuild(int homeId) {
            return homeRebuildMap.get(homeId);
        }

}
