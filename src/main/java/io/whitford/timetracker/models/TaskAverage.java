package io.whitford.timetracker.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TaskAverage {
    String deviceId;
    double average;
}
