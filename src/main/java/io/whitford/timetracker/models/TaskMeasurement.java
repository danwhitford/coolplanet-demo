package io.whitford.timetracker.models;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("devicemeasurement")
public class TaskMeasurement {
    private String deviceuid;
    private long duration;
    private LocalDateTime time;
}
