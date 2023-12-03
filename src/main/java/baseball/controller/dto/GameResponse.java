package baseball.controller.dto;

import baseball.domain.Calculator;

public record GameResponse(
        int strikeCount,
        int ballCount
) {

    public static GameResponse from(Calculator calculator) {

        final int strikeCount = calculator.calculateStrikeCount();
        final int ballCount = calculator.calculateSameNumberCount() - strikeCount;

        return new GameResponse(strikeCount, ballCount);
    }
}
