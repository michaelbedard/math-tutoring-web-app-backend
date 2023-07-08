package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HighlightDto {

    private int startOffset;
    private int endOffset;
    private String style;
}

