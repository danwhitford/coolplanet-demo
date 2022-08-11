package io.whitford.timetracker.controllers;

import io.whitford.timetracker.models.TaskAverage;
import io.whitford.timetracker.repositories.TrackerRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracker")
public class TrackerController {
    TrackerRepository repository;

    public TrackerController(TrackerRepository repository) {
        this.repository = repository;
    }

    @PutMapping("/{deviceUid}")
    void putMeasurement(@PathVariable(value="deviceUid") String deviceUid, @RequestParam Long duration) {
        repository.save(deviceUid, duration);
    }

    @GetMapping(value = "/{deviceUid}", produces = MediaType.APPLICATION_JSON_VALUE)
    TaskAverage getAverageMeasurement(@PathVariable(value="deviceUid") String deviceUid) {
        var avg = repository.getAverage(deviceUid);
        return TaskAverage.builder().deviceId(deviceUid).average(avg).build();
    }
}
