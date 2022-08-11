package io.whitford.timetracker.repositories;

import io.whitford.timetracker.models.TaskMeasurement;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

@org.springframework.stereotype.Repository
public interface TrackerRepository extends Repository<TaskMeasurement, String> {

    @Query("INSERT INTO devicemeasurement (deviceuid, duration, time) VALUES (:uid, :duration, now())")
    @Modifying
    void save(@Param("uid") String deviceId, @Param("duration") long duration);

    @Query("select avg(duration) from devicemeasurement where deviceuid = :uid")
    double getAverage(@Param("uid") String deviceId);
}
