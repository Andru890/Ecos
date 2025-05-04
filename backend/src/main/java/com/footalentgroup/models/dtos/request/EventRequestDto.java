package com.footalentgroup.models.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventRequestDto {

    private String name;
    private String category;
    private LocalDateTime date;
    private String location;
    private String description;
    private String image;
    private Boolean active;
    private Long organizerId;

}
