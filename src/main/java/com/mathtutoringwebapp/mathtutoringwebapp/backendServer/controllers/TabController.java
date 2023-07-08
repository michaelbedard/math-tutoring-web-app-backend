package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.controllers;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.config.security.UserJwtTokenAuthProvider;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Highlight;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Star;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.User;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.HighlightDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers.HighlightMapper;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers.StarMapper;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services.HighlightService;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services.StarService;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.StarDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/tab")
public class TabController {
    @Autowired
    private UserJwtTokenAuthProvider userJwtTokenAuthProvider;
    @Autowired
    private StarService starService;
    @Autowired
    private HighlightService highlightService;
    @Autowired
    private HighlightMapper highlightMapper;
    @Autowired
    private StarMapper starMapper;

    @GetMapping("/star")
    public ResponseEntity<Iterable<StarDto>> getUserStar(
            HttpServletRequest request) {

        //User user = userJwtTokenAuthProvider.getAuthenticatedUser(request);
        User user = userService.findById(1L);
        List<Star> starList = starService.getAll(user);
        List<StarDto> starDtoList = starMapper.toStarDtoList(starList);

        return ResponseEntity.ok(starDtoList);
    }

    @GetMapping("/highlight/{tabKey}")
    public ResponseEntity<Iterable<HighlightDto>> getUserHighlight(
            HttpServletRequest request,
            @PathVariable int tabKey) {

        //User user = userJwtTokenAuthProvider.getAuthenticatedUser(request);
        User user = userService.findById(1L);
        List<Highlight> highlightList = highlightService.getHighlightsFromTabKey(tabKey, user);
        List<HighlightDto> highlightDtoList = highlightMapper.toHighlightDtoList(highlightList);

        return ResponseEntity.ok(highlightDtoList);
    }

    @Autowired
    UserService userService;

    @PutMapping("/star")
    public ResponseEntity<String> alterTabStar(
            HttpServletRequest request,
            @RequestBody StarDto starDto) {

        //User user = userJwtTokenAuthProvider.getAuthenticatedUser(request);
        User user = userService.findById(1L);
        starService.alterStar(starDto.getTabKey(), starDto.isStarFlag(), user);

        return ResponseEntity.ok("Star value has been updated successfully");
    }

    @PutMapping("/highlight/{tabKey}")
    public void alterHighlightTexts(HttpServletRequest request,
                                              @PathVariable int tabKey,
                                              @RequestBody List<HighlightDto> highlightDtoList) {

        //User user = userJwtTokenAuthProvider.getAuthenticatedUser(request);
        User user = userService.findById(1L);
        List<Highlight> highlightList = highlightService.getHighlightsFromTabKey(tabKey, user);

        for (Highlight highlight : highlightList) {
            highlightService.deleteHighlight(highlight);
        }
        for (HighlightDto highlightDto : highlightDtoList) {
            Highlight highlight = highlightMapper.toHighlight(highlightDto);
            highlightService.saveHighlight(highlight, tabKey, user);
        }
    }
}
