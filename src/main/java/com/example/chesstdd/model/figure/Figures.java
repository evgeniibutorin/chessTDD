//package com.example.chesstdd.model.figure;
//
//import com.example.chesstdd.model.Tail;
//import lombok.Getter;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
//public abstract class Figures implements Figure {
//
//
//    public List<Tail> possibleMoves(List<Tail> tails, List<List<Integer>> figureMoves, int widthPosition, int heightPosition) {
//        List<Tail> possibleTalesForMove = new ArrayList<>();
//        for (List<Integer> move : figureMoves) {
//            int newWidth = widthPosition + move.get(0);
//            int newHeight = heightPosition + move.get(1);
//            for (Tail tail : tails) {
//                if (tail.getTailWidth() == newWidth && tail.getTailHeight() == newHeight) {
//                    possibleTalesForMove.add(tail);
//                    break;
//                }
//            }
//        }
//        tailsToMove = possibleTalesForMove;
//        return possibleTalesForMove;
//    }
//
//
//
//    public List<Integer> coordinateForTheMove(List<Tail> tailsToMove) {
//        Random random = new Random();
//        Tail tail = tailsToMove.get(random.nextInt(tailsToMove.size()));
//
//        int widthPosition = tail.getTailWidth();
//        int heightPosition = tail.getTailHeight();
//        return Arrays.asList(widthPosition, heightPosition);
//    }
//
//}
