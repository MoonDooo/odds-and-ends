package com.ikw.cuttingVideo.controller;

import com.ikw.cuttingVideo.controller.dto.TimeDto;
import com.ikw.cuttingVideo.service.VideoCuttingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class VideCuttingController {
    private final VideoCuttingService videoCuttingService;
    @PostMapping("/cuttingFileMyVideo")
    public String cuttingFileMyVideo(
            @RequestParam("inputFile")String inputFile,
            @RequestParam("outputFolder")String outputFolder,
            @RequestParam("startHours")int startHours,
            @RequestParam("startMinutes")int startMinutes,
            @RequestParam("startSeconds")int startSeconds,
            @RequestParam("endHours")int endHours,
            @RequestParam("endMinutes")int endMinutes,
            @RequestParam("endSeconds")int endSeconds
    ){
        TimeDto startTime = new TimeDto(startHours,startMinutes,startSeconds);
        TimeDto endTime = new TimeDto(endHours, endMinutes, endSeconds);

        boolean b = videoCuttingService.cuttingFileNoDownload(startTime, endTime, inputFile, outputFolder);

        return "folderForm";
    }
}
