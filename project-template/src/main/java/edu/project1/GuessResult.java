package edu.project1;

import org.jetbrains.annotations.NotNull;

sealed interface GuessResult {
    @NotNull String message();

    @NotNull States state();

    record Defeat() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "HANGMAN WIN!";
        }

        @Override
        public @NotNull States state() {
            return States.LOSE;
        }
    }

    record Win() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "BIIIIIIG WIN";
        }

        @Override
        public @NotNull States state() {
            return States.WIN;
        }
    }

    record SuccessfulGuess() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "O my Good choice!";
        }

        @Override
        public @NotNull States state() {
            return States.SUCCESS_GUESS;
        }
    }

    record FailedGuess(int currentAttempt, int maxCountOfAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return String.format("Missed, mistake %d out of %d.", currentAttempt, maxCountOfAttempts);
        }

        @Override
        public @NotNull States state() {
            return States.FAIL_GUESS;
        }
    }

    record GameInterrupt() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "ha-ha-ha looser!";
        }

        @Override
        public @NotNull States state() {
            return States.GIVE_UP;
        }
    }

    record IncorrectInput() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Incorrect input!";
        }

        @Override
        public @NotNull States state() {
            return States.INPUT_FAIL;
        }
    }
}
