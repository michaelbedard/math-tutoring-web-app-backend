//package com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.highlightLogic;
//
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Highlight;
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Tab;
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.HighlightDto;
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services.TabService;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//
//public class HighlightLogic {
//    public static Set<Highlight> updateTabHighlights(Set<Highlight> currHighlights, HighlightDto highlightDto) {
//        int tabKey = highlightDto.getTabKey();
//
//        Set<Highlight> highlightsToAdd = new HashSet<>();
//        Highlight newHighlight;
//        String serializedRange;
//
//        String[] serializedRanges = highlightDto.getSerializedRange().split("-");
//        int startOffset = Integer.parseInt(serializedRanges[0]);
//        int endOffset = Integer.parseInt(serializedRanges[1]);
//
//        Iterator<Highlight> iterator = currHighlights.iterator();
//        while (iterator.hasNext()) {
//            Highlight highlight = iterator.next();
//            String[] currSerializedRanges = highlight.getSerializedRange().split("-");
//            int currStartOffset = Integer.parseInt(currSerializedRanges[0]);
//            int currEndOffset = Integer.parseInt(currSerializedRanges[1]);
//
//            if (currStartOffset <= startOffset && endOffset <= currEndOffset) { //completely inside
//                if (highlightDto.getStyle().equals("DELETE") || !highlight.getStyle().equals(highlightDto.getStyle())) {
//                    iterator.remove();
//                    highlightsToAdd = handleDelete(highlightsToAdd, highlight,
//                            currStartOffset, currEndOffset,
//                            startOffset, endOffset);
//
//                    serializedRange = String.format("%s-%s", currStartOffset, startOffset);
//                    newHighlight = new Highlight(tabKey, serializedRange, highlight.getStyle());
//                    highlightsToAdd.add(newHighlight);
//
//                    serializedRange = String.format("%s-%s", endOffset, currEndOffset);
//                    newHighlight = new Highlight(tabKey, serializedRange, highlight.getStyle());
//                    highlightsToAdd.add(newHighlight);
//                } else {
//                    return currHighlights; //stop completely
//                }
//            } else if (startOffset <= currStartOffset && currEndOffset <= endOffset) { //completely outside
//                iterator.remove();
//            } else if (currStartOffset <= startOffset && startOffset <= currEndOffset) { //extends right
//                if (highlightDto.getStyle().equals("DELETE") || !highlight.getStyle().equals(highlightDto.getStyle())) {
//                    iterator.remove();
//                    highlightsToAdd = handleDelete(highlightsToAdd, highlight,
//                            currStartOffset, currEndOffset,
//                            startOffset, currEndOffset);
//                } else {
//                    iterator.remove();
//                    startOffset = currStartOffset;
//                }
//            } else if (currStartOffset <= endOffset && endOffset <= currEndOffset) { //extends left
//                if (highlightDto.getStyle().equals("DELETE") || !highlight.getStyle().equals(highlightDto.getStyle())) {
//                    iterator.remove();
//                    highlightsToAdd = handleDelete(highlightsToAdd, highlight,
//                            currStartOffset, currEndOffset,
//                            currStartOffset, endOffset);
//                } else {
//                    iterator.remove();
//                    endOffset = currEndOffset;
//                }
//            }
//        }
//
//        // finally add the modified range
//        if (!highlightDto.getStyle().equals("DELETE")) {
//            serializedRange = String.format("%s-%s", startOffset, endOffset);
//            highlightsToAdd.add(new Highlight(tabKey, serializedRange, highlightDto.getStyle()));
//        }
//
//        currHighlights.addAll(highlightsToAdd);
//        return currHighlights;
//    }
//
//    private static Set<Highlight> handleDelete(Set<Highlight> highlightsToAdd, Highlight highlight,
//                                               int currStartOffset, int currEndOffset,
//                                               int startIndexToDel, int EndIndexToDel) {
//        String serializedRange;
//        Highlight newHighlight;
//
//        if (startIndexToDel - currStartOffset > 0) {
//            serializedRange = String.format("%s-%s", currStartOffset, startIndexToDel);
//            newHighlight = new Highlight(highlight.getTabKey(), serializedRange, highlight.getStyle());
//            highlightsToAdd.add(newHighlight);
//        }
//
//        if (currEndOffset - EndIndexToDel > 0) {
//            serializedRange = String.format("%s-%s", EndIndexToDel, currEndOffset);
//            newHighlight = new Highlight(highlight.getTabKey(), serializedRange, highlight.getStyle());
//            highlightsToAdd.add(newHighlight);
//        }
//
//        return highlightsToAdd;
//    }
//}
//
