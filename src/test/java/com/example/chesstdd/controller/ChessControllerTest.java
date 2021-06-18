package com.example.chesstdd.controller;

import com.example.chesstdd.model.Tail;
import com.example.chesstdd.service.ChessService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChessControllerTest {

    @Autowired
    private ChessService chessService;


    @Test
    void startGame() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Tail> real = chessService.restartGame();
        StringBuilder stringBuilder = new StringBuilder();
        for (Tail tail : real) {
            stringBuilder.append(objectMapper.writeValueAsString(tail));
        }
        String expected = "{\"id\":0,\"figure\":{\"logo\":\"♖\"}}{\"id\":1,\"figure\":{\"logo\":\"♘\"}}{\"id\":2,\"figure\":{\"logo\":\"♗\"}}{\"id\":3,\"figure\":{\"logo\":\"♕\"}}{\"id\":4,\"figure\":{\"logo\":\"♔\"}}{\"id\":5,\"figure\":{\"logo\":\"♗\"}}{\"id\":6,\"figure\":{\"logo\":\"♘\"}}{\"id\":7,\"figure\":{\"logo\":\"♖\"}}{\"id\":8,\"figure\":{\"logo\":\"♙\"}}{\"id\":9,\"figure\":{\"logo\":\"♙\"}}{\"id\":10,\"figure\":{\"logo\":\"♙\"}}{\"id\":11,\"figure\":{\"logo\":\"♙\"}}{\"id\":12,\"figure\":{\"logo\":\"♙\"}}{\"id\":13,\"figure\":{\"logo\":\"♙\"}}{\"id\":14,\"figure\":{\"logo\":\"♙\"}}{\"id\":15,\"figure\":{\"logo\":\"♙\"}}{\"id\":16,\"figure\":null}{\"id\":17,\"figure\":null}{\"id\":18,\"figure\":null}{\"id\":19,\"figure\":null}{\"id\":20,\"figure\":null}{\"id\":21,\"figure\":null}{\"id\":22,\"figure\":null}{\"id\":23,\"figure\":null}{\"id\":24,\"figure\":null}{\"id\":25,\"figure\":null}{\"id\":26,\"figure\":null}{\"id\":27,\"figure\":null}{\"id\":28,\"figure\":null}{\"id\":29,\"figure\":null}{\"id\":30,\"figure\":null}{\"id\":31,\"figure\":null}{\"id\":32,\"figure\":null}{\"id\":33,\"figure\":null}{\"id\":34,\"figure\":null}{\"id\":35,\"figure\":null}{\"id\":36,\"figure\":null}{\"id\":37,\"figure\":null}{\"id\":38,\"figure\":null}{\"id\":39,\"figure\":null}{\"id\":40,\"figure\":null}{\"id\":41,\"figure\":null}{\"id\":42,\"figure\":null}{\"id\":43,\"figure\":null}{\"id\":44,\"figure\":null}{\"id\":45,\"figure\":null}{\"id\":46,\"figure\":null}{\"id\":47,\"figure\":null}{\"id\":48,\"figure\":{\"logo\":\"♟\"}}{\"id\":49,\"figure\":{\"logo\":\"♟\"}}{\"id\":50,\"figure\":{\"logo\":\"♟\"}}{\"id\":51,\"figure\":{\"logo\":\"♟\"}}{\"id\":52,\"figure\":{\"logo\":\"♟\"}}{\"id\":53,\"figure\":{\"logo\":\"♟\"}}{\"id\":54,\"figure\":{\"logo\":\"♟\"}}{\"id\":55,\"figure\":{\"logo\":\"♟\"}}{\"id\":56,\"figure\":{\"logo\":\"♜\"}}{\"id\":57,\"figure\":{\"logo\":\"♞\"}}{\"id\":58,\"figure\":{\"logo\":\"♝\"}}{\"id\":59,\"figure\":{\"logo\":\"♛\"}}{\"id\":60,\"figure\":{\"logo\":\"♚\"}}{\"id\":61,\"figure\":{\"logo\":\"♝\"}}{\"id\":62,\"figure\":{\"logo\":\"♞\"}}{\"id\":63,\"figure\":{\"logo\":\"♜\"}}";
        Assertions.assertEquals(expected, stringBuilder.toString());
    }
}