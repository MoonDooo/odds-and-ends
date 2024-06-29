package com.ikw.cuttingVideo.service;

import com.ikw.cuttingVideo.controller.dto.TimeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class CuttingVideoDto extends VideoDto{
    TimeDto start;
    TimeDto end;
    String output;

    @Builder
    public CuttingVideoDto(TimeDto start, TimeDto end, String output, String input) {
        super(input);
        this.start = start;
        this.end = end;
        this.output = output;
    }
}
