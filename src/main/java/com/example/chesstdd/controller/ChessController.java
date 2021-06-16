package com.example.chesstdd.controller;

import com.example.chesstdd.model.Tail;
import com.example.chesstdd.service.ChessService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChessController {

    private final ChessService chessService;

    public ChessController(ChessService chessService) {
        this.chessService = chessService;
    }

    @GetMapping("make_move")
    @ResponseBody
    public List<Tail> makeMove() {
        List<Tail> tails = chessService.move();
        return tails;
    }

    @GetMapping("restart_game")
    @ResponseBody
    public List<Tail> startGame() {
        List<Tail> tails = chessService.restarterGane();
        return tails;
    }

}
