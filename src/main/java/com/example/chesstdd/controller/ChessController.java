package com.example.chesstdd.controller;

import com.example.chesstdd.model.Tail;
import com.example.chesstdd.service.ChessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChessController {

    private final ChessService chessService;

    public ChessController(ChessService chessService) {
        this.chessService = chessService;
    }

    @GetMapping("make_move")
    public List<Tail> makeMove() {
        return chessService.move();
    }

    @GetMapping("restart_game")
    public List<Tail> startGame() {
        List<Tail> tails = chessService.restartGame();
        return tails;
    }

}
